package cn.centychen.example.spring.cloud.biz.a.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class ChatClient {
    private static Logger log = LoggerFactory.getLogger("ChatClient");

    public static void main(String[] args) throws IOException {
        String host = "10.211.23.108";
        int port = 8080;

        //与服务端建立连接
        Socket socket = new Socket(host, port);
        socket.setOOBInline(true);

        //建立连接后获取输出流
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());

        Scanner input = new Scanner(System.in);

        while (true) {
            String str = input.next();
            if ("0".equals(str)) {
                break;
            }
            byte[] b_utf8 = str.getBytes("UTF-8");

            outputStream.write(b_utf8);
            String content = "";
            byte[] buff = new byte[1024];
            inputStream.read(buff);
            String buffer = new String(buff, "utf-8");
            if (StringUtils.isBlank(buffer)) {
                break;
            }
            content += buffer;
            log.info("content: {}", content);

        }
        socket.close();
    }
}