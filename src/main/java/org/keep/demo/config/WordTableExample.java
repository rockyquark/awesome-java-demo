import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WordTemplateBinding {
    public static void main(String[] args) throws IOException {
        // 读取Word模板文件
        FileInputStream fis = new FileInputStream(new File("path/to/template.docx"));
        XWPFDocument document = new XWPFDocument(fis);

        // 遍历段落进行替换
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            for (XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0);
                // 检查是否包含占位符
                if (text != null && text.contains("${name}")) {
                    // 替换数据
                    text = text.replace("${name}", "张三");
                    run.setText(text, 0);
                }
            }
        }