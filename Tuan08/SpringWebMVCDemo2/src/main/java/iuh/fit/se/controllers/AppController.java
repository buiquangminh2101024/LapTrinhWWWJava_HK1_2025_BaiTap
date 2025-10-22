package iuh.fit.se.controllers;

import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            System.out.println("ggggggggggggggggggg");
        }
        model.addAttribute("direction", "DanhSachSanPham");
        return "home";
    }
    @GetMapping("/themMoiSanPham")
    public String themMoiSanPham(Model model) {
        model.addAttribute("direction", "ThemMoiSanPham");
        return "home";
    }
    @GetMapping("/quanLy")
    public String quanLy(Model model) {
        model.addAttribute("direction", "QuanLy");
        return "home";
    }
}
