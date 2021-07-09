package org.moonzhou.dailyprogramming.decode;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public final class StringUtils {

    private StringUtils() {
    }

    public static String newStringUtf8(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static byte[] getBytesUtf8(String str) {
        return str == null ? new byte[0] : str.getBytes(StandardCharsets.UTF_8);
    }

    public static String escapeHTML(String content) {
        if (content == null) {
            return null;
        }
        StringWriter writer = new StringWriter((int) (content.length() * 1.2));
        int sz = content.length();
        for (int i = 0; i < sz; i++) {
            char ch = content.charAt(i);
            switch (ch) {
                case '<':
                    writer.write("&lt;");
                    break;
                case '>':
                    writer.write("&gt;");
                    break;
                case '&':
                    writer.write("&amp;");
                    break;
                default:
                    writer.write(ch);
                    break;
            }
        }
        return writer.toString();
    }
}
