package org.honorcloud.code.xchat.aop;

import javax.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.honorcloud.code.xchat.domain.dto.ChatRecordDTO;
import org.honorcloud.code.xchat.domain.vo.MessageVO;
import org.honorcloud.code.xchat.enums.MessageTypeEnum;
import org.honorcloud.code.xchat.service.ChatRecordService;
import org.honorcloud.code.xchat.utils.SensitiveWordUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

/**
 * 聊天记录切面类
 *
 * @author yanpanyi
 * @date 2019/4/23
 */
@Aspect
@Component
@Slf4j
public class ChatRecordAspect {

    @Resource
    private ChatRecordService chatRecordService;

    @Pointcut("@annotation(org.honorcloud.code.xchat.annotation.ChatRecord)")
    public void chatRecordPointcut() {
    }

    @Before("chatRecordPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        log.debug("before -> {}", joinPoint);

        MessageVO messageVO = null;
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            if (obj instanceof MessageVO) {
                messageVO = (MessageVO) obj;
                break;
            }
        }

        Assert.notNull(messageVO, "方法必需以MessageVO类或该类的子类作为参数");

        if (messageVO.getType() == MessageTypeEnum.USER) {
            // 对于User类型的消息做敏感词处理
            messageVO.setMessage(SensitiveWordUtils.loveChina(messageVO.getMessage()));
        }

        log.debug("添加聊天记录 -> {}", messageVO);
        chatRecordService.addRecord(ChatRecordDTO.toChatRecordDTO(messageVO));
    }

}
