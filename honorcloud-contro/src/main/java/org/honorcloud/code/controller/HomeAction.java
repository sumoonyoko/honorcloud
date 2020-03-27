package org.honorcloud.code.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.honorcloud.common.constant.PageConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sumoon
 * @since 2020-03-09
 */
@Api("页面管理")
@Controller
@RequestMapping("/")
public class HomeAction {
	
	@Value("${customize.index}")
	private String customizeIndex;
	
	@ApiOperation("默认主页")
	@RequestMapping("/")
	public String index() {
		return PageConstant.INDEX;
	}
	
	@ApiOperation("默认战队详情")
	@RequestMapping("/intro")
	public String intro() {
		return PageConstant.INTRO;
	}
	
	@ApiOperation("默认头部")
	@RequestMapping("/header")
	public String header() {
		return PageConstant.HEADER;
	}
	
	@ApiOperation("默认页脚")
	@RequestMapping("/footer")
	public String footer() {
		return PageConstant.FOOTER;
	}
	
	@ApiOperation("老板娘")
	@RequestMapping("/boss")
	public String boss() {
		return PageConstant.BOSS;
	}
	
	@ApiOperation("聊天室主页")
	@RequestMapping("xchat/index")
	public String chatIndex() {
		return PageConstant.CHAT_INDEX;
	}
	
	@ApiOperation("聊天记录")
	@RequestMapping("xchat/record")
	public String chatRecord() {
		return PageConstant.CHAT_RECORD;
	}
	
	@ApiOperation("聊天室")
	@RequestMapping("xchat/room")
	public String chatRoom() {
		return PageConstant.CHAT_ROOM;
	}
	
	@RequestMapping("dark/{msg}")
	public String customizeIndex(@PathVariable(value = "msg")int msg) {
		if(StringUtils.isNotEmpty(customizeIndex)) {
			return customizeIndex;
		}
		String path = PageConstant.DEFAULT_INDEX;
		switch (msg) {
			case 1:
				path = PageConstant.CUSTOMIZE_INDEX;
				break;
				
			case 2:
				path = PageConstant.DARK_INDEX;
				break;
	
			default:
				path = PageConstant.INDEX;
				break;
		}
		return path;
	}

}

