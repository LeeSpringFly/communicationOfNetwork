package com.lee.communicationofnetwork.service;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NetworkServerHandler extends ChannelInboundHandlerAdapter {

    private int i = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(ctx.channel().remoteAddress()).append("\t活跃");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(ctx.channel().remoteAddress()).append("\t不活跃");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        if (!buf.hasArray()) {
            int length = buf.readableBytes();
            byte[] array = new byte[length];
            buf.getBytes(buf.readerIndex(), array);

            // 业务 ...
            ++i;
            System.out.println(i);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        try {
            super.exceptionCaught(ctx, cause);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ctx.close();
        }
    }

}