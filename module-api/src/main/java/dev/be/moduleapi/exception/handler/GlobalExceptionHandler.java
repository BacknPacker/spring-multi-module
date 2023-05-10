package dev.be.moduleapi.exception.handler;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e){
        return new CommonResponse(e.getReturnCode(), e.getReturnMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse handlerException(Exception e){
        return new CommonResponse(CodeEnum.UNKNOWN_ERROR.getCode(), CodeEnum.UNKNOWN_ERROR.getMessage(), null);
    }
}
