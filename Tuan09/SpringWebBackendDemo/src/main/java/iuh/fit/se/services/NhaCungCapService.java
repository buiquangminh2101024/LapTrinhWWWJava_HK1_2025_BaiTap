package iuh.fit.se.services;

import iuh.fit.se.dtos.request.NhaCungCapRequest;
import iuh.fit.se.dtos.response.NhaCungCapResponse;
import iuh.fit.se.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapService {
    NhaCungCapResponse add(NhaCungCapRequest nhaCungCapRequest);
    boolean hasData();
    List<NhaCungCapResponse> findAll();
    List<NhaCungCapResponse> findCustom(String find);
    NhaCungCapResponse findById(String id);
}
