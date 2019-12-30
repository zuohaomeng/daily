package com.meng.daily.netty.echo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author 梦醉  客户端逻辑处理
 * @date 2019/12/28--22:21
 */
//使用SimpleChannelInboundHandler处理所有必须的任务
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    //连接时调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //当被通知Channel是活跃的时候，发送一条消息
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks，too", CharsetUtil.UTF_8));

    }

    //每条消息时调用
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf aByte) throws Exception {
        //记录已接受的消息
        System.out.println("Client received: "+aByte.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    //异常时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //记录并关闭Channel
        cause.printStackTrace();
        ctx.close();
    }
}
