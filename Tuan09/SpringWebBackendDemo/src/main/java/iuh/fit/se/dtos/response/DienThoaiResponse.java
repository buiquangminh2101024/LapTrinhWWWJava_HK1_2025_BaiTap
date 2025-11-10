package iuh.fit.se.dtos.response;

import iuh.fit.se.entities.NhaCungCap;
import lombok.*;

@Getter
@Setter
public class DienThoaiResponse {
    private String maDT;
    private String tenDT;
    private String namSanXuat;
    private String cauHinh;
    private NhaCungCapResponse nhaCungCap;
    private String hinhAnh;
}
