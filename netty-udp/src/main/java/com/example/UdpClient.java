package com.example;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SocketUtils;

/**
 * @author  xukai
 */
public class UdpClient {
    private static final int PORT = Integer.parseInt(System.getProperty("port", "50018"));
    private static final int TIMEOUT = 5000;

    public static void main(String[] args) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
                            String response = msg.content().toString(CharsetUtil.UTF_8);
                            System.out.println("Received: " + response);
                            ctx.close();
                        }
                    });

            Channel ch = b.bind(0).sync().channel();

            ch.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("Hello", CharsetUtil.UTF_8),
                    SocketUtils.socketAddress("127.0.0.1", PORT))).sync();

            // ClientHandler will close the DatagramChannel when a
            // response is received.  If the channel is not closed within 5 seconds,
            // print an error message and quit.
            if (!ch.closeFuture().await(TIMEOUT)) {
                System.err.println("request timed out.");
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
