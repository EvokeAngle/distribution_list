package netty.netty_protobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

/**
 * @Author: luojian
 * @Since: 2019/6/2 9:38
 * @Description: 请说明本类详情
 */
public class TestClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInnitializer() );
            ChannelFuture future = bootstrap.connect("localhost", 8899).sync();
            future.channel().closeFuture().sync();


        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
