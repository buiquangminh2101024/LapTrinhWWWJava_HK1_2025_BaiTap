package iuh.fit.se.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION("Uncategorized Exception", HttpStatus.INTERNAL_SERVER_ERROR),
    NO_CONTENT("No content", HttpStatus.NO_CONTENT),
    CANT_PROCESS("Can't process", HttpStatus.INTERNAL_SERVER_ERROR),
    DIENTHOAI_EXISTED("Diện thoại existed", HttpStatus.BAD_REQUEST),
    NHACUNGCAP_NOT_EXISTED("Nhà cung cấp is not existed", HttpStatus.NOT_FOUND)
    ;

    private String message;
    private HttpStatus httpStatus;
}
