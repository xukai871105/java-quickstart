package com.example.jdbc.template;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class AppTestDemo {

    private static DriverManagerDataSource dataSource;

    @BeforeClass
    public static void beforeClass(){
        /**
         * 使用Spring方式可以@Bean方式构造
         * @Bean("dataSource")
         */
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/iotwuxi");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");
    }

    @Test
    public void testJdbcTemplate() {

        // 创建JDBC模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 这里也可以使用构造方法
        jdbcTemplate.setDataSource(dataSource);

        // sql语句
        String sql = "select count(*) from countries";
        Long num = (long) jdbcTemplate.queryForObject(sql, Long.class);

        System.out.println("Total Records :" + num);
    }

    @Test
    public void testJdbcQuery() {
        // 创建JDBC模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 这里也可以使用构造方法
        jdbcTemplate.setDataSource(dataSource);
        // sql语句
        String sql = "select * from countries";

        List<Country> countries = jdbcTemplate.query(sql, new CountryMapper());
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }


}
