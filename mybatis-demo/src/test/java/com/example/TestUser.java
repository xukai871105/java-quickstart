package com.example;

import com.example.dao.UserDAO;
import com.example.domain.UserDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestUser {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception, IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void testCommon() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        List<UserDO> userDOList = userDAO.queryAll();
        for (UserDO userDO : userDOList) {
            System.out.printf("%s %d\n", userDO.getName(), userDO.getAge());
        }
    }

}
