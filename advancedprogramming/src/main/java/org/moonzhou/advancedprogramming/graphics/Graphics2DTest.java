package org.moonzhou.advancedprogramming.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Graphics2DTest {

    public static void main(String[] args) {
        try {
            String text = "文字居中";


            File testImg = new File("E:/test/test.png");

            Image srcImg = ImageIO.read(testImg);

            // 创建BufferedImage对象
            int width = srcImg.getWidth(null);
            int height = srcImg.getHeight(null);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


            // 获取Graphics2D  
            Graphics2D g2d = image.createGraphics();
            // 画图
            g2d.drawImage(srcImg, 0, 0, width, height, null);
            g2d.setBackground(new Color(255, 255, 255));
            //g2d.setPaint(new Color(0,0,0));  
            g2d.setColor(Color.red);
//            g2d.clearRect(0, 0, width, height);
            Font font = new Font("宋体", Font.PLAIN, 16);
            g2d.setFont(font);
            // 抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));


            JLabel label = new JLabel(text);
            FontMetrics fm = label.getFontMetrics(font);
            // 计算文字长度，计算居中的x点坐标
//            FontMetrics fm = g2d.getFontMetrics(font);
            int textWidth = fm.stringWidth(text) * 4;
            int textHeight = fm.getHeight() * 4;


            int cols = width / textWidth;
            int rows = height / textHeight;

            System.out.println(width);
            System.out.println(height);
            System.out.println(textWidth);
            System.out.println(textHeight);
            System.out.println(cols);
            System.out.println(rows);

            for (int j = 0; j < rows; j++) {
//                g2d.rotate(Math.toRadians(-45), (double) textWidth, (double) textHeight);
                for (int i = 0; i < cols; i++) {
                    // 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
                    g2d.drawString(text, (i + 1) * textWidth, j * textHeight);
                }
            }

            // 释放对象
            g2d.dispose();

            // 保存文件      
            ImageIO.write(image, "jpg", new File("E:/test/test6.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}