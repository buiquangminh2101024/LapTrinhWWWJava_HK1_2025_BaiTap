package iuh.fit.se.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NHACUNGCAP")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANCC")
    private int maNCC;
    @Column(name = "TENNCC")
    private String tenNCC;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SODIENTHOAI")
    private String soDienThoai;
    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<DienThoai> dienThoais;

    public NhaCungCap(String tenNCC, String diaChi, String soDienThoai) {
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
}
