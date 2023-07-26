package com.fastcampus.programming.exception;

import com.fastcampus.programming.dto.DMakerErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.fastcampus.programming.exception.DMakerErrorCode.*;

@Slf4j
@RestControllerAdvice // 각 컨트롤러마다 가지는 중복된 예외를 모아서 한번에 처리할 수 있게 함
public class DMakerExceptionHandler {

    /* 글로벌 예외 처리 : DMakerException 발생하면 실행되어 클라이언트로 응답을 보냄 */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DMakerException.class)
    public DMakerErrorResponse handleException(DMakerException e,
                                               HttpServletRequest request) {

        log.error("errorCode: {}, url: {}, message: {}",
                e.getDMakerErrorCode(), request.getRequestURI(), e.getDetailMessage());

        return DMakerErrorResponse.builder()
                .errorCode(e.getDMakerErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
    }

    /* 특정 예외 처리의 같은 경우 */
    @ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class, // 잘못된 HTTP Method 요청의 경우
            MethodArgumentNotValidException.class}) // Validation과 맞지 않은 잘못된 입력의 경우
    public DMakerErrorResponse handleBadRequest(Exception e, HttpServletRequest request) {

        log.error("errorCode: {}, url: {}, message: {}",
                request.getRequestURI(), e.getMessage());

        return DMakerErrorResponse.builder()
                .errorCode(INVALID_REQUEST)
                .errorMessage(INVALID_REQUEST.getMessage())
                .build();
    }

    /* 우리가 알 수 없는 예외의 경우 -> 예외의 최상위 Class */
    @ExceptionHandler(Exception.class)
    public DMakerErrorResponse handleException(Exception e, HttpServletRequest request) {

        log.error("errorCode: {}, url: {}, message: {}",
                request.getRequestURI(), e.getMessage());

        return DMakerErrorResponse.builder()
                .errorCode(INTERNAL_SERVER_ERROR)
                .errorMessage(INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}
