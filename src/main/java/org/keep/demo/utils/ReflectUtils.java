package org.keep.demo.utils;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 反射工具类
 * @date 2024/1/24 17:43
 */
public class ReflectUtils {

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

    public static List<Class<?>> getInterfaceImplementations(Class<?> interfaceClass) {

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
}
