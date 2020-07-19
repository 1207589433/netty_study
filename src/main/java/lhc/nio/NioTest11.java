package lhc.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 关于buffer的scattering与gathering
 */
public class NioTest11 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);
        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[0] = ByteBuffer.allocate(3);
        buffers[0] = ByteBuffer.allocate(4);
        SocketChannel socketChannel = serverSocketChannel.accept();
        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength) {
                long r = socketChannel.read(buffers);
                bytesRead += r;
                System.out.println("byteRead:" + bytesRead);
                Arrays.asList(buffers).
                        stream().
                        map(buffer -> "position" + buffer.position() + ",limit:" + buffer.limit()).
                        forEach(System.out::println);
            }
            Arrays.asList(buffers).forEach(b -> b.flip());
            long byteWritten = 0;
            while (byteWritten < messageLength) {
                long write = socketChannel.write(buffers);
                byteWritten += write;
            }
            Arrays.asList(buffers).forEach(buffer -> {
                buffer.clear();
            });
            System.out.println("byteRead"+bytesRead+",byteWritten"+byteWritten+",messageLength"+messageLength);
        }


    }
}
