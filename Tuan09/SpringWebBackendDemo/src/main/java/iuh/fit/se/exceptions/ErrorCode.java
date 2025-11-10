package iuh.fit.se.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION("Uncategorized Exception", HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_FAILED("Validation Failed", HttpStatus.BAD_REQUEST),
    DIENTHOAI_EXISTED("Diện thoại existed", HttpStatus.BAD_REQUEST),
    NHACUNGCAP_NOT_EXISTED("Nhà cung cấp is not existed", HttpStatus.NOT_FOUND)
    ;

    private String message;
    private HttpStatus httpStatus;
}
