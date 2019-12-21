package com.example.mapper;

import com.example.domain.UserDO;

import java.util.List;

public interface UserMapper {
    List<UserDO> queryAll();
}
