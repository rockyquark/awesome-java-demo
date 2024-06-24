package org.keep.demo.generator;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.bytecode.annotation.Annotation;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class MyCommentGenerator implements CommentGenerator {

    private Properties properties = new Properties();
    /**
     * 抑制日期  默认false：不抑制
     */
    private boolean suppressDate = false;
    /**
     * 抑制注释 默认false：不抑制
     */
    private boolean suppressAllComments = false;

    /**
     * 显示数据库comments 默认false：不显示
     */
    private boolean addRemarkComments = false;
    /**
     * 日期格式
     */
    private SimpleDateFormat dateFormat;

    public MyCommentGenerator() {
        super();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        log.info("properties={}", JSON.toJSONString(properties));
        this.suppressDate = StringUtility.isTrue(properties.getProperty("suppressDate"));
        this.suppressAllComments = StringUtility.isTrue(properties.getProperty("suppressAllComments"));
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
        String dateFormatString = properties.getProperty("dateFormat");
        if (StringUtility.stringHasValue(dateFormatString)) {
            this.dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        // 在这里添加字段注释的逻辑
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        topLevelClass.addImportedType("lombok.*");

        // 在这里添加实体类注释的逻辑
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @note " + introspectedTable.getRemarks());
        topLevelClass.addJavaDocLine(" * @createdDate " + getDateString());
        topLevelClass.addJavaDocLine(" */");

        // 创建一个注解实例，并设置注解的名称
        topLevelClass.addAnnotation("@Getter");
        topLevelClass.addAnnotation("@Setter");
        topLevelClass.addAnnotation("@ToString");
        topLevelClass.addAnnotation("@Builder(toBuilder = true)");
        topLevelClass.addAnnotation("@NoArgsConstructor");
        topLevelClass.addAnnotation("@AllArgsConstructor");
    }




    @Override
    public void addClassAnnotation(InnerClass innerClass,
                                   IntrospectedTable introspectedTable,
                                   Set<FullyQualifiedJavaType> imports) {

        CommentGenerator.super.addClassAnnotation(innerClass, introspectedTable, imports);
    }



    /**
     * 日期格式化
     *
     * @return 格式化后的日期
     */
    protected String getDateString() {
        if (this.suppressDate) {
            return null;
        } else {
            return this.dateFormat != null ? this.dateFormat.format(new Date()) : (new Date()).toString();
        }
    }
}