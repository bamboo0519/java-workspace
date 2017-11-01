package repository.util.collection;

import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by bamboo on 2017/11/1.
 */

public class ListsOperation {
    class User {
        Long id;
        String account;
        String password;
        String mobile;
        String email;
    }

    @Data
    class Role {
        Long id;
        String name;
        String code;
        String description;
    }
    @Data
    class Privilege {
        Long id;
        String name;
        String code;
        String description;
    }
    @Data
    class RolePrivilege {
        Long id;
        Long roleId;
        Long privilegeId;
    }

    public Role createRole(Long id) {
        Role role = new Role();
        role.setId(id);
        role.setName("role_name_"+id);
        role.setCode("role_code_"+id);
        role.setDescription("role is "+ id);
        return role;
    }
    public List<Role> initRoleList(int count) {
        List<Role> roles = new ArrayList<>();
        for (int i=0; i<count; i++) {
            roles.add(createRole(i + 10000L));
        }
        return roles;
    }

    public Privilege createPrivilege(Long id) {
        Privilege privilege = new Privilege();
        privilege.setId(id);
        privilege.setName("privilege_name_"+id);
        privilege.setCode("privilege_code_"+id);
        privilege.setDescription("privilege is "+ id);
        return privilege;
    }
    public List<Privilege> initPrivilegeList(int count) {
        List<Privilege> privileges = new ArrayList<>();
        for (int i=0; i<count; i++) {
            privileges.add(createPrivilege(i + 20000L));
        }
        return privileges;
    }

    public RolePrivilege createRolePrivilege(Long roleId, Long privilegeId) {
        RolePrivilege rolePrivilege = new RolePrivilege();
        rolePrivilege.setId(roleId + 10000L);
        rolePrivilege.setRoleId(roleId);
        rolePrivilege.setPrivilegeId(privilegeId);
        return rolePrivilege;
    }

    @Data
    class RolePrivilegeListParam {
        Long roleId;
        String roleName;
        String roleCode;
        String roleDesc;
        List<Privilege> privileges;

        public RolePrivilegeListParam(Long roleId, String roleName, String roleCode, String roleDesc) {
            this.roleCode = roleCode;
            this.roleDesc = roleDesc;
            this.roleId = roleId;
            this.roleName = roleName;
        }
    }

    @Test
    public void test_Lists(){
        ListsOperation listsOperation = new ListsOperation();
        List<Role> roles = listsOperation.initRoleList(10);
        List<Privilege> privileges = listsOperation.initPrivilegeList(100);

        List<RolePrivilege> rolePrivileges = new ArrayList<>();
        rolePrivileges.add(createRolePrivilege(roles.get(1).getId(), privileges.get(2).getId()));
        rolePrivileges.add(createRolePrivilege(roles.get(1).getId(), privileges.get(3).getId()));
        rolePrivileges.add(createRolePrivilege(roles.get(1).getId(), privileges.get(4).getId()));
        rolePrivileges.add(createRolePrivilege(roles.get(3).getId(), privileges.get(4).getId()));
        rolePrivileges.add(createRolePrivilege(roles.get(4).getId(), privileges.get(4).getId()));


        /**
         * 需求： 根据role和privilege的关联关系，获取角色信息及其权限列表
         */
        // 1. 把Privileges 转换成Map<privilegeId, Privilege>
        Map<Long, Privilege> privilegeMap = privileges.stream().collect(Collectors.toMap(Privilege::getId, Privilege -> Privilege));

        // 2. 根据role查询role对应的privilege列表
        Map<Long, List<Privilege>> rolePrivilegesMap = new HashMap<>();
        for (RolePrivilege rolePrivilege : rolePrivileges) {
            rolePrivilegesMap.computeIfAbsent(rolePrivilege.getRoleId(), k -> new ArrayList<>());
            rolePrivilegesMap.get(rolePrivilege.getRoleId()).add(privilegeMap.get(rolePrivilege.getPrivilegeId()));
        }

        // 3. 使用Lists.transform转换roles
        List<RolePrivilegeListParam> rolePrivilegeParams = Lists.transform(roles, role -> {
            assert role != null;
            RolePrivilegeListParam param = new RolePrivilegeListParam(role.getId(),role.getName(),role.getCode(),role.getDescription());
            param.setPrivileges(rolePrivilegesMap.get(role.getId()));
            return param;
        });


        // 校验数据
        Assert.assertEquals(10, rolePrivilegeParams.size());
        Assert.assertEquals(3, rolePrivilegeParams.get(1).getPrivileges().size());
    }
}
