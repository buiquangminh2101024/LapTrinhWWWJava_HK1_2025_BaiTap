package iuh.fit.se.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DIENTHOAI")
@Entity
public class DienThoai {
    @Id
    @Column(name = "MADT")
    private String maDT;
    @Column(name = "TENDT")
    private String tenDT;
    @Column(name = "NAMSANXUAT")
    private String namSanXuat;
    @Column(name = "CAUHINH")
    private String cauHinh;
    @ManyToOne()
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;
    @Column(name = "HINHANH")
    private String hinhAnh;
}
