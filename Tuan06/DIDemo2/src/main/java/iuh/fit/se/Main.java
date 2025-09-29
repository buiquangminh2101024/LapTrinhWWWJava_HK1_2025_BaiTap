package iuh.fit.se;

import iuh.fit.se.models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context1, context2, context3;
    public static void main(String[] args) {
        context1 = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("XML-Based:");
        System.out.println("Setter: " + context1.getBean("employee1", Employee.class));
        System.out.println("Constructor: " + context1.getBean("employee2", Employee.class));

        context2 = new AnnotationConfigApplicationContext(JavaBasedConfig.class);
        System.out.println("Java-Based:");
        System.out.println("Employee3: " + context2.getBean("getEmployee1", Employee.class));
        System.out.println("Employee4: " + context2.getBean("getEmployee2", Employee.class));

        context3 = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        System.out.println("Annotation-Based:");
        System.out.println("Employee5: " + context3.getBean("employee", Employee.class));
        System.out.println("Employee5: " + context3.getBean("getEmployee5", Employee.class));
    }
}
