package iuh.fit.se.controllers;

import iuh.fit.se.dtos.ApiResponse;
import iuh.fit.se.dtos.response.NhaCungCapResponse;
import iuh.fit.se.services.NhaCungCapService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nhaCungCap")
@RequiredArgsConstructor
public class NhaCungCapController {
    private final NhaCungCapService nhaCungCapService;
    private static Logger logger = LoggerFactory.getLogger(NhaCungCapController.class.getName());

    @GetMapping
    public ApiResponse<List<NhaCungCapResponse>> findAll() {
        return ApiResponse.<List<NhaCungCapResponse>>builder()
                .data(nhaCungCapService.findAll())
                .build();
    }
}
