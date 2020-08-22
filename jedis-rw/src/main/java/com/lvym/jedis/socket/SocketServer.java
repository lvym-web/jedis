package com.lvym.jedis.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket=new ServerSocket(7776);
        Socket accept = socket.accept();
        InputStream reader = accept.getInputStream();
        byte[] bytes=new byte[1024];
        reader.read(bytes);
        String s = new String(bytes);
        System.out.println(s);
        socket.close();
    }



}
