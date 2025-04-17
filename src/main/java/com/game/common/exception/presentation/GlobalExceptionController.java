package com.game.common.exception.presentation;

import com.game.common.exception.BusinessException;
import com.game.common.exception.ErrorCode;
import com.game.common.exception.ExceptionResponse;
import com.game.common.exception.InternalServerErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        if (errorCode.getHttpStatusCode() == INTERNAL_SERVER_ERROR.value()) {
            log.error(errorCode.getMessage());
        }
        return ResponseEntity.status(errorCode.getHttpStatusCode())
                .body(ExceptionResponse.from(errorCode));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleUnExpectedException(Exception exception) {
        InternalServerErrorCode errorCode = new InternalServerErrorCode(exception.getMessage());
        log.error(errorCode.getMessage());
        return ResponseEntity.status(errorCode.getHttpStatusCode())
                .body(ExceptionResponse.from(errorCode));
    }

}
