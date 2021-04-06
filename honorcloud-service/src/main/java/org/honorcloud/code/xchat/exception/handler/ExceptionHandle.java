package org.honorcloud.code.xchat.exception.handler;

import org.honorcloud.code.xchat.domain.vo.ResponseVO;
import org.honorcloud.code.xchat.enums.CodeEnum;
import org.honorcloud.code.xchat.exception.ErrorCodeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理
 *
 * @author yanpanyi
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ResponseVO exceptionHandler(Exception e) {
        log.error("error:", e);
        return new ResponseVO(CodeEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ErrorCodeException.class)
    public ResponseVO errorCodeHandler(ErrorCodeException e) {
        return new ResponseVO(e.getCode());
    }

}
