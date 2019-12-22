package com.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xukai
 */
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger log = LoggerFactory.getLogger(UdpServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        log.info("received: {}", msg);
        ByteBuf requestBuf = (ByteBuf)msg.content();
        log.info("received bytebuf: {}", ByteBufUtil.hexDump(requestBuf));
        byte[] request = new byte[requestBuf.readableBytes()];
        requestBuf.readBytes(request);

        ByteBuf responseBuf = Unpooled.copiedBuffer(request);
        DatagramPacket responsePacket= new DatagramPacket(responseBuf, msg.sender());
        log.info("send: {}", responsePacket);
        ctx.write(responsePacket);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 必须要写
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
