package org.moonzhou.dailyprogramming.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipFile;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/14 13:04
 */
@Slf4j
public class ZipFileTest {
    public static void main(String[] args) {
        Path tmpFolder = Paths.get(System.getProperty("user.home"), "tmp");
        Path zipFilePath = tmpFolder.resolve("zm-test-app.zip");
        log.info("tmp folder: {}, zip file path: {}", tmpFolder, zipFilePath.toAbsolutePath());

        try (ZipFile zipFile = new ZipFile(String.valueOf(zipFilePath))) {
            zipFile.stream()
                    .filter(zipEntry -> zipEntry.getName().endsWith("png"))
                    .findFirst()
                    .ifPresent(attachmentFile -> {
                        log.info("attachment file name: {}", attachmentFile.getName());
                        try (InputStream attachmentFileInputStream = zipFile.getInputStream(attachmentFile)) {
                            String name = attachmentFile.getName(); // 压缩包里的文件相对路径

                            // 将压缩包里的附件，直接解压到base目录下邮件模板的文件夹
                            Path attachmentFilePath = tmpFolder.resolve("ziptest")
                                    .resolve(name.substring(name.lastIndexOf(File.separator) + 1));
                            log.info("attachment file path: {}, copy dest file path: {}", attachmentFile, attachmentFilePath);

                            copy(attachmentFileInputStream, attachmentFilePath);
                        } catch (IOException e) {
                            log.error("upload email template attachment error: ", e);
                        }
                    });
        } catch (IOException e) {
            log.error("zip file operation error: ", e);
            throw new RuntimeException(e);
        }
    }

    public static Path copy(InputStream inputStream, Path path) throws IOException {
        // 如果目录不存在，则创建，否则会报 NoSuchFileException
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        // 拷贝至文件中
        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        return path;
    }
}
