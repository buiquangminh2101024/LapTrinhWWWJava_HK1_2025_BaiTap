package iuh.fit.se;

import iuh.fit.se.config.AppConfig;
import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@SpringBootApplication
public class SpringWebMvcDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebMvcDemo2Application.class, args);
    }
}
