package com.vmo_intern.manage_fresher.models.result;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_SUCCESS_FAIL = "FAILURE";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message == null || message.isEmpty() ? DEFAULT_SUCCESS_FAIL : message);
    }

    public static Result genFailResult(String message, ResultCode code) {
        return new Result()
                .setCode(code)
                .setMessage(message == null || message.isEmpty() ? DEFAULT_SUCCESS_FAIL : message);
    }
}
