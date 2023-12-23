package com.tanzu.common;


import java.util.HashMap;
import java.util.Map;

public class RespCode {
    public static final int DEFAULT_ERROR_CODE = 466;
    // 用户模块错误码
    public static final int USER_ERROR_START = 400;
    // 用户不存在
    public static final int USER_NOT_FOUND = USER_ERROR_START + 1;
    // 用户已存在
    public static final int USER_ALREADY_EXISTS = USER_ERROR_START + 2;
    // 用户名不能为空
    public static final int USERNAME_CANNOT_BE_EMPTY = USER_ERROR_START + 3;
    // 密码不能为空
    public static final int PASSWORD_CANNOT_BE_EMPTY = USER_ERROR_START + 4;
    public static final Map<String, Integer> ERROR_CODE_MAP = new HashMap<>();
    // 课程模块
    public static final int COURSE_ERROR_START = 400;

    static {
        ERROR_CODE_MAP.put("USER_NOT_FOUND", 401);
        ERROR_CODE_MAP.put("USER_ALREADY_EXISTS", 402);
        ERROR_CODE_MAP.put("USERNAME_CANNOT_BE_EMPTY", 403);
        ERROR_CODE_MAP.put("PASSWORD_CANNOT_BE_EMPTY", 404);

        ERROR_CODE_MAP.put("DEFAULT_ERROR_CODE",466);
    }
}