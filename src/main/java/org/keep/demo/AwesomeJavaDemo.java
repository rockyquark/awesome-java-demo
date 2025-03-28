package org.keep.demo;

import lombok.extern.slf4j.Slf4j;
import org.keep.demo.etd.AudioTranscodeErrorEnum;
import org.keep.demo.etd.ErrorManager;
import org.keep.demo.etd.IErrorType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;


/**
 * @author 肖锦光
 * @version 0.1.0
 * @note Java 实践案例项目 SpringBoot 入口
 * @date 2023/10/18 22:21
 */
@Slf4j
@SpringBootApplication
@EnableScheduling
public class AwesomeJavaDemo {

    public static void main(String[] args) {

        SpringApplication.run(AwesomeJavaDemo.class, args);
    }
}
