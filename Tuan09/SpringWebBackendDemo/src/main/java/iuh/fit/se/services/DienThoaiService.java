package iuh.fit.se.services;

import iuh.fit.se.dtos.request.DienThoaiRequest;
import iuh.fit.se.dtos.response.DienThoaiResponse;
import iuh.fit.se.entities.DienThoai;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DienThoaiService {
    DienThoaiResponse add(DienThoaiRequest request, MultipartFile file) throws Exception;
    boolean hasData();
    List<DienThoaiResponse> findByNhaCungCap_MaNCC(String maNCC);
    void delete(String id);
    DienThoaiResponse findById(String id);
}
