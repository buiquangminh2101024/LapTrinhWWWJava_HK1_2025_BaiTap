package iuh.fit.se.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("iuh.fit.se.resources")
@PropertySource("classpath:application.properties")
public class ResourceConfig {
    public ClientBean clientBean() {
        return new ClientBean();
    }
}
