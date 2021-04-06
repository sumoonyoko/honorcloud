package org.honorcloud.code.xchat.service;

/**
 * 机器人
 *
 * @author yanpanyi
 * @date 2019/4/9
 */
public interface RobotService {

    /**
     * 发送消息到机器人
     *
     * @param userId 发送人userId
     * @param text 发送的消息内容
     * @return 机器人的答复信息
     */
    String sendMessage(String userId, String text);
}
