package lhc.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/19 15:59
 */
public class NioTest8 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream=new FileInputStream("input.txt");
        FileOutputStream outputStream=new FileOutputStream("output.txt");

        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();
        //堆外内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true){
            buffer.clear();

            int read = inputStreamChannel.read(buffer);
            if (-1==read){
                break;
            }
            buffer.flip();
            outputStreamChannel.write(buffer);

        }
        inputStreamChannel.close();
        outputStreamChannel.close();
    }
}
