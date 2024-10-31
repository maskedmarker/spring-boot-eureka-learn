package org.example.learn.spring.boot.commons.util;

import org.example.learn.spring.boot.commons.constant.ErrorCodeConstants;
import org.example.learn.spring.boot.commons.model.dto.BaseResponseData;

public class ResponseUtils {

    public static final String OK_MESSAGE = "OK";

    public static <T> BaseResponseData<T> ok(T data) {
        return new BaseResponseData<>(ErrorCodeConstants.OK, OK_MESSAGE, data);
    }
}
