package iuh.fit.se.services;

import iuh.fit.se.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapService {
    NhaCungCap save(NhaCungCap nhaCungCap);
    NhaCungCap update(NhaCungCap nhaCungCap);
    void delete(int id);
    NhaCungCap findById(int id);
    List<NhaCungCap> findAll();
    boolean hasData();
    List<NhaCungCap> findByCustom(String text);
}
