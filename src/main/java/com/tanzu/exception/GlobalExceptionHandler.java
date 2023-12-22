package com.tanzu.exception;

import com.tanzu.common.ResResult;
import com.tanzu.common.RespCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResResult> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessages.add(fieldError.getDefaultMessage());
        }
        int errorCode = getErrorCode(errorMessages.get(0)); // 获取对应的错误码
        ResResult response = new ResResult(errorCode, errorMessages.toString(), null);
        return ResponseEntity.badRequest().body(response);
    }

    private int getErrorCode(String errorMessage) {
        if (RespCode.ERROR_CODE_MAP.containsKey(errorMessage)) {
            return RespCode.ERROR_CODE_MAP.get(errorMessage);
        } else {
            return RespCode.DEFAULT_ERROR_CODE;
        }
    }
}
