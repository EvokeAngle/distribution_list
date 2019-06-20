package netty.hello2_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: luojian
 * @Since: 2019/6/3 9:30
 * @Description: 请说明本类详情
 */
public class TestServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        ctx.writeAndFlush("miaomiao");
    }
}
