package iuh.fit.se.repositories;

import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.exceptions.AppException;
import iuh.fit.se.exceptions.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    List<NhaCungCap> findByMaNCCContainsOrTenNCCContainsOrDiaChiContainsOrSoDienThoaiContains(String maNCC, String tenNCC, String diaChi, String soDienThoai);
    default NhaCungCap findByIdRaw(String id) {
        return findById(id).orElseThrow(() -> new AppException(ErrorCode.NHACUNGCAP_NOT_EXISTED));
    }
}
