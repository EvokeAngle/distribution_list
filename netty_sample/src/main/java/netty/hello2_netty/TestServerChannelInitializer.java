package netty.hello2_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: luojian
 * @Since: 2019/6/3 8:55
 * @Description: 请说明本类详情
 */
public class TestServerChannelInitializer extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        ChannelPipeline pipeline = ctx.pipeline();
        pipeline.addLast("handler", new TestServerHandler());


    }
}
