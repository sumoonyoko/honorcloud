package org.honorcloud.common.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.honorcloud.common.constant.ErrorCodeEnum;
import org.honorcloud.common.domain.Result;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;

/**
 * @Description: 返回结果集
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
public class ResultUtil{

	public static Result success(Object data){
		Result result = new Result();
		result.setSuccess(1);
		result.setCode(ErrorCodeEnum.NO_ERROR.getCode());
		result.setMessage(ErrorCodeEnum.NO_ERROR.getMessage());
		result.setData(data);
		return result;
	}
	
	public static Result success(){
		Result result = new Result();
		result.setSuccess(1);
		result.setCode(ErrorCodeEnum.NO_ERROR.getCode());
		result.setMessage(ErrorCodeEnum.NO_ERROR.getMessage());
		result.setData(null);
		return result;
	}

	public static Result fail(String code, String msg){
		Result result = new Result();
		result.setSuccess(0);
		result.setMessage(msg);
		result.setCode(code);
		return result;
	}
	
	public static Result fail(ErrorCodeEnum errorCodeEnum){
		Result result = new Result();
		result.setSuccess(0);
		result.setMessage(errorCodeEnum.getMessage());
		result.setCode(errorCodeEnum.getCode());
		return result;
	}

	public static Result fail(ErrorCodeEnum errorCodeEnum, String msg){
		Result result = new Result();
		result.setSuccess(0);
		result.setMessage(msg);
		result.setCode(errorCodeEnum.getCode());
		if(StringUtils.isEmpty(msg)){
			result.setMessage(errorCodeEnum.getMessage());
		}
		return result;
	}

	/**
	 * 错误信息
	 * @param codeEnum
	 * @param errorList Valid校验错误信息
	 * @return Result
	 */
	public static Result fail(ErrorCodeEnum codeEnum, List<ObjectError> errorList){
		Result result = new Result();
		result.setSuccess(0);
		result.setMessage(getErrorString(errorList));
		result.setCode(codeEnum.getCode());
		return result;
	}

	/**
	 * 创建错误对象的错误信息
	 * @param errorList  List<ObjectError>
	 * @return string
	 */
	public static String getErrorString(List<ObjectError> errorList) {
		final StringBuilder sbMsg = new StringBuilder();
		for(ObjectError error : errorList){
			sbMsg.append(" 错误信息：" + error.getDefaultMessage()).append("\r\n");
		}
		return sbMsg.toString();
	}

	/**
	 * 创建错误对象的错误信息
	 * @param errorMsg
	 * @return
	 */
	public static String getErrorString(Map<String, String> errorMsg) {
		final StringBuilder sbMsg = new StringBuilder();
		if(errorMsg.isEmpty()){
			return null;
		}
		Set<String> set = errorMsg.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()){
			String k = iterator.next();
			sbMsg.append("  [" + k + "]错误信息：" + errorMsg.get(k)).append("\r\n");
		}
		return sbMsg.toString();
	}
}
