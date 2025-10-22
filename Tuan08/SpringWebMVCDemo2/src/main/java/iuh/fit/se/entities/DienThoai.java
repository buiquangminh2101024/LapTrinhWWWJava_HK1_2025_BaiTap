package iuh.fit.se.entities;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "TENDT")
    private String tenDT;
    @Column(name = "NAMSANXUAT")
    private int namSanXuat;
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
