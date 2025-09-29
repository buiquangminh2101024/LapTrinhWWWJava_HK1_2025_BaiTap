package iuh.fit.se.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class ClientBean {
    @Value("classpath:beans.xml")
    private Resource resource;
    @Value("${foo.permission}")
    private String permission;

    public void doSomething() throws IOException {
        File file = resource.getFile();
        String s = new String(Files.readAllBytes(file.toPath()));
        System.out.println(s);
        System.out.println(permission);
    }
}
