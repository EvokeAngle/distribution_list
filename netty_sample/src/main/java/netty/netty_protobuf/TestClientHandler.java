package netty.netty_protobuf;

import com.moqinc.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: luojian
 * @Since: 2019/6/2 9:51
 * @Description: 请说明本类详情
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setAge(12)
                .setAddress("beijing")
                .setName("miaomiao").build();
        ctx.writeAndFlush(person);

    }
}
