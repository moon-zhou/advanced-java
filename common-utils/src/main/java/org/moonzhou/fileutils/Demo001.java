package org.moonzhou.fileutils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/14 19:22
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {
    public static void main(String[] args) {
        // 拷贝文件
        File fileA = new File("E:\\test\\test.jpg");
        File fileB = new File("E:\\test1\\test.jpg");
        try {
            FileUtils.copyFile(fileA,fileB);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 按照指定文件后缀如java,txt等去查找指定文件夹的文件
        File directory = new File("E:\\test");
        Collection<File> fileList = FileUtils.listFiles(directory, new String[]{"txt"}, false);
        fileList.forEach(file -> System.out.println(file.getAbsolutePath()));


        try {
            // 读取指定文件所有行 不需要使用 while 循环读取流了
            File fileC = new File("E:\\test\\jmh-map.log");
            List<String> lines = FileUtils.readLines(fileC);
            lines.forEach(System.out::println);

            // 可以一行行写入文本
            File fileD = new File("E:\\test1\\jmh-map.log");
            FileUtils.writeLines(fileD, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
