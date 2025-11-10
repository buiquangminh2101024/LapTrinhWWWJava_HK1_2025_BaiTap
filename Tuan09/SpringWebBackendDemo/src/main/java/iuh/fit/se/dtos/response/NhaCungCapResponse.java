package iuh.fit.se.dtos.response;

import iuh.fit.se.entities.DienThoai;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class NhaCungCapResponse {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDienThoai;
}
