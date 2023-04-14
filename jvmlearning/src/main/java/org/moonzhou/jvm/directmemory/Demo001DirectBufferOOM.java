package org.moonzhou.jvm.directmemory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx128m -XX:MaxDirectMemorySize=100M
 *
 * 输出100
 * java.lang.OutOfMemoryError: Direct buffer memory
 * @author moon zhou
 */
public class Demo001DirectBufferOOM {

    public static void main(String[] args) {
        int _1M = 1024 * 1024 * 1;
        List<ByteBuffer> buffers = new ArrayList<>();

        int count = 1;
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1M);
            buffers.add(byteBuffer);
            System.out.println(count++);
        }
    }
}