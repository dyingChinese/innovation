package edu.wsyu.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    public enum EnumCode {
        SUCCESS(200200, "SUCCEED"),
        FAIlED(200401, "FAILURE"),

        ERROR(200501, "ERROR"),

        EXCEPTION(400400, "Exception");

        // 枚举值的属性
        private final int code;
        private final String message;

        // 构造函数
        EnumCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public Result(EnumCode enumCode, T data) {
        this.code = enumCode.code;
        this.msg = enumCode.message;
        this.data = data;
    }

    public Result(EnumCode enumCode) {
        this.code = enumCode.code;
        this.msg = enumCode.message;
    }

    Integer code;
    String msg;
    T data;

    public static Result<Void> succeed() {
        return new Result<>(EnumCode.SUCCESS);
    }

    public static <T> Result<T> succeed(T data) {
        return new Result<>(EnumCode.SUCCESS, data);
    }


    public static Result<Void> failed() {
        return new Result<>(EnumCode.FAIlED);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<>(EnumCode.FAIlED, data);
    }

    public static Result<Void> error() {
        return new Result<>(EnumCode.ERROR);
    }

    public static <T> Result<T> error(T data) {
        return new Result<>(EnumCode.ERROR, data);
    }


    public static Result<Void> exception() {
        return new Result<>(EnumCode.EXCEPTION);
    }

    public static <T> Result<T> exception(T data) {
        return new Result<>(EnumCode.EXCEPTION, data);
    }

    public String toJSONStringify() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
