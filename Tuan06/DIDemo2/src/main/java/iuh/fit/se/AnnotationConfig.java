package iuh.fit.se;

import iuh.fit.se.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("iuh.fit.se.models")
@PropertySource("classpath:class.properties")
public class AnnotationConfig {
    @Value("${name5}")
    private String name5;

    @Bean
    public String getName5() {
        return name5;
    }

    @Bean
    public Employee getEmployee5() {
        return new Employee();
    }
}
