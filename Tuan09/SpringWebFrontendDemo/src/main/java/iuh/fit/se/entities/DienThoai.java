package iuh.fit.se.entities;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DienThoai {
    private String maDT;
    private String tenDT;
    private String namSanXuat;
    private String cauHinh;
    private String nhaCungCap;
    private String hinhAnh;
}
