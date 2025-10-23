package iuh.fit.se.controllers;

import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class AppController {
    private final DienThoaiService dienThoaiService;
    private final NhaCungCapService nhaCungCapService;

    @Autowired
    public AppController(DienThoaiService dienThoaiService, NhaCungCapService nhaCungCapService) {
        this.dienThoaiService = dienThoaiService;
        this.nhaCungCapService = nhaCungCapService;
    }

    @GetMapping
    public String enterHome() {
        return "home";
    }
    @GetMapping("/danhSachSanPham")
    public String danhSachSanPham(Model model, @RequestParam(defaultValue = "") String find) {
        if ("".equals(find))
            model.addAttribute("nccs", nhaCungCapService.findAll());
        else {
            model.addAttribute("nccs", nhaCungCapService.findByCustom(find));
        }
        model.addAttribute("direction", "DanhSachSanPham");
        return "home";
    }
    @GetMapping("/themMoiSanPham")
    public String themMoiSanPham(Model model) {
        model.addAttribute("dienThoai", new DienThoai());
        model.addAttribute("nccs", nhaCungCapService.findAll());
        model.addAttribute("direction", "ThemMoiSanPham");
        return "home";
    }
    @PostMapping("/themMoiSanPham")
    public String themMoiSanPhamSave(@Valid @ModelAttribute DienThoai dienThoai,
                                     BindingResult bindingResult, Model model,
                                     @RequestParam("hinhAnhFile") MultipartFile hinhAnhFile
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("nccs", nhaCungCapService.findAll());
            model.addAttribute("direction", "ThemMoiSanPham");
            return "home";
        }

        // Lưu ảnh vào thư mục static/images
        try {
            if (!hinhAnhFile.isEmpty()) {
                if (dienThoai.getMaDT() == 0) { // Này là thêm mới
                    String newFileName = luuAnh(hinhAnhFile);
                    // Set tên file vào entity (string đường dẫn)
                    dienThoai.setHinhAnh(newFileName);
                } else { // Này là sửa lại
                    String newFileName = luuAnh(hinhAnhFile);
                    // Set tên file vào entity (string đường dẫn)
                    dienThoai.setHinhAnh(newFileName);
                    xoaAnh(dienThoai.getHinhAnh());
                }
            }
        } catch (Exception e) {
            // Xử lý lỗi upload
            model.addAttribute("nccs", nhaCungCapService.findAll());
            model.addAttribute("direction", "ThemMoiSanPham");
            return "home";
        }

        if (dienThoai.getMaDT() == 0) {
            dienThoaiService.save(dienThoai);
            return "redirect:/danhSachSanPham";
        }
        else {
            dienThoaiService.update(dienThoai);
            return "redirect:/quanLy";
        }
    }
    @GetMapping("/quanLy")
    public String quanLy(Model model, @RequestParam(defaultValue = "") String find) {
        if ("".equals(find))
            model.addAttribute("nccs", nhaCungCapService.findAll());
        else {
            model.addAttribute("nccs", nhaCungCapService.findByCustom(find));
        }
        model.addAttribute("direction", "QuanLy");
        return "home";
    }
    @PostMapping("/quanLy")
    public String quayLyDelete(Model model,
                               @RequestParam(defaultValue = "") String id,
                               @RequestParam(defaultValue = "") String image,
                               @RequestParam(defaultValue = "") String type
    ) {
        if (type.equals("delete"))
            return deleteDienThoai(model, id, image);
        return navigateEdit(model, id);
    }

    private String deleteDienThoai(Model model, String id, String image) {
        model.addAttribute("nccs", nhaCungCapService.findAll());
        model.addAttribute("direction", "QuanLy");

        dienThoaiService.delete(Integer.parseInt(id));
        try {
            if (image != null && !image.isEmpty())
                xoaAnh(image);
        } catch (IOException e) {
            //Báo lỗi gì đó ở đây
        }
        return "home";
    }

    private String navigateEdit(Model model, String id) {
        DienThoai dienThoai = dienThoaiService.findById(Integer.parseInt(id));
        model.addAttribute("dienThoai", dienThoai);
        model.addAttribute("nccs", nhaCungCapService.findAll());
        model.addAttribute("direction", "ThemMoiSanPham");
        return "home";
    }

    private String luuAnh(MultipartFile hinhAnhFile) throws IOException {
        // Tạo tên file unique (UUID + extension gốc)
        String originalName = hinhAnhFile.getOriginalFilename();
        String extension = originalName.substring(originalName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extension;  // Ví dụ: abc123.png

        // Folder source static (DevTools watch)
        Path uploadDir = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/images/");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        Path sourceFilePath = uploadDir.resolve(newFileName);
        hinhAnhFile.transferTo(sourceFilePath);  // Lưu lần 1: Source

        // Folder build resources (tạm thời cho runtime)
        Path tempDir = Paths.get(System.getProperty("user.dir"), "build/resources/main/static/images/");
        if (!Files.exists(tempDir)) {
            Files.createDirectories(tempDir);
        }
        Path buildFilePath = tempDir.resolve(newFileName);
        Files.copy(sourceFilePath, buildFilePath);

        return newFileName;
    }

    private void xoaAnh(String hinhAnh) throws IOException {
        Path imgPath = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/images/", hinhAnh);
        Files.delete(imgPath);

        Path tempPath = Paths.get(System.getProperty("user.dir"), "build/resources/main/static/images/", hinhAnh);
        Files.delete(tempPath);
    }
}
