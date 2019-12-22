package com.example.mapper;

import com.example.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xukai
 */
public interface UserMapper {
    List<UserDO> queryAll();

    UserDO queryUserByName(@Param("name") String name);
}
