package top.ibamboo.user.C.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalErrorInfoHandler {

    @ExceptionHandler(value = Exception.class)
    public String errorHandlerOverJson(RuntimeException exception) {
        return "error";
    }
}
