package top.ibamboo.user.C.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalErrorInfoHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String errorHandlerOverJson(RuntimeException exception) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\"\n" +
                "      xmlns:th=\"http://www.thymeleaf.org/\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>ERROR</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "   出错了 : (~~~\n" +
                "</body>\n" +
                "</html>";
    }
}
