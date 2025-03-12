package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public static <E> Result<E> success(E data) {
        return new Result<E>("200", "操作成功", data);
    }

    public static Result success() {
        return new Result("200", "操作成功", null);
    }

    public static Result error(String msg) {
        return new Result("400", msg, null);
    }
}
