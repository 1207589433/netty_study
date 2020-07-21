package lhc.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/20 22:11
 */
//26857
//25172
public class OldClient {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("localhost",8899);

        String fileName="/Users/arronlu/Movies/John.Wick.Chapter.3.Parabellum.2019.1080p.BluRay.x264.DTS-HD.MA.7.1-HDC/John.Wick.Chapter.3.Parabellum.2019.1080p.BluRay.x264.DTS-HD.MA.7.1-HDC.mkv";
        InputStream inputStream=new FileInputStream(fileName);
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        byte[] buffer=new byte[4096];
        long readCount;
        long total=0;
        long startTime = System.currentTimeMillis();
        while ((readCount=inputStream.read(buffer))>0){
            total+=readCount;
            dataOutputStream.write(buffer);
        }
        System.out.println("发送字节数"+total+",耗时："+(System.currentTimeMillis()-startTime));
        dataOutputStream.close();
        socket.close();
        inputStream.close();

    }
}
