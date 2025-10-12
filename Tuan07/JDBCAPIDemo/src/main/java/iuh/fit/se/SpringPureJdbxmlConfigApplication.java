package iuh.fit.se;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringPureJdbxmlConfigApplication {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringPureJdbxmlConfigApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("databaseConfig.xml");
        DataSource ds = context.getBean("dataSource", DataSource.class);
        System.out.println(ds.getConnection());
    }
}
