package com.example.dao;

import com.example.domain.UserDO;

import java.util.List;

public interface UserDAO {
    List<UserDO> queryAll();
}
