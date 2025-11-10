package iuh.fit.se.repositories;

import iuh.fit.se.entities.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, String> {
    List<DienThoai> findByNhaCungCap_MaNCC(String maNCC);
}
