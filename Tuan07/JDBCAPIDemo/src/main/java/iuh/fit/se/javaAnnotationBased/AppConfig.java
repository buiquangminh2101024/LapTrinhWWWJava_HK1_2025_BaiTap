package iuh.fit.se.javaAnnotationBased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class AppConfig {
    @Value("${app.datasource.driver}")
    private String driver;
    @Value("${app.datasource.url}")
    private String url;
    @Value("${app.datasource.username}")
    private String username;
    @Value("${app.datasource.password}")
    private String password;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
