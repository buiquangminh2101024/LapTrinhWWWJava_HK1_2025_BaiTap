package iuh.fit.se.controllers;

import iuh.fit.se.dtos.ApiResponse;
import iuh.fit.se.dtos.request.DienThoaiRequest;
import iuh.fit.se.dtos.response.DienThoaiResponse;
import iuh.fit.se.services.DienThoaiService;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping
    public ApiResponse<DienThoaiResponse> save(@RequestPart("dienThoai") DienThoaiRequest request, @RequestPart("hinhAnhFile") MultipartFile file) throws Exception {
        return ApiResponse.<DienThoaiResponse>builder()
                .data(dienThoaiService.add(request, file))
                .build();
    }

    @DeleteMapping
    public ApiResponse delete(@RequestParam("id") String id) {
        dienThoaiService.delete(id);
        return ApiResponse.builder()
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<DienThoaiResponse> findById(@PathVariable("id") String id) {
        return ApiResponse.<DienThoaiResponse>builder()
                .data(dienThoaiService.findById(id)).build();
    }
}
