package top.zhengru.financetrain.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.zhengru.financetrain.base.ResponseResult;

import java.sql.SQLException;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public ResponseResult<Map<String, String>> sqlException(SQLException e){
        return new ResponseResult<>(500, "数据库异常，操作失败！");
    }
}