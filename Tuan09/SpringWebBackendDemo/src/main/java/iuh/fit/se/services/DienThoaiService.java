package iuh.fit.se.services;

import iuh.fit.se.dtos.request.DienThoaiRequest;
import iuh.fit.se.dtos.response.DienThoaiResponse;
import iuh.fit.se.entities.DienThoai;

import java.util.List;

public interface DienThoaiService {
    DienThoaiResponse add(DienThoaiRequest request);
    boolean hasData();
    List<DienThoaiResponse> findByNhaCungCap_MaNCC(String maNCC);
}
