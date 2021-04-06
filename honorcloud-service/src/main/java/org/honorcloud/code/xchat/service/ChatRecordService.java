package org.honorcloud.code.xchat.service;

import java.util.HashMap;
import java.util.List;

import org.honorcloud.code.xchat.domain.dto.ChatRecordDTO;

/**
 * 聊天记录
 *
 * @author yanpanyi
 * @date 2019/4/4
 */
public interface ChatRecordService {

    /**
     * 添加聊天记录
     *
     * @param chatRecordDTO 聊天记录对象
     */
    void addRecord(ChatRecordDTO chatRecordDTO);

    /**
     * 聊天记录列表
     *
     * @param directoryName 目录名
     * @return 聊天记录列表
     */
    List<HashMap<String, Object>> listRecord(String directoryName);
}
