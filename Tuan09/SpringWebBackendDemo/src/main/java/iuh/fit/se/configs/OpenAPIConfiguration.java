package iuh.fit.se.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl(contextPath);
        server.setDescription("Lab9 Management REST API Documentation");

        Info info = new Info()
                .title("Lab9 Management REST API Documentation")
                .version("1.0")
                .description("This API exposes endpoints to manage employees.");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
