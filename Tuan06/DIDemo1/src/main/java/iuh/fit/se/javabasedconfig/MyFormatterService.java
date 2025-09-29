package iuh.fit.se.javabasedconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyFormatterService {
    private MyFormatter myFormatter;

//    Cho NumberFormat
//    public MyFormatterService(@Qualifier("myNumberFormatter") MyFormatter myFormatter) {
//        this.myFormatter = myFormatter;
//    }

//    Cho DateTimeFormat
    public MyFormatterService( MyFormatter myFormatter) {
        this.myFormatter = myFormatter;
    }

    public String getClassInputName() {
        return myFormatter.getClassInput().getSimpleName();
    }

    public void printFormatter(Object obj) {
        System.out.println(myFormatter.format(obj));
    }
}
