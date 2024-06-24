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
 * @note icvr_speech 数据库配置
 * @date 2023/10/19 23:47
 */

@Slf4j
@Configuration
public class ThirdDataSourceConfig {

    private static final String MAPPER_LOCATION = "classpath*:/mapper/speech/*.xml";
    private static final String BASE_PACKAGE = "org.keep.demo.mapper.speech";

    @Bean(name = "speechDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.third")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "speechSqlSessionFactory")
    public SqlSessionFactory speechSqlSessionFactory(
            @Qualifier("speechDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 配置mybatis 注意是 setMapperLocations() 方法 不是 setConfigLocation()
        // 配置mybatis 注意是 getResources() 方法 不是 getResource()
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));

        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "speechSqlSessionTemplate")
    public SqlSessionTemplate speechSqlSessionTemplate(
            @Qualifier("speechSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer speechMapperScannerConfigurer() {

        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("speechSqlSessionFactory");
        configurer.setBasePackage(BASE_PACKAGE);
        return configurer;
    }
}
