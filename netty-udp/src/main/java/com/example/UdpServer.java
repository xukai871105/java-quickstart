package com.example;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xukai
 */
public class UdpServer {

    private static final Logger log = LoggerFactory.getLogger(UdpServer.class);
    private static final Integer PORT = 50018;

    public void run(int port) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        log.info("udp server start ... ");
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .handler(new UdpServerInitializer());
            bootstrap.bind(port).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        UdpServer server = new UdpServer();
        server.run(PORT);
    }
}
