package iuh.fit.se.controllers;

import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import iuh.fit.se.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quanLy")
@RequiredArgsConstructor
public class QuanLyController {
    private final NhaCungCapService nhaCungCapService;
    private final DienThoaiService dienThoaiService;

    @GetMapping
    public String quanLy(Model model, @RequestParam(defaultValue = "") String find) {
        List<NhaCungCap> nhaCungCaps =  nhaCungCapService.findAllOrCustom(find).getData();
        Map<String, List<DienThoai>> dienThoaisByTenNCC = new LinkedHashMap<>();
        for (NhaCungCap nc : nhaCungCaps) {
            dienThoaisByTenNCC.put(
                    nc.getTenNCC(),
                    dienThoaiService.findByNhaCungCap_MaNCC(nc.getMaNCC())
                            .getData()
            );
        }

        model.addAttribute("direction", "QuanLy");
        model.addAttribute("nccs", dienThoaisByTenNCC);
        return "home";
    }

    @PostMapping
    public String deleteOrEditQuanLy(Model model, @RequestParam(name = "id") String id,
                                     @RequestParam(name = "image", defaultValue = "") String image,
                                     @RequestParam(name = "type") String type) {
        if (type.equals("delete")) {
            dienThoaiService.delete(id);
            quanLy(model, "");
            return "redirect:/quanLy";
        }

        ApiResponse<DienThoai> response = dienThoaiService.findById(id);

        String message = response.getMessage();
        if (message != null) {
            throw new RuntimeException(message);
        }

        model.addAttribute("dienThoai", response.getData());
        model.addAttribute("nccs", nhaCungCapService.findAllOrCustom("").getData());
        model.addAttribute("direction", "ThemMoiSanPham");
        return "home";
    }
}
