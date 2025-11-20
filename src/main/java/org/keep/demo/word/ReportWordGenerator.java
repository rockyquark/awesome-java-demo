package org.keep.demo.word;

import org.docx4j.Docx4J;
import org.docx4j.convert.out.pdf.viaXSLFO.Conversion;
import org.docx4j.convert.out.pdf.viaXSLFO.PdfSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ReportWordGenerator {

    public static void main(String[] args) throws Exception {

        File wordFile = new File("C:\\Users\\MarchAwake\\Desktop\\1.docx");
        File pdfFile = new File("C:\\Users\\MarchAwake\\Desktop\\2.pdf");
        WordprocessingMLPackage pkg = WordprocessingMLPackage.load(wordFile);


//        PhysicalFonts.discoverPhysicalFonts();
//        System.out.println("======= 系统字体列表 =======");
//        for (String key : PhysicalFonts.getPhysicalFonts().keySet()) {
//            System.out.println(key);
//        }
//        System.out.println("=========================");
//
//
//
//
//        // **关键修正：明确加载 SimSun 子字体名称**
//        PhysicalFonts.discoverPhysicalFonts();
//
//        PhysicalFont simsun = PhysicalFonts.get("SimSun");
//        if (simsun == null) {
//            // .ttc 必须使用 discover 而不是手动 addPhysicalFonts
//            System.err.println("❌ 找不到 SimSun 字体，请确认系统安装了 宋体 simsun.ttc");
//            return;
//        }
//
//        Mapper fontMapper = new IdentityPlusMapper();
//
//        // Word 中常见中文字体全部映射到宋体
//        fontMapper.put("宋体", simsun);
//        fontMapper.put("SimSun", simsun);
//        fontMapper.put("NSimSun", simsun);
//        fontMapper.put("微软雅黑", simsun);
//        fontMapper.put("Microsoft YaHei", simsun);
//        fontMapper.put("黑体", simsun);
//        fontMapper.put("SimHei", simsun);
//
//        pkg.setFontMapper(fontMapper);

        Mapper fontMapper = new IdentityPlusMapper();

        PhysicalFont simsun = PhysicalFonts.get("simsun");
        PhysicalFont simhei = PhysicalFonts.get("simhei");
        PhysicalFont yahei = PhysicalFonts.get("microsoft yahei");
        PhysicalFont notoSans = PhysicalFonts.get("noto sans sc");   // 强力推荐，最通用
        PhysicalFont notoSerif = PhysicalFonts.get("noto serif sc");

// ======== 核心：所有中文字体强制映射到 noto sans sc（最安全）========
        PhysicalFont cnFont = notoSans != null ? notoSans : yahei != null ? yahei : simhei;

// Word 中可能出现的中文字体名（非常多）
        String[] possibleChineseFonts = {
                "宋体", "SimSun", "NSimSun", "新宋体",
                "黑体", "SimHei",
                "微软雅黑", "Microsoft YaHei",
                "等线", "DengXian",
                "仿宋", "FangSong",
                "楷体", "KaiTi",
                "隶书", "LiSu",
                "幼圆", "YouYuan",
                "思源黑体", "Noto Sans SC",
                "思源宋体", "Noto Serif SC",
                "宋体 (正文)",     // Word 特别喜欢插入这个名字
                "等线 (中文正文)"   // Word 有时加括号
        };

// 统一映射
        for (String f : possibleChineseFonts) {
            fontMapper.put(f, cnFont);
        }

// 设置映射
        pkg.setFontMapper(fontMapper);


        // 使用废弃但唯一有效的 Conversion
        try (OutputStream os = new FileOutputStream(pdfFile)) {
            PdfSettings settings = new PdfSettings();
            Conversion converter = new Conversion(pkg);
            converter.output(os, settings);
        }

        System.out.println("PDF 转换完成！");
    }
}
