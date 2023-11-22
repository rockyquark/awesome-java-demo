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
 * @date 2023/10/19 23:47
 */

@Slf4j
@Configuration
public class SecondaryDataSourceConfig {

    private static final String SECONDARY_MAPPER_LOCATION = "classpath*:/mapper/secondary/*.xml";
    private static final String SECONDARY_BASE_PACKAGE = "org.keep.demo.mapper.secondary";

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondarySqlSessionFactory")
    public SqlSessionFactory secondarySqlSessionFactory(
            @Qualifier("secondaryDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 配置mybatis 注意是 setMapperLocations() 方法 不是 setConfigLocation()
        // 配置mybatis 注意是 getResources() 方法 不是 getResource()
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(SECONDARY_MAPPER_LOCATION));

        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "secondarySqlSessionTemplate")
    public SqlSessionTemplate secondarySqlSessionTemplate(
            @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer secondaryMapperScannerConfigurer() {

        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("secondarySqlSessionFactory");
        configurer.setBasePackage(SECONDARY_BASE_PACKAGE);
        return configurer;
    }
}
