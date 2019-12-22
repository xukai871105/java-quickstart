package com.example.mapper;

import com.example.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xukai
 */
public interface UserMapper {
    /**
     * 查找所有用户
     * @return
     */
    List<UserDO> queryAll();

    /**
     * 根据用户名 查用户
     * @param name
     * @return
     */
    UserDO queryUserByName(@Param("name") String name);
}
