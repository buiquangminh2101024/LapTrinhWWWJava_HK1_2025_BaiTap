package iuh.fit.se.utils;

import jakarta.validation.ConstraintTarget;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.ValidateUnwrappedValue;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;

import java.lang.annotation.Annotation;
import java.util.*;

public class CreateSimpleConstraintViolation {
    public static <T> ConstraintViolation<T> create(Class<T> clazz, T object, Object value, String propertyPath, String errorMessage) {
        return ConstraintViolationImpl.forBeanValidation(
                errorMessage, // messageTemplate: Thông điệp mẫu
                new HashMap<>(), // messageParameters: Rỗng vì không dùng placeholder
                new HashMap<>(), // expressionVariables: Rỗng vì không dùng EL
                errorMessage, // interpolatedMessage: Thông điệp cuối cùng
                clazz, // rootBeanClass: Lớp của User
                object, // rootBean: Instance của User
                object, // leafBeanInstance: Giống rootBean vì không có đối tượng lồng nhau
                value, // value: Giá trị không hợp lệ
                PathImpl.createPathFromString(propertyPath), // propertyPath: Trường vi phạm
                new ConstraintDescriptor<>() { // constraintDescriptor: Mô tả ràng buộc
                    @Override public Annotation getAnnotation() { return null; }
                    @Override public String getMessageTemplate() { return errorMessage; }
                    @Override public Set<Class<?>> getGroups() { return new HashSet<>(); }
                    @Override public Set<Class<? extends Payload>> getPayload() { return Collections.emptySet(); }
                    @Override public ConstraintTarget getValidationAppliesTo() {return ConstraintTarget.IMPLICIT;}
                    @Override public List<Class<? extends ConstraintValidator<Annotation, ?>>> getConstraintValidatorClasses() {
                        return Collections.emptyList();
                    }
                    @Override public Map<String, Object> getAttributes() { return new HashMap<>(); }
                    @Override public Set<ConstraintDescriptor<?>> getComposingConstraints() { return Collections.emptySet(); }
                    @Override public boolean isReportAsSingleViolation() { return false; }
                    @Override public ValidateUnwrappedValue getValueUnwrapping() {return ValidateUnwrappedValue.DEFAULT;}
                    @Override public <U> U unwrap(Class<U> aClass) {return null;}
                },
                null // dynamicPayload: Không cần payload
        );
    }
}
