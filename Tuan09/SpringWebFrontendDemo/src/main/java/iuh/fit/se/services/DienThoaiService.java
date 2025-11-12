package iuh.fit.se.services;

import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.utils.ApiResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DienThoaiService {
    ApiResponse<List<DienThoai>> findByNhaCungCap_MaNCC(String maNCC);
    ApiResponse<DienThoai> save(DienThoai dienThoai, @RequestParam("hinhAnhFile") MultipartFile hinhAnhFile) throws IOException;
    ApiResponse delete(String id);
    ApiResponse<DienThoai> findById(String id);
}
