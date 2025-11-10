package iuh.fit.se.dtos.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCapRequest {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDienThoai;
}
