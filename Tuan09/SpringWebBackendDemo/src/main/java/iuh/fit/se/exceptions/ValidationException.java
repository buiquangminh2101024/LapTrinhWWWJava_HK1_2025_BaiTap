package iuh.fit.se.exceptions;

import iuh.fit.se.dtos.request.DienThoaiRequest;
import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class ValidationException extends AppException {
    private Map<String, String> errors;
    public ValidationException(Set<ConstraintViolation<DienThoaiRequest>> errorList) {
        super(ErrorCode.VALIDATION_FAILED);
        errors = new HashMap<>();
        convertToMap(errorList);
    }

    private void convertToMap(Set<ConstraintViolation<DienThoaiRequest>> errorList) {
        errorList.forEach(e -> errors.put("error_" + e.getPropertyPath(), e.getMessage()));
    }
}
