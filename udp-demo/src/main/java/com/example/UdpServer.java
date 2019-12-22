package com.example;

import java.io.IOException;

/**
 * @author xukai
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        new UdpServerThread().start();
    }
}
