package iuh.fit.se.config;

import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    CommandLineRunner runner(NhaCungCapService nhaCungCapService, DienThoaiService dienThoaiService) {
        return args -> {
            if (nhaCungCapService.hasData() || dienThoaiService.hasData())
                return;

            NhaCungCap nhaCungCap1 = new NhaCungCap();
            nhaCungCap1.setTenNCC("Samsung");
            nhaCungCap1.setDiaChi("Địa chỉ 1");
            nhaCungCap1.setSoDienThoai("0987654321");

            NhaCungCap nhaCungCap2 = new NhaCungCap();
            nhaCungCap2.setTenNCC("Apple");
            nhaCungCap2.setDiaChi("Địa chỉ 2");
            nhaCungCap2.setSoDienThoai("0987654322");

            DienThoai dienThoai1 = new DienThoai();
            dienThoai1.setTenDT("Galaxy S25 FE");
            dienThoai1.setNamSanXuat(2024);
            dienThoai1.setCauHinh("Trọng lượng (g): 190 - Tốc độ CPU: 3.2 GHz, 2.9GHz, 2.6GHz, 1.95GHz - Độ phân giải (Màn hình chính): 1080 x 2340 (FHD+) - Dung lượng pin (mAh, Typical): 4900");
            dienThoai1.setHinhAnh("dt1.png");

            DienThoai dienThoai2 = new DienThoai();
            dienThoai2.setTenDT("Galaxy S25 Ultra");
            dienThoai2.setNamSanXuat(2024);
            dienThoai2.setCauHinh("Trọng lượng (g): 218 - Tốc độ CPU: 4.47GHz, 3.5GHz - Độ phân giải (Màn hình chính): 3120 X 1440 (Độ phân giải Quad HD+) - Dung lượng pin (mAh, Typical): 5000");
            dienThoai2.setHinhAnh("dt2.png");

            DienThoai dienThoai3 = new DienThoai();
            dienThoai3.setTenDT("Galaxy S24 Ultra");
            dienThoai3.setNamSanXuat(2024);
            dienThoai3.setCauHinh("Trọng lượng (g): 232 - Tốc độ CPU: 3.39 GHz, 3.1GHz, 2.9GHz, 2.2GHz - Độ phân giải (Màn hình chính): 3120 X 1440 (Độ phân giải Quad HD+) - Dung lượng pin (mAh, Typical): 5000");
            dienThoai3.setHinhAnh("dt3.png");

            DienThoai dienThoai4 = new DienThoai();
            dienThoai4.setTenDT("iPhone 17 Pro");
            dienThoai4.setNamSanXuat(2025);
            dienThoai4.setCauHinh("Trọng lượng (g): 204 - Chip: Chip A19 Pro - Độ phân giải (Màn hình chính): 2622 x 1206 với mật độ điểm ảnh 460 pi - Dung lượng pin: xem video lên đến 31 giờ");
            dienThoai4.setHinhAnh("dt4.png");

            DienThoai dienThoai5 = new DienThoai();
            dienThoai5.setTenDT("iPhone 17");
            dienThoai5.setNamSanXuat(2025);
            dienThoai5.setCauHinh("Trọng lượng (g): 177 - Chip: Chip A19 Pro - Độ phân giải (Màn hình chính): 2622 x 1206 với mật độ điểm ảnh 460 pi - Dung lượng pin: xem video lên đến 30 giờ");
            dienThoai5.setHinhAnh("dt5.png");

            dienThoai1.setNhaCungCap(nhaCungCap1);
            dienThoai2.setNhaCungCap(nhaCungCap1);
            dienThoai3.setNhaCungCap(nhaCungCap1);
            dienThoai4.setNhaCungCap(nhaCungCap2);
            dienThoai5.setNhaCungCap(nhaCungCap2);

            nhaCungCapService.save(nhaCungCap1);
            nhaCungCapService.save(nhaCungCap2);

            dienThoaiService.save(dienThoai1);
            dienThoaiService.save(dienThoai2);
            dienThoaiService.save(dienThoai3);
            dienThoaiService.save(dienThoai4);
            dienThoaiService.save(dienThoai5);
        };
    }
}
