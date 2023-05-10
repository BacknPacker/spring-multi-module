package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.modulecommon.enums.CodeEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommonResponse<T>(
        String returnCode,
        String returnMessage,
        T info
) {
    public CommonResponse(T info) {
        this(null, null, info);
    }

    public CommonResponse(CodeEnum codeEnum) {
        this(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        this(codeEnum.getCode(), codeEnum.getMessage(), info);
    }
}
