package lhc.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/20 22:04
 */
public class OldServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                byte[] byteArray = new byte[4096];
                while (true) {
                    //直接丢弃掉处理
                    int readCount = dataInputStream.read(byteArray, 0, byteArray.length);
                    if (-1 == readCount) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
