package com.example.jdbc.template;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xukai
 */
public class CountryMapper  implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();

        country.setCountryName(resultSet.getString("country_name"));
        country.setCountryCode(resultSet.getString("country_code"));
        return country;
    }
}
