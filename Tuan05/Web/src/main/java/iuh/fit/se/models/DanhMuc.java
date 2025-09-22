package iuh.fit.se.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDM;
    private String tenDanhMuc;
    private String nguoiQuanLy;
    private String ghiChu;

    @OneToMany(mappedBy = "danhMuc")
    @ToString.Exclude
    private Set<TinTuc> tinTucs;

    public DanhMuc(String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
        this.tenDanhMuc = tenDanhMuc;
        this.nguoiQuanLy = nguoiQuanLy;
        this.ghiChu = ghiChu;
    }
}
