package iuh.fit.se.annotationbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServices {
    @Bean
    public Group groupService() {
        return new Group(1, "Admin Group");
    }

    @Bean
    public User userService() {
        return new User(1, "User 01", "123456", groupService());
    }
}
