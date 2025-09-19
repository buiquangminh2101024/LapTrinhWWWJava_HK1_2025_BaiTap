package iuh.fit.se.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.SortComparator;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTT;
    @NotEmpty(message = "Tiêu đề phải được nhập")
    @NotBlank(message = "Bày đặt chơi chiêu")
    private String tieuDe;
    @NotEmpty(message = "Nội dung phải được nhập")
    @NotBlank(message = "Bày đặt chơi chiêu")
    @Pattern(regexp = "^.{0,255}$", message = "Nội dung chỉ được tối đa 255 ký tự")
    private String noiDungTT;
    @NotEmpty(message = "Liên kết phải được nhập")
    @NotBlank(message = "Bày đặt chơi chiêu")
    @Pattern(regexp = "^https?://.+$", message = "Liên kết phải bắt đầu với http hoặc https")
    private String lienKet;

    @ManyToOne
    @NotNull(message = "Danh mục không được để null")
    private DanhMuc danhMuc;

    public TinTuc(String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
        this.danhMuc = danhMuc;
    }
}
