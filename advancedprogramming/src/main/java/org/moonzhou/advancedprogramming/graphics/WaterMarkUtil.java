/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: WaterMarkUtil.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/8/7 9:50
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.graphics;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WaterMarkUtil {
    /**
     * @param input            源图片流
     * @param waterMarkContent 水印内容(传sn+工号)
     * @return String
     * @description
     */
    public static byte[] addWatermarkTransByte(InputStream input, String waterMarkContent) {
        long time1 = System.currentTimeMillis();

        byte[] data = new byte[]{};
        Color markContentColor = Color.gray;//水印颜色
        float alpha = 0.5f;//设置水印透明度 默认为1.0  值越小颜色越浅
        InputStream is = null;
        try {
            is = input;
            Image srcImg = ImageIO.read(is);//文件转化为图片
            if (null == srcImg) {
                return data;
            }
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            int size = srcImgWidth / 300 * 17;
            //防止水印没有大小
            if (size == 0) {
                size = 17;
            }
            Font font = new Font("宋体", Font.BOLD, size);//水印字体，大小
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();//得到画笔
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //设置水印颜色
            g.setFont(font);              //设置字体
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));//设置水印文字透明度
            JLabel label = new JLabel(waterMarkContent);

            long time2 = System.currentTimeMillis();

            FontMetrics metrics = label.getFontMetrics(font);
            int width = metrics.stringWidth(waterMarkContent) + metrics.stringWidth(waterMarkContent) / 5;//文字水印的宽
            int height = metrics.getHeight() * 2;//文字水印的高
            int columnsNumber = srcImgWidth / width;
            int rowsNumber = srcImgHeight / height;
            //防止图片太小而文字水印太长，所以至少打印一次
            if (rowsNumber < 1) {
                rowsNumber = 1;
            }
            if (columnsNumber < 1) {
                columnsNumber = 1;
            }

            for (int j = 0; j < rowsNumber; j++) {
                for (int i = 0; i < columnsNumber; i++) {
                    g.drawString(waterMarkContent, i * width, j * height);//画出水印,并设置水印位置
                }
            }

            long time3 = System.currentTimeMillis();

            g.dispose();// 释放资源

            //输出流
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(bufImg, "png", stream);
            data = stream.toByteArray();

            long time4 = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != input) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return data;
    }
}
