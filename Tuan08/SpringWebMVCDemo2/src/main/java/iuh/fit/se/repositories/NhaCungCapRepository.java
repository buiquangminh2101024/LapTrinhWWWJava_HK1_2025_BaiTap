package iuh.fit.se.repositories;

import iuh.fit.se.entities.NhaCungCap;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {
    List<NhaCungCap> findByTenNCCContainsOrDiaChiContainsOrSoDienThoaiContains(String tenNCC, String diaChi, String soDienThoai);
}
