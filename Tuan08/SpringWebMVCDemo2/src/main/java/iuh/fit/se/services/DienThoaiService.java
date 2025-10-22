package iuh.fit.se.services;

import iuh.fit.se.entities.DienThoai;

import java.util.List;

public interface DienThoaiService {
    DienThoai save(DienThoai dienThoai);
    DienThoai update(DienThoai dienThoai);
    void delete(int id);
    DienThoai findById(int id);
    List<DienThoai> findAll();
    boolean hasData();
}
