package netty.netty_protobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: luojian
 * @Since: 2019/6/2 9:24
 * @Description: 请说明本类详情
 */
public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        // 负责进行链接   work负责处理后台任务
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup  work = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(boss, work).
                    channel(NioServerSocketChannel.class).
                    childHandler(new ServerChannelInitializer());

            ChannelFuture channelFuture = server.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }

    }
}