package lhc.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/19 12:12
 */
public class NioTest3 {
    public static void main(String[] args) throws Exception{

        FileOutputStream outputStream=new FileOutputStream("NioTest3.txt");
        FileChannel channel = outputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(512);

        byte[] mes="hello word welcome".getBytes();
        for (int i = 0; i < mes.length; i++) {
            allocate.put(mes[i]);
        }
        allocate.flip();
        channel.write(allocate);
        outputStream.close();

    }
}
