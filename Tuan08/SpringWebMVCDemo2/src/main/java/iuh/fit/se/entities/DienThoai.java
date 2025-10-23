package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DIENTHOAI")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADT")
    private int maDT;
    @NotBlank(message = "Tên điện thoại không được rỗng")
    @Column(name = "TENDT")
    private String tenDT;
    @NotNull(message = "Năm sản xuất không được để trống!")
    @Min(value = 1000, message = "Năm sản xuất phải có ít nhất 4 chữ số")
    @Max(value = 9999, message = "Năm sản xuất chỉ được 4 chữ số")
    @Column(name = "NAMSANXUAT")
    private Integer namSanXuat; // Chọn Integer là để trường hợp input có thể trả về ""
    @NotEmpty(message = "Thông tin cấu hình không được để trống!")
    @Pattern(regexp = "^.{0,255}$", message = "Thông tin cấu hình không quá 255 ký tự")
    @Column(name = "CAUHINH")
    private String cauHinh;
    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;
    @Column(name = "HINHANH")
    private String hinhAnh;

    public DienThoai(String tenDT, int namSanXuat, String cauHinh, String hinhAnh) {
        this.tenDT = tenDT;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.hinhAnh = hinhAnh;
    }
}
