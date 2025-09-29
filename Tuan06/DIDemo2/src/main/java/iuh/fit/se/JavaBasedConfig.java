package iuh.fit.se;

import iuh.fit.se.models.Address;
import iuh.fit.se.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedConfig {
    @Bean
    public Employee getEmployee1() {
        Address address = new Address("Nashua", "New Hampshire", "USA");
        return new Employee(3, "Mandy Moore(Rapunzel-Rapunzel)", address);
    }
    @Bean
    public Employee getEmployee2() {
        Address address = new Address("Rockford", "Illinois", "USA");
        return new Employee(4, "Jodi Benson(Ariel-The Little Mermaid)", address);
    }
}
