package lhc.nio;

/**
 * @author arron lu
 * @version 1.0
 * @date 2020/7/17 23:15
 */

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * AAA
 * BBB
 * CCC
 * new CCC(new BBB(new (CCC)))  ---->装饰模式
 */
public class NioTest1 {
    /**
     * java.io
     * java.nio
     *
     * java.io 中最为核心的一个概念是流(Stream)，面向流的编程
     * 要么就是输入流，要么就是输出流，一个类只能继承一个类，不可能同时既是输入流又是输出流
     * java.nio 有三个核心概念
     * Selector，channel，buffer，在java.nio 我们面向块（block）或者缓冲区（buffer）编程
     *             selector
     *          /     ｜         \
     *    channel   channel    channel
     *    /           ｜           \
     *  buffer      buffer       buffer
     *  buffer本身就是一块内存，底层实现上就是一块数组。数据的读与写都是buffer来实现的。
     *  数据从channel读到buffer当中
     *
     *  除了数组之外，buffer提供了对数据的结构化访问方式，并且可以追踪到系统的读写过程。
     *  8种原生数据类型，bytebuffer，longbuffer，charbuffer等
     *  channel指的是可以向其写入数据或者从中读取数据的对象，他类似于java.io中的stream
     *  所有的数据都是通过buffer来进行的，永远不会出现直接向channel写入数据的情况，或直接从channel读取数据的情况
     *  与stream不同的是channel是双向的，一个流只可能是读入流或者是输出流
     *  由于channel是双向的，所以他能更好的反映出底层操作系统的真实情况，底层操作系统的通道就是双向的
     *  关于Nio buffer中3个重要属性的含义：position，limit，capacity
     * @param args
     */

    public static void main(String[] args) {
        IntBuffer buffer=IntBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            int randomNumber=new SecureRandom().nextInt(20);
            buffer.put(randomNumber);

        }
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

    }

}
