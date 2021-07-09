package org.moonzhou.dailyprogramming.decode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Base64 url 安全加密算法 +/= 转为()*
 * 参考{@literal https://github.com/brsanthu/migbase64}
 *
 */

public final class UrlSafeBase64 {
    private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789()".toCharArray();
    private static final int[] IA = new int[256];
    private static final char PADDING_CHAR = '*';

    static {
        Arrays.fill(IA, -1);
        for (int i = 0, iS = CA.length; i < iS; i++)
            IA[CA[i]] = i;
        IA[PADDING_CHAR] = 0;
    }


    private UrlSafeBase64() {
    }

    public static String encodeString(byte[] binaryData) {
        return new String(encodeByte(binaryData), StandardCharsets.US_ASCII);
    }

    @SuppressWarnings("squid:ForLoopCounterChangedCheck")
    public static byte[] encodeByte(byte[] binaryData) {
        // Check special case
        int byteLen = binaryData != null ? binaryData.length : 0;
        if (byteLen == 0)
            return new byte[0];

        int evenLen = (byteLen / 3) * 3;              // Length of even 24-bits. 3的整数倍
        int charCount = ((byteLen - 1) / 3 + 1) << 2;   // Returned character count 长度为原始长度的4/3
        byte[] result = new byte[charCount];

        // Encode even 24-bits
        for (int s = 0, d = 0; s < evenLen; ) {
            // Copy next three bytes into lower 24 bits of int, paying attension to sign.
            int i = (binaryData[s++] & 0xff) << 16 | (binaryData[s++] & 0xff) << 8 | (binaryData[s++] & 0xff);

            // Encode the int into four chars
            result[d++] = (byte) CA[(i >>> 18) & 0x3f];
            result[d++] = (byte) CA[(i >>> 12) & 0x3f];
            result[d++] = (byte) CA[(i >>> 6) & 0x3f];
            result[d++] = (byte) CA[i & 0x3f];
        }

        // Pad and encode last bits if source isn't even 24 bits.
        int left = byteLen - evenLen; // 0 - 2.
        if (left > 0) {
            // Prepare the int
            int i = ((binaryData[evenLen] & 0xff) << 10) | (left == 2 ? ((binaryData[byteLen - 1] & 0xff) << 2) : 0);

            // Set last four chars
            result[charCount - 4] = (byte) CA[i >> 12];
            result[charCount - 3] = (byte) CA[(i >>> 6) & 0x3f];
            result[charCount - 2] = (byte) (left == 2 ? CA[i & 0x3f] : PADDING_CHAR);
            result[charCount - 1] = PADDING_CHAR;
        }
        return result;
    }


    @SuppressWarnings({"squid:ForLoopCounterChangedCheck", "squid:S3776"})
    public static byte[] decode(String value) {
        // Check special case
        int sLen = value != null ? value.length() : 0;
        if (sLen == 0)
            return new byte[0];

        // Count illegal characters (including '\r', '\n') to know what size the returned array will be,
        // so we don't have to reallocate & copy it later.
        int sepCnt = 0; // Number of separator characters. (Actually illegal characters, but that's a bonus...)
        for (int i = 0; i < sLen; i++)  // If input is "pure" (I.e. no line separators or illegal chars) base64 this loop can be commented out.
            if (IA[value.charAt(i)] < 0)
                sepCnt++;

        // Check so that legal chars (including '=') are evenly divideable by 4 as specified in RFC 2045.
        if ((sLen - sepCnt) % 4 != 0)
            throw new RuntimeException("invalid input: " + value + " ,length can't divide by 4");

        // Count '=' at end
        int pad = 0;
        for (int i = sLen; i > 1 && IA[value.charAt(--i)] <= 0; )
            if (value.charAt(i) == PADDING_CHAR)
                pad++;

        int len = ((sLen - sepCnt) * 6 >> 3) - pad;

        byte[] dArr = new byte[len];       // Preallocate byte[] of exact length

        for (int s = 0, d = 0; d < len; ) {
            // Assemble three bytes into an int from four "valid" characters.
            int i = 0;
            for (int j = 0; j < 4; j++) {   // j only increased if a valid char was found.
                int c = IA[value.charAt(s++)];
                if (c >= 0)
                    i |= c << (18 - j * 6);
                else
                    j--;
            }
            // Add the bytes
            dArr[d++] = (byte) (i >> 16);
            if (d < len) {
                dArr[d++] = (byte) (i >> 8);
                if (d < len)
                    dArr[d++] = (byte) i;
            }
        }
        return dArr;
    }


}
