package iuh.fit.se.controllers;

import iuh.fit.se.utils.ImageHandler;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/images")
public class ImageController {
    @GetMapping("/{id}")
    public void getImageById(@PathVariable String id, HttpServletResponse response) throws Exception {
        response.setContentType("image/*");
        Path filePath = Paths.get(System.getProperty("user.dir"), ImageHandler.PATH, id);
        if (Files.exists(filePath))
            Files.newInputStream(filePath).transferTo(response.getOutputStream());
        else
            new OutputStreamWriter(response.getOutputStream(), "utf-8").write("");
    }
    @GetMapping("/")
    public void getImageDefault(HttpServletResponse response) throws Exception {
        response.setContentType("image/*");
        new OutputStreamWriter(response.getOutputStream(), "utf-8").write("");
    }
}
