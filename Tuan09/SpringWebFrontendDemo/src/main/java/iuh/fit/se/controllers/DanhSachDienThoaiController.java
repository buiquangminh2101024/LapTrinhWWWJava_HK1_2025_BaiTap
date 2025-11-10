package iuh.fit.se.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/danhSachSanPham")
public class DanhSachDienThoaiController {
    @GetMapping
    public String danhSachDienThoai(Model model) {
        model.addAttribute("direction", "DanhSachSanPham");
        return "home";
    }
}
