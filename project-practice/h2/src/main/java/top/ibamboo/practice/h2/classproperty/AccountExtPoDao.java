package top.ibamboo.practice.h2.classproperty;

import com.dtdream.commons.mybatis.BaseMyBatisDao;
import org.springframework.stereotype.Repository;
import top.ibamboo.account.model.Account;

/**
 * Created by bamboo on 2017/9/15.
 */
@Repository
public class AccountExtPoDao extends BaseMyBatisDao<Account> {
    public AccoutFullDto loadById(String accountId) {
        return getSqlSession().selectOne(sqlId("loadById"), accountId);
    }
}
