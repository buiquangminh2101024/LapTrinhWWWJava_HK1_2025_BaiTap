package iuh.fit.se.dtos.request;

import iuh.fit.se.dtos.response.NhaCungCapResponse;
import iuh.fit.se.entities.NhaCungCap;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DienThoaiRequest {
    @NotBlank(message = "Mã điện thoại phải có ký tự ngoài ký tự trắng")
    private String maDT;
    @NotBlank(message = "Tên điện thoại phải có ký tự ngoài ký tự trắng")
    private String tenDT;
    @Pattern(regexp = "^\\d{4}$", message = "Năm sản xuất phải có 4 chữ số")
    private String namSanXuat;
    @Length(max = 255, message = "Cấu hình phải dưới 255 ký tự")
    private String cauHinh;
    private String nhaCungCap;
    private String hinhAnh;
}
