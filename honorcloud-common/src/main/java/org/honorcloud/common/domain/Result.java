package org.honorcloud.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 结果集统一返回
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
@ApiModel(value = "结果集统一返回")
@Data
public class Result<T> {
	
	@ApiModelProperty(value = "success",dataType = "int", notes = "0失败，1成功",allowableValues = "0,1")
	private int success = 0;
	
	@ApiModelProperty(value = "data",notes = "具体数据",dataType = "Object")
	private T data;
	
	@ApiModelProperty(value = "消息",notes = "消息",dataType = "message")
	private String message;
	
	@ApiModelProperty(value = "状态码",notes = "请求状态码",dataType = "string")
	private String  code;
	

}
