package iuh.fit.se.repositories;

import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.exceptions.AppException;
import iuh.fit.se.exceptions.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, String> {
    List<DienThoai> findByNhaCungCap_MaNCC(String maNCC);
    default DienThoai findByIdRaw(String id) {
        return findById(id).orElseThrow(() -> new AppException(ErrorCode.DIENTHOAI_NOT_EXISTED));
    }
}
