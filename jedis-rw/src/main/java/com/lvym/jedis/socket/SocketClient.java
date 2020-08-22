package com.lvym.jedis.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7776);
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("mmmm".getBytes());
        socket.close();

    }
    }

