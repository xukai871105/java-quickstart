package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author xukai
 */
@Configuration
public class DataSourceConfig {

    @Bean("dataSource")
    public DataSource buildDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/iotwuxi");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory buildSqlSessionFactory(DataSource dataSource)
                                             throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // factoryBean.setTransactionFactory(new ManagedTransactionFactory());
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:sqlmapper/*.xml"));
        return factoryBean.getObject();
    }
}
