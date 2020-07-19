package lhc.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/19 15:05
 */
public class NioTest4 {
    //通过nio读取文件三个步骤
    //1，从fileinputstream获取到fileChannel对象
    //2，创建buffer
    //3，将数据从channel读取到buffer中
    //绝对方法和相对方法的含义
    //1，相对方法：limit值与position值会在操作时被考虑到
    //2，绝对方法：完全忽略掉limit与position的值
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream=new FileInputStream("input.txt");
        FileOutputStream outputStream=new FileOutputStream("output.txt");

        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

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
