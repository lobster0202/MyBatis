package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(false);

            /* 결과가 하나일 때는 selectOne 결과가 여러 개 일 때는 selectList */
            java.util.Date date = session.selectOne("mapper.selectSysdate");

            System.out.println(date);
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
