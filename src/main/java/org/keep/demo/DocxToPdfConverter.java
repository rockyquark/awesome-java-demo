package org.keep.demo;

import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.*;

public class DocxToPdfConverter {

    public static boolean convertDocxToPdf(String inputDocxPath, String outputPdfPath) {
        FileInputStream is = null;
        OutputStream os = null;

        try {
            System.out.println("开始转换: " + inputDocxPath);

            // 加载DOCX文档
            is = new FileInputStream(inputDocxPath);
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(is);

            // 设置字体映射（解决中文显示问题）
            setupFontMapper(wordMLPackage);

            // 准备输出流
            os = new FileOutputStream(outputPdfPath);

            // 配置PDF转换设置
            FOSettings foSettings = Docx4J.createFOSettings();
            foSettings.setWmlPackage(wordMLPackage);

            // 执行转换
            Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

            System.out.println("转换成功: " + inputDocxPath + " → " + outputPdfPath);
            return true;

        } catch (Exception e) {
            System.err.println("转换失败: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (is != null) is.close();
                if (os != null) os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置字体映射，解决中文显示问题
     */
    private static void setupFontMapper(WordprocessingMLPackage wordMLPackage) throws Exception {
        Mapper fontMapper = new IdentityPlusMapper();

        // 注册中文字体
        fontMapper.put("SimSun", PhysicalFonts.get("SimSun"));      // 宋体
        fontMapper.put("SimHei", PhysicalFonts.get("SimHei"));      // 黑体
        fontMapper.put("Microsoft YaHei", PhysicalFonts.get("Microsoft YaHei")); // 微软雅黑
        fontMapper.put("KaiTi", PhysicalFonts.get("KaiTi"));        // 楷体
        fontMapper.put("FangSong", PhysicalFonts.get("FangSong"));  // 仿宋

        // 设置字体映射
        wordMLPackage.setFontMapper(fontMapper);
    }

    // 测试方法
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\MarchAwake\\Desktop\\1.docx";
        String outputPath = "C:\\Users\\MarchAwake\\Desktop\\1.pdf";
        boolean success = convertDocxToPdf(inputPath, outputPath);
        if (success) {
            System.out.println("文档转换完成！");
        } else {
            System.out.println("文档转换失败！");
        }
    }
}