package lhc.nio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/19 21:31
 */
public class NioClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));
            while (true) {
                selector.select();
                Set<SelectionKey> keySets = selector.selectedKeys();
                for (SelectionKey selectionKey : keySets) {
                    if (selectionKey.isConnectable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if (client.isConnectionPending()) {
                            client.finishConnect();

                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            byteBuffer.put((LocalDateTime.now() + "连接成功").getBytes());
                            byteBuffer.flip();
                            client.write(byteBuffer);
                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                try {
                                    byteBuffer.clear();
                                    InputStreamReader input = new InputStreamReader(System.in);
                                    BufferedReader br = new BufferedReader(input);
                                    String msg = br.readLine();
                                    byteBuffer.put(msg.getBytes());
                                    byteBuffer.flip();
                                    client.write(byteBuffer);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel client = (SocketChannel)selectionKey.channel();
                        ByteBuffer readBuffer=ByteBuffer.allocate(1024);
                        int count=client.read(readBuffer);
                        if (count>0){
                            String msg=new String(readBuffer.array(),0,count);
                            System.out.println(msg);
                        }
                    }
                }
                keySets.clear();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
