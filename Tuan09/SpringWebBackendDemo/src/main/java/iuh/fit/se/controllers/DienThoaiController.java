package iuh.fit.se.controllers;

import iuh.fit.se.dtos.ApiResponse;
import iuh.fit.se.dtos.response.DienThoaiResponse;
import iuh.fit.se.services.DienThoaiService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dienThoai")
@RequiredArgsConstructor
public class DienThoaiController {
    private final DienThoaiService dienThoaiService;
    private static Logger logger = LoggerFactory.getLogger(NhaCungCapController.class.getName());

    @GetMapping("/byNhaCungCap/{id}")
    public ApiResponse<List<DienThoaiResponse>> findByNhaCungCap(@PathVariable("id") String maNCC) {
        return ApiResponse.<List<DienThoaiResponse>>builder()
                .data(dienThoaiService.findByNhaCungCap_MaNCC(maNCC))
                .build();
    }
}
