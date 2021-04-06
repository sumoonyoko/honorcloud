package org.honorcloud.code.xchat.domain.dto;

import org.honorcloud.code.xchat.domain.mo.User;
import org.honorcloud.code.xchat.domain.vo.MessageVO;
import org.honorcloud.code.xchat.enums.MessageTypeEnum;
import org.springframework.beans.BeanUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 聊天记录数据传输层
 *
 * @author yanpanyi
 * @date 2019/4/4
 */
@Getter
@Setter
@ToString
public class ChatRecordDTO {

    /**
     * 用户信息
     */
    private User user;
    /**
     * 消息
     */
    private String message;
    /**
     * 图片
     */
    private String image;
    /**
     * 消息类型
     */
    private MessageTypeEnum type;
    /**
     * 发送时间
     */
    private String sendTime;

    public static ChatRecordDTO toChatRecordDTO(MessageVO messageVO) {
        if (null == messageVO) {
            return null;
        }

        ChatRecordDTO chatRecordDTO = new ChatRecordDTO();
        BeanUtils.copyProperties(messageVO, chatRecordDTO);

        return chatRecordDTO;
    }
}
