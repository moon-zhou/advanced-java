package org.moonzhou.dailyprogramming;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/7/28 10:19
 */
public class ConstructionParameter {
    public static void main(String[] args) {
        String format = "[%s]";

        String data = "{\"staffId\":\"xxx\",\"name\":\"ZHOU\",\"entmtAl\":\"1\",\"dedctAl\":\"2\",\"balncAl\":\"3\",\"rateAl\":\"4\",\"month\":\"10\"}, ";

        StringBuilder allData = new StringBuilder();
        for (int i = 0; i < 30000; i++) {
            allData.append(data);
        }

        String result = String.format(format, allData.substring(0, allData.length() - 2));
        // System.out.println(result);

        try {
            String fileName = System.getProperty("user.home") + File.separator + "tmp" + File.separator + "data.json";

            File fileText = new File(fileName);
            FileWriter fileWriter = new FileWriter(fileText);

            fileWriter.write(result);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
