package iuh.fit.se.javabasedconfig;

import org.springframework.stereotype.Component;

@Component
public interface MyFormatter {
    public Class getClassInput();
    public String format(Object obj);
}
