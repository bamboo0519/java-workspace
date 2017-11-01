package top.ibamboo.account.dao;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by bamboo on 2017/8/29.
 */
@Repository
public class AccountDao extends SqlSessionDaoSupport {
    public final static String sqlSessionFactoryName = "defaultUserSqlSessionFactory";

    @Autowired
    @Resource(name = sqlSessionFactoryName)
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
    {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
