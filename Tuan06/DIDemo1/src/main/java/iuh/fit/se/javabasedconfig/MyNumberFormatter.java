package iuh.fit.se.javabasedconfig;

import org.springframework.stereotype.Component;

@Component
public class MyNumberFormatter implements MyFormatter {
    public String format(double number) {
        return "Number format: " + number;
    }

    @Override
    public Class getClassInput() {
        return Double.class;
    }

    @Override
    public String format(Object obj) {
        if (obj instanceof Double)
            return format((double) obj);
        else
            throw new NumberFormatException(obj.toString());
    }
}
