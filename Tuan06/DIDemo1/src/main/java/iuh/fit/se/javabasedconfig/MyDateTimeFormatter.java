package iuh.fit.se.javabasedconfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Primary
public class MyDateTimeFormatter implements MyFormatter {
    public String format(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }

    @Override
    public Class getClassInput() {
        return LocalDateTime.class;
    }

    @Override
    public String format(Object obj) {
        if (obj instanceof LocalDateTime)
            return format((LocalDateTime) obj);
        else
            throw new DateTimeException(obj.toString());
    }
}
