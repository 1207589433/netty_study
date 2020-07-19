package lhc.nio;


import java.nio.ByteBuffer;

/**
 * ByteBuffer 类型化的put与get方法
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(15);
        buffer.putLong(123123L);
        buffer.putDouble(12.33);
        buffer.putChar('a');
        buffer.flip();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());

    }

}
