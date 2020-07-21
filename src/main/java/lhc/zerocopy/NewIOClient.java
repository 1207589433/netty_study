package lhc.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
public class NewIOClient {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(true);
        String fileName="/Users/arronlu/Movies/John.Wick.Chapter.3.Parabellum.2019.1080p.BluRay.x264.DTS-HD.MA.7.1-HDC/John.Wick.Chapter.3.Parabellum.2019.1080p.BluRay.x264.DTS-HD.MA.7.1-HDC.mkv";

        FileChannel fileChannel=new FileInputStream(fileName).getChannel();

        long l = System.currentTimeMillis();
        long count = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送字节信息："+count+"耗时："+(System.currentTimeMillis()-l));
        fileChannel.close();

    }
}
