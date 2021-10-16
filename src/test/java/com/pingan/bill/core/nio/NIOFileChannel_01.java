package com.pingan.bill.core.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOFileChannel_01 {
    public static void main(String[] args) throws IOException {
        String str="hello,尚硅谷";
        FileOutputStream fileOutputStream=new FileOutputStream("g:/test/file01.txt");
        //fileChannel的实现类型是FileChannelImpl
        FileChannel fileChannel=fileOutputStream.getChannel();
        //创建一个ByteBuffer
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();

    }
}
