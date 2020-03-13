package org.honorcloud.common.constant;

/**
 * @Description: 错误类型
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
public enum ErrorCodeEnum {
	
	NO_ERROR("200", "成功"),
	PARAM_ERROR("001", "参数错误"),
	REQUIRED_ERROR("002", "参数不可为空"),
	REPEAT_ERROR("003", "数据不可重复"),
	SIGN_ERROR("004", "签名不匹配"),
	LOGIN_ERROR("010", "登录失败"),
	MENU_RECEIVE_ERROR("011", "获取菜单错误"),
	HTTP_METHOD_ERROR("012", "请求方式不允许"),
	HTTP_NOTFOUND_ERROR("404", "请求地址未找到"),
	AUTH_FOBIDDEN_ERROR("013", "无访问权限"),
	NO_OBJ_ERROR("020", "查无此对象"),
	FILE_NOT_FIND_ERROR("021", "文件不存在"),
	FILE_READ_ERROR("022", "文件读取错误"),
	DELETE_NOT_ERROR("023", "删除条件不满足，不可删除"),
	UPLOAD_IMAGE_ERROR("024", "图片上传失败"),
	ADD_OBJ_ERROR("025", "新增失败"),
	OPERRATE_ERROR("026", "操作不合法"),
	FIND_OBJ_ERROR("027", "查询失败"),
	DELETE_OBJ_ERROR("028", "删除失败"),
	NO_IMAGE_ERROR("029", "该用户没有上传头像"),
	ATTACH_UPLOAD_ERROR("030", "附件上传失败"),
	NULLPOINT_ERROR("900", "发生空指针异常"),
	ILLEGALARGUMENT_ERROR("901", "请求参数类型不匹配"),
	NEW_INSTANCE_ERROR("905", "创建对象实例异常"),
	SQL_ERROR("902", "数据库访问异常"),
	IO_ERROR("903", "IO异常"),
	JSON_ERROR("904", "IO异常"),
	SERVER_ERROR("999", "内部服务错误，联系后台管理员") ;

	
	 /**
	 * @param code
	 * @param message
	 */
	private ErrorCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	/** */
    private String code;
    /** */
    private String message;
    
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
    
}
