package iuh.fit.se.services;

import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.utils.ApiResponse;

import java.util.List;

public interface NhaCungCapService {
    ApiResponse<List<NhaCungCap>> findAllOrCustom(String find);
}
