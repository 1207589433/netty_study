package lhc.reactor.classic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/23 21:35
 */
public class BIOEchoServer {
    public static void main(String[] args) {
        Thread thread=new Thread(new BasicModel());
        thread.start();
    }

    static class BasicModel implements Runnable {
        public void run() {
            try {
                ServerSocket ss =
                        new ServerSocket(8899);
                while (!Thread.interrupted())
                    new Thread(new Handler(ss.accept())).start();
                //创建新线程来handle
                // or, single-threaded, or a thread pool
            } catch (IOException ex) { /* ... */ }
        }

        class Handler implements Runnable {
            final Socket socket;

            Handler(Socket s) {
                socket = s;
            }

            public void run() {
                try {
                    byte[] input = new byte[1024];
                    socket.getInputStream().read(input);
                    byte[] output = process(input);
                    socket.getOutputStream().write(output);
                } catch (IOException ex) { /* ... */ }
            }

            private byte[] process(byte[] input) {
                byte[] output = null;
                /* ... */
                return output;
            }
        }
    }
}
