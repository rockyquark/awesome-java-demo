package org.keep.demo.generator;

import lombok.NoArgsConstructor;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;





public class Generator {
    public static void main(String[] args)  {
        List<String> warnings = new ArrayList<>();
        // 覆盖
        boolean overwrite = true;
        // 给出generatorConfig.xml文件的位置
        File configFile = new File("src/main/resources/thirdGeneratorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        try {
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
