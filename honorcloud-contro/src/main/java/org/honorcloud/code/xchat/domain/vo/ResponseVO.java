package org.honorcloud.code.xchat.domain.vo;

import java.io.Serializable;

import org.honorcloud.code.xchat.enums.CodeEnum;
import org.honorcloud.code.xchat.enums.inter.Code;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应数据结构
 *
 * @author yanpanyi
 * @date 2019/3/20
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO implements Serializable {

    private static final long serialVersionUID = -5327212050370584991L;
    private static final CodeEnum SUCCESS = CodeEnum.SUCCESS;

    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应数据
     */
    private Object data;
    /**
     * 响应描述
     */
    private String desc;

    /**
     * 成功响应且带响应数据
     *
     * @param data 响应数据
     */
    public ResponseVO(Object data) {
        this.code = SUCCESS.getCode();
        this.desc = SUCCESS.getDesc();
        this.data = data;
    }

    /**
     * 只带响应code和desc
     *
     * @param code 响应code
     */
    public ResponseVO(Code code) {
        this.code = code.getCode();
        this.desc = code.getDesc();
    }


}
