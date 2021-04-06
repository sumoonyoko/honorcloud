package org.honorcloud.code.controller.base;

import javax.annotation.Resource;

import org.honorcloud.code.xchat.domain.vo.ResponseVO;
import org.honorcloud.code.xchat.service.ChatRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * 聊天记录
 *
 * @author yanpanyi
 * @date 2019/4/4
 */
@RestController
@RequestMapping("/api/record")
public class ChatRecordController {

    @Resource
    private ChatRecordService chatRecordService;

    /**
     * 聊天记录列表
     *
     * @param directoryName 目录名
     * @return ResponseVO
     */
    @GetMapping
    public ResponseVO listChatRecord(@RequestParam(required = false, defaultValue = "") String directoryName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", chatRecordService.listRecord(directoryName));

        return new ResponseVO(jsonObject);
    }
}
