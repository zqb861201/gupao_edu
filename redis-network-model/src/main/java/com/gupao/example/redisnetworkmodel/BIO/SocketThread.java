package com.gupao.example.redisnetworkmodel.BIO;

import java.io.*;
import java.net.Socket;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class SocketThread implements Runnable{

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //inputstream是阻塞的(***)
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"GBK")); //表示获取客户端的请求报文
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));

            String clientStr = null;
            do {
                clientStr = bufferedReader.readLine();
                System.out.println("收到客户端发送的消息：" + clientStr);
                bufferedWriter.write("receive a message:" + clientStr + "\n");
                bufferedWriter.flush();
            }while(clientStr==null || !clientStr.equals("closeChannel"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //TODO 关闭IO流
            try {
                if(bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
