package org.moonzhou.distributedlock.util;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * zk基本测试操作<br>
 * 使用的是Apache zk client
 *
 * @author moon-zhou
 * @Date: 2020/1/16 19:56
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ZKClientTest {

    // 此demo使用的集群，所以有多个ip和端口
    private static String CONNECT_SERVER = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
    private static int SESSION_TIMEOUT = 3000;
    private static int CONNECTION_TIMEOUT = 3000;

    private static ZooKeeper zkClient;

    static {
        try {
            zkClient = new ZooKeeper(CONNECT_SERVER, SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    // 收到事件通知后的回调函数（应该是我们自己的事件处理逻辑）
                    System.out.println(watchedEvent.getType() + "---" + watchedEvent.getPath());
                    try {
                        zkClient.getChildren("/", true);
                    } catch (Exception e) {
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据的增删改查
     */
    // 创建数据节点到zk中
    @Test
    public void testCreate() throws Exception {
        //参数1，要创建的节点的路径 参数2：节点数据 参数3：节点的权限 参数4：节点的类型
        String node = zkClient.create("/idea", "hellozk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //上传的数据可以是任何类型，但都要转成byte[]
    }

    //获取子节点
    @Test
    public void getChildren() throws Exception{
        List<String> children = zkClient.getChildren("/", true);
        for (String child: children){
            System.out.println(child);
        }
    }
}
