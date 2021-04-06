package org.honorcloud.code.xchat.domain.vo;

import java.util.List;

import org.honorcloud.code.xchat.domain.mo.User;
import org.honorcloud.code.xchat.enums.MessageTypeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 聊天室动态消息
 *
 * @author yanpanyi
 * @date 2019/3/22
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DynamicMsgVo extends MessageVO {

    /**
     * 在线人数
     */
    private int onlineCount;

    /**
     * 在线用户列表
     */
    private List<User> onlineUserList;

    @Override
    public MessageTypeEnum getType() {
        return MessageTypeEnum.SYSTEM;
    }
}
