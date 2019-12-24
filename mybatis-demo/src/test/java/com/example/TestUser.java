package com.example;

import com.example.mapper.UserMapper;
import com.example.domain.UserDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

/**
 * 參考資料 https://mybatis.org/mybatis-3/zh/getting-started.html
 * @author xukai
 */
public class TestUser {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void testCommon() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserDO> userDOList = userMapper.queryAll();
        for (UserDO userDO : userDOList) {
            System.out.printf("%s %d\n", userDO.getName(), userDO.getAge());
        }
    }

    @Test
    public void testQueryUserByName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserDO userDO = userMapper.queryUserByName("xukai");
        System.out.printf("%s %d\n", userDO.getName(), userDO.getAge());
    }

}
