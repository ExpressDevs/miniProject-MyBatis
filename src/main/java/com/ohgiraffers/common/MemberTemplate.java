package com.ohgiraffers.common;

import com.ohgiraffers.mapper.MemberMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MemberTemplate {

    private static SqlSessionFactory sqlSessionFactory;

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/ticketdb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static SqlSession getMemberSqlSession() {

        if(sqlSessionFactory == null) {
            Environment environment = new Environment("dev"
                    , new JdbcTransactionFactory()
                    , new PooledDataSource(DRIVER, URL, USER, PASSWORD));

            Configuration configuration = new Configuration(environment);


            configuration.addMapper(MemberMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        return sqlSessionFactory.openSession(false);

    }
}
