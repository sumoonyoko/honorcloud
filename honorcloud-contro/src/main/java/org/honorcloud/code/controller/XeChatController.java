package org.honorcloud.code.controller;

import javax.annotation.Resource;

import org.honorcloud.code.xchat.constant.RobotConstant;
import org.honorcloud.code.xchat.constant.StompConstant;
import org.honorcloud.code.xchat.domain.mo.User;
import org.honorcloud.code.xchat.domain.ro.MessageRO;
import org.honorcloud.code.xchat.domain.ro.RevokeMessageRO;
import org.honorcloud.code.xchat.domain.vo.MessageVO;
import org.honorcloud.code.xchat.domain.vo.RevokeMsgVo;
import org.honorcloud.code.xchat.enums.CodeEnum;
import org.honorcloud.code.xchat.enums.MessageTypeEnum;
import org.honorcloud.code.xchat.enums.inter.Code;
import org.honorcloud.code.xchat.exception.ErrorCodeException;
import org.honorcloud.code.xchat.service.MessageService;
import org.honorcloud.code.xchat.utils.CheckUtils;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 消息主控制器
 *
 * @author yanpanyi
 * @date 2019/3/20
 */
@RestController
@Slf4j
public class XeChatController {

    @Resource
    private MessageService messageService;

    /**
     * 聊天室发布订阅
     *
     * @param messageRO 消息请求对象
     * @param user 发送消息的用户对象
     * @throws Exception
     */
    @MessageMapping(StompConstant.PUB_CHAT_ROOM)
    public void chatRoom(MessageRO messageRO, User user) throws Exception {
        String message = messageRO.getMessage();

        if (!CheckUtils.checkMessageRo(messageRO) || !CheckUtils.checkUser(user)) {
            throw new ErrorCodeException(CodeEnum.INVALID_PARAMETERS);
        }
        if (CheckUtils.checkMessage(message) && message.startsWith(RobotConstant.prefix)) {
            messageService.sendMessageToRobot(StompConstant.SUB_CHAT_ROOM, message, user);
        }

        messageService.sendMessage(StompConstant.SUB_CHAT_ROOM, new MessageVO(user, message, messageRO.getImage(),
                MessageTypeEnum.USER));
    }

    /**
     * 发送消息到指定用户
     *
     * @param messageRO 消息请求对象
     * @param user 发送消息的用户对象
     * @throws Exception
     */
    @MessageMapping(StompConstant.PUB_USER)
    public void sendToUser(MessageRO messageRO, User user) throws Exception {
        if (!CheckUtils.checkMessageRo(messageRO) || !CheckUtils.checkUser(user)) {
            throw new ErrorCodeException(CodeEnum.INVALID_PARAMETERS);
        }

        messageService.sendMessageToUser(messageRO.getReceiver(), new MessageVO(user, messageRO.getMessage(),
                messageRO.getImage(), MessageTypeEnum.USER, messageRO.getReceiver()));
    }

    /**
     * 消息异常处理
     *
     * @param e 异常对象
     * @param user 发送消息的用户对象
     */
    @MessageExceptionHandler(Exception.class)
    public void handleExceptions(Exception e, User user) {
        Code code = CodeEnum.INTERNAL_SERVER_ERROR;

        if (e instanceof ErrorCodeException) {
            code = ((ErrorCodeException) e).getCode();
        } else {
            log.error("error:", e);
        }

        messageService.sendErrorMessage(code, user);
    }

    /**
     * 撤回消息
     *
     * @param revokeMessageRO 撤消消息请求对象
     * @param user 发送消息的用户对象
     * @throws Exception
     */
    @MessageMapping(StompConstant.PUB_CHAT_ROOM_REVOKE)
    public void revokeMessage(RevokeMessageRO revokeMessageRO, User user) throws Exception {
        if (revokeMessageRO == null || !CheckUtils.checkUser(user)) {
            throw new ErrorCodeException(CodeEnum.INVALID_PARAMETERS);
        }

        CheckUtils.checkMessageId(revokeMessageRO.getMessageId(), user.getUserId());

        RevokeMsgVo revokeMsgVo = new RevokeMsgVo();
        revokeMsgVo.setRevokeMessageId(revokeMessageRO.getMessageId());
        revokeMsgVo.setUser(user);
        revokeMsgVo.setType(MessageTypeEnum.REVOKE);

        if (CheckUtils.checkReceiver(revokeMessageRO.getReceiver())) {
            // 将消息发送到指定用户
            messageService.sendMessageToUser(revokeMessageRO.getReceiver(), revokeMsgVo);
            return;
        }

        // 将消息发送到所有用户
        messageService.sendMessage(StompConstant.SUB_CHAT_ROOM, revokeMsgVo);
    }

}
