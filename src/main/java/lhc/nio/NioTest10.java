package lhc.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/19 16:33
 */
public class NioTest10 {
    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile=new RandomAccessFile("NioTest10.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileLock fileLock=fileChannel.lock(3,6,true);
        System.out.println("valid:"+fileLock.isValid());
        System.out.println("lock type "+fileLock.isShared());
        fileLock.release();
        randomAccessFile.close();
    }
}
