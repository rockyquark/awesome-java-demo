package org.keep.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note: TODO
 * @date 2023/10/20 0:53
 */

@Slf4j
@Configuration
public class PrimaryDataSourceConfig {

    private static final String PRIMARY_MAPPER_LOCATION = "classpath*:/mapper/primary/*.xml";
    private static final String PRIMARY_BASE_PACKAGE = "org.keep.demo.mapper.primary";

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("primaryDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 配置mybatis 注意是 setMapperLocations() 方法 不是 setConfigLocation()
        // 配置mybatis 注意是 getResources() 方法 不是 getResource()
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(PRIMARY_MAPPER_LOCATION));

        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public MapperScannerConfigurer primaryMapperScannerConfigurer() {
        // 注意，这里使用的是 primarySqlSessionFactory 不要设置成 primarySqlSessionTemplate
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("primarySqlSessionFactory");
        configurer.setBasePackage(PRIMARY_BASE_PACKAGE);
        return configurer;
    }

}
