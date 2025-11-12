package iuh.fit.se.configs;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.context.ServletContextAware;

@Configuration
public class RestClientConfig implements ServletContextAware {
    @Value("${backend.basic-path}")
    private String apiBaseUrl;

    @Bean
    public RestClient restClient() {
        return RestClient.builder().build();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setAttribute("API_BASE_URL", apiBaseUrl);
    }
}
