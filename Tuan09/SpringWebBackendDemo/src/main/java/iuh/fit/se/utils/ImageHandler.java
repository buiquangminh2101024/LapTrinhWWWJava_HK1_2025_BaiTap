package iuh.fit.se.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class ImageHandler {
    public static final String PATH = "images";

    public static String luuAnh(MultipartFile file) throws IOException {
        // để none là để biết điện thoại đã có trong csdl chưa
        if (file == null || file.isEmpty()) return "none";
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + suffixName;

        Path uploadDir = Paths.get(System.getProperty("user.dir"), PATH);
        if (!Files.exists(uploadDir)) {
            Files.createDirectory(uploadDir);
        }
        Path filePath = uploadDir.resolve(newFileName);
        file.transferTo(filePath.toFile());

        return newFileName;
    }

    public static MultipartFile createMultipartFileFromResource(String partName, String filename, String contentType) throws IOException {
        // 1. Đọc nội dung file thành byte[]
        // Giả sử file ảnh của bạn nằm trong thư mục resources/images
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/images/backup", filename);
        byte[] content = Files.readAllBytes(path);

        // 2. Tạo đối tượng MockMultipartFile
        MultipartFile multipartFile = new MockMultipartFile(
                partName,     // Tên tham số (ví dụ: "hinhAnhFile")
                filename,     // Tên gốc của file (ví dụ: "dt1.png")
                contentType,  // Loại file (ví dụ: "image/png" hoặc "image/jpeg")
                content       // Nội dung byte của file
        );

        return multipartFile;
    }

    public static void xoaAnh(String hinhAnh) throws IOException {
        Path imgPath = Paths.get(System.getProperty("user.dir"), PATH, hinhAnh);
        Files.delete(imgPath);
    }

    public static void xoaAllImage() throws IOException {
        Path filePath = Paths.get(System.getProperty("user.dir"), PATH);
        if (Files.exists(filePath)) {
            Files.walk(filePath)
                    // Lọc: Chỉ giữ lại các Path là FILE và KHÔNG phải là thư mục gốc
                    .filter(Files::isRegularFile)
                    // Duyệt qua và xóa từng file
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
