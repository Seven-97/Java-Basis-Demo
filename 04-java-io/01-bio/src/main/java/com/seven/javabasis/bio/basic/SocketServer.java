package com.seven.javabasis.bio.basic;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Seven
 */
@Slf4j
public class SocketServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(83);

        try {
            while (true) {
                //这里会被阻塞，直到能获取到连接
                Socket socket = serverSocket.accept();

                //下面开始收取信息
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                //获取端口
                Integer sourcePort = socket.getPort();
                int maxLen = 2048;
                byte[] contextBytes = new byte[maxLen];

                //这里会被阻塞，直到有数据准备好
                int realLen = in.read(contextBytes, 0, maxLen);
                //读取信息
                String message = new String(contextBytes, 0, realLen);

                //打印信息
                log.info("服务器收到来自于端口: {}的信息: {}", sourcePort, message);

                Thread.sleep(10000);//模拟执行业务逻辑
                //开始发送信息
                out.write("回发响应信息！".getBytes());

                //关闭
                out.close();
                in.close();
                socket.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}

