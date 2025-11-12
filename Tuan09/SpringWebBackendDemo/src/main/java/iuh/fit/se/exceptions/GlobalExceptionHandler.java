package iuh.fit.se.exceptions;

import iuh.fit.se.dtos.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ApiResponse> validateExceptionHandler(ValidationException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(
                ApiResponse.builder()
                        .message(errorCode.getMessage())
                        .errors(ex.getErrors())
                        .build()
        );
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse> userExceptionHandler(AppException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(
                ApiResponse.builder()
                        .message(errorCode.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse> globleExcpetionHandler(Exception ex) {
        System.err.println(ex.getMessage());
        ErrorCode errorCode = ErrorCode.UNCATEGORIZED_EXCEPTION;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(
                ApiResponse.builder()
                        .message(errorCode.getMessage())
                        .build()
        );
    }
}
