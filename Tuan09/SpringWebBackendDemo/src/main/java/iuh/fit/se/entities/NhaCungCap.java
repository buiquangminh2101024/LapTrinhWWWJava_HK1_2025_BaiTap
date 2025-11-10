package iuh.fit.se.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NHACUNGCAP")
@Entity
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MANCC")
    private String maNCC;
    @Column(name = "TENNCC")
    private String tenNCC;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SODIENTHOAI")
    private String soDienThoai;
    @OneToMany(mappedBy = "nhaCungCap")
    @ToString.Exclude
    Set<DienThoai> dienThoais;
}
