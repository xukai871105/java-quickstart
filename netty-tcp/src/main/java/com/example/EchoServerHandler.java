package com.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author xukai
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(EchoServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestBuf = ((ByteBuf)msg);
        byte[] request = new byte[requestBuf.readableBytes()];
        // ByteBuf requestBuf  -> byte[] request
        requestBuf.readBytes(request);
        log.info("Hexdump: {}", ByteBufUtil.hexDump(request));

        // 翻转字节数组
        byte[] response = ArrayUtils.clone(request);
        ArrayUtils.reverse(response);
        ByteBuf responseBuf = Unpooled.buffer(request.length);
        responseBuf.writeBytes(response);

        // 两种方法都可以
        // ctx.channel().write(responseBuf);
        ctx.write(responseBuf);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}