package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author xukai
 */
public class UdpServerThread extends Thread {
    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean running = true;

    public UdpServerThread() throws IOException {
        this("UDPServerThread");
    }

    public UdpServerThread(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(4445);
    }

    @Override
    public void run() {
        while (running) {
            try {
                byte[] buf = new byte[256];

                // 获取请求数据
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                // send the response to the client at "address" and "port"
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                running = false;
            }
        }
        socket.close();
    }

}
