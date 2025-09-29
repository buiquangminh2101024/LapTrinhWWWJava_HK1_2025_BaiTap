package iuh.fit.se;

import iuh.fit.se.annotationbased.Group;
import iuh.fit.se.annotationbased.User;
import iuh.fit.se.annotationbased.UserServices;
import iuh.fit.se.javabasedconfig.AppConfig;
import iuh.fit.se.javabasedconfig.MyDateTimeFormatter;
import iuh.fit.se.javabasedconfig.MyFormatterService;
import iuh.fit.se.javabasedconfig.MyNumberFormatterService;
import iuh.fit.se.resources.ClientBean;
import iuh.fit.se.resources.ResourceConfig;
import iuh.fit.se.xmlbased.Class_;
import iuh.fit.se.xmlbased.Department;
import iuh.fit.se.xmlbased.Person;
import iuh.fit.se.xmlbased.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    private static ApplicationContext context1, context2, context3, context4;

    public static void main(String[] args) throws IOException {
        context1 = new ClassPathXmlApplicationContext("beans.xml");
        context2 = new AnnotationConfigApplicationContext(UserServices.class);
        context3 = new AnnotationConfigApplicationContext(AppConfig.class);
        context4 = new AnnotationConfigApplicationContext(ResourceConfig.class);
        cau1(context1);
        cau2(context1);
        cau3(context1);
        cau4(context1);
        cau5(context1);

        cau6(context2);

        cau7(context1);

        cau8(context3);
        cau9(context3);

//        cau10(context4);
    }

    public static void cau1(ApplicationContext context) {
        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1);
    }

    public static void cau2(ApplicationContext context) {
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student2);
        Student student3 = context.getBean("student3", Student.class);
        System.out.println(student3);
    }

    public static void cau3(ApplicationContext context) {
        Person person1 = context.getBean("person1", Person.class);
        System.out.println(person1);
    }

    public static void cau4(ApplicationContext context) {
        Class_ class_2 = context.getBean("class2", Class_.class);
        System.out.println(class_2);
    }

    public static void cau5(ApplicationContext context) {
        Department department1 = context.getBean("dept1", Department.class);
        System.out.println(department1);
        Department department2 = context.getBean("dept2", Department.class);
        System.out.println(department2);
        Department department3 = context.getBean("dept3", Department.class);
        System.out.println(department3);
        Department department4 = context.getBean("dept4", Department.class);
        System.out.println(department4);
    }

    public static void cau6(ApplicationContext context) {
        User user = context.getBean(User.class);
        System.out.println(user);
        Group group = context.getBean(Group.class);
        System.out.println(group);
    }

    public static void cau7(ApplicationContext context) {
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    public static void cau8(ApplicationContext context) {
        MyNumberFormatterService service = context.getBean(MyNumberFormatterService.class);
        service.printFormat(3.14159);
    }

    public static void cau9(ApplicationContext context) {
        MyFormatterService service = context.getBean(MyFormatterService.class);
        switch (service.getClassInputName()) {
            case "Double":
                service.printFormatter(3.14159);
                break;
            case "LocalDateTime":
                service.printFormatter(LocalDateTime.now());
                break;
        }
    }

    public static void cau10(ApplicationContext context) throws IOException {
        ClientBean bean = context.getBean(ClientBean.class);
        bean.doSomething();
    }
}
