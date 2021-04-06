package org.honorcloud.common.exception;

import org.honorcloud.common.constant.ErrorCodeEnum;

/**
 * @Description: 异常类型
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
public class BusinessException extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1066690624815172601L;

	private String errorCode ; // 错误码
	
	private String fieldName;

	private String errorMessage;
	
	/**
	 * 
	 */
	public BusinessException() {
		super();
	}

	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * 传入枚举，使用默认的code，和错误值
	 * @param errorCodeEnum
	 */
	public BusinessException(ErrorCodeEnum errorCodeEnum) {
		super();
		this.errorCode = errorCodeEnum.getCode();
		this.errorMessage = errorCodeEnum.getMessage();
	}

	/**
	 * 传入枚举，使用默认的code，和错误值
	 * @param errorCodeEnum
	 */
	public BusinessException(ErrorCodeEnum errorCodeEnum, String errorMessage) {
		super();
		this.errorCode = errorCodeEnum.getCode();
		this.errorMessage = errorMessage;
	}

	/**
	 * @param errorCode
	 * @param fieldName
	 * @param errorMessage
	 */
	public BusinessException(String errorCode, String fieldName, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
