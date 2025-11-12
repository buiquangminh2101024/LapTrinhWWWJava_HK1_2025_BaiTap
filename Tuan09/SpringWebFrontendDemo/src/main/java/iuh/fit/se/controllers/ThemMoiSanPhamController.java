package iuh.fit.se.controllers;

import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import iuh.fit.se.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/themMoiSanPham")
@RequiredArgsConstructor
public class ThemMoiSanPhamController {
    private final NhaCungCapService nhaCungCapService;
    private final DienThoaiService dienThoaiService;

    @GetMapping
    public String startAdd(Model model) {

        model.addAttribute("dienThoai", new DienThoai());
        model.addAttribute("nccs", nhaCungCapService.findAllOrCustom("").getData());
        model.addAttribute("direction", "ThemMoiSanPham");
        return "home";
    }

    @PostMapping
    public String save(@ModelAttribute DienThoai dienThoai,
                               Model model,
                               @RequestParam("hinhAnhFile")MultipartFile hinhAnhFile) throws IOException {
        ApiResponse<DienThoai> response = dienThoaiService.save(dienThoai, hinhAnhFile);

        Map<String, String> errors =  response.getErrors();
        if (errors != null && !errors.isEmpty()) {
            model.addAttribute("errors", errors);
            model.addAttribute("dienThoai", dienThoai);
            model.addAttribute("nccs", nhaCungCapService.findAllOrCustom("").getData());
            model.addAttribute("direction", "ThemMoiSanPham");
            return "home";
        }

        return "redirect:/danhSachSanPham";
    }
}
