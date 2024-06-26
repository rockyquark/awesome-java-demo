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

    public static List<Class<?>> findClasses(String packageName) {

        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(path);
        if (resource != null) {
            File directory = new File(resource.getFile());
            if (directory.exists()) {
                findClassesInDirectory(packageName, directory, classes);
            }
        }

        return classes;
    }

    private static void findClassesInDirectory(String packageName, File directory, List<Class<?>> classes) {

        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                findClassesInDirectory(packageName + "." + file.getName(), file, classes);
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException ignore) {}
            }
        }
    }

    private static List<Class<?>> getInterfaceImplementations(Class<?> interfaceClass) {

        List<Class<?>> implementations = new ArrayList<>();

        // 获取所有类
        for (Package pkg : Package.getPackages()) {
            String packageName = pkg.getName();
            List<Class<?>> classes = findClasses(packageName);

            // 检查每个类是否实现了指定的接口
            for (Class<?> clazz : classes) {
                if (interfaceClass.isAssignableFrom(clazz) && !Modifier.isAbstract(clazz.getModifiers())) {
                    implementations.add(clazz);
                }
            }
        }

        return implementations;
    }


    @Bean
    public void load() {

//        Class<?> interfaceClass = IErrorType.class;
//        getInterfaceImplementations(interfaceClass);

//        System.out.println("Implementations of " + interfaceClass.getName() + ":");
//        for (Class<?> implementation : implementations) {
//            System.out.println(implementation.getName());
//        }

        log.info("{}", ErrorManager.getAllError());
        log.info("{}", AudioTranscodeErrorEnum.AUDIO_G726_TRANSCODE_FAILED.getFullReason());
    }
}
