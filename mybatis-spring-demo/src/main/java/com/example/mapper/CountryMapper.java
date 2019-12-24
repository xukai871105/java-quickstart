package com.example.mapper;


import com.example.domain.CountryDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xukai
 */
@Mapper
public interface CountryMapper  {

    /**
     * 查找所有的 国家记录
     * @return
     */
    List<CountryDO> findAllCountries();
}
