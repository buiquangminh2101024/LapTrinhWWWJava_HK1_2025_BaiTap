package iuh.fit.se.configs;

import iuh.fit.se.dtos.request.DienThoaiRequest;
import iuh.fit.se.dtos.request.NhaCungCapRequest;
import iuh.fit.se.dtos.response.NhaCungCapResponse;
import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner runner(NhaCungCapService nhaCungCapService, DienThoaiService dienThoaiService) {
        return args -> {
            if (nhaCungCapService.hasData() || dienThoaiService.hasData())
                return;

            NhaCungCapRequest nhaCungCapRequest1 = new NhaCungCapRequest();
            nhaCungCapRequest1.setTenNCC("Samsung");
            nhaCungCapRequest1.setDiaChi("Địa chỉ 1");
            nhaCungCapRequest1.setSoDienThoai("0987654321");

            NhaCungCapRequest nhaCungCapRequest2 = new NhaCungCapRequest();
            nhaCungCapRequest2.setTenNCC("Apple");
            nhaCungCapRequest2.setDiaChi("Địa chỉ 2");
            nhaCungCapRequest2.setSoDienThoai("0987654322");

            DienThoaiRequest dienThoai1 = new DienThoaiRequest();
            dienThoai1.setMaDT("DT001");
            dienThoai1.setTenDT("Galaxy S25 FE");
            dienThoai1.setNamSanXuat("2024");
            dienThoai1.setCauHinh("Tốc độ CPU: 3.2 GHz, 2.9GHz, 2.6GHz, 1.95GHz - Độ phân giải (Màn hình chính): 1080 x 2340 (FHD+) - Dung lượng pin (mAh, Typical): 4900");
            dienThoai1.setHinhAnh("dt1.png");

            DienThoaiRequest dienThoai2 = new DienThoaiRequest();
            dienThoai2.setMaDT("DT002");
            dienThoai2.setTenDT("Galaxy S25 Ultra");
            dienThoai2.setNamSanXuat("2024");
            dienThoai2.setCauHinh("Tốc độ CPU: 4.47GHz, 3.5GHz - Độ phân giải (Màn hình chính): 3120 X 1440 (Độ phân giải Quad HD+) - Dung lượng pin (mAh, Typical): 5000");
            dienThoai2.setHinhAnh("dt2.png");

            DienThoaiRequest dienThoai3 = new DienThoaiRequest();
            dienThoai3.setMaDT("DT003");
            dienThoai3.setTenDT("Galaxy S24 Ultra");
            dienThoai3.setNamSanXuat("2024");
            dienThoai3.setCauHinh("Tốc độ CPU: 3.39 GHz, 3.1GHz, 2.9GHz, 2.2GHz - Độ phân giải (Màn hình chính): 3120 X 1440 (Độ phân giải Quad HD+) - Dung lượng pin (mAh, Typical): 5000");
            dienThoai3.setHinhAnh("dt3.png");

            DienThoaiRequest dienThoai4 = new DienThoaiRequest();
            dienThoai4.setMaDT("DT004");
            dienThoai4.setTenDT("iPhone 17 Pro");
            dienThoai4.setNamSanXuat("2025");
            dienThoai4.setCauHinh("Chip: Chip A19 Pro - Độ phân giải (Màn hình chính): 2622 x 1206 với mật độ điểm ảnh 460 pi - Dung lượng pin: xem video lên đến 31 giờ");
            dienThoai4.setHinhAnh("dt4.png");

            DienThoaiRequest dienThoai5 = new DienThoaiRequest();
            dienThoai5.setMaDT("DT005");
            dienThoai5.setTenDT("iPhone 17");
            dienThoai5.setNamSanXuat("2025");
            dienThoai5.setCauHinh("Chip: Chip A19 Pro - Độ phân giải (Màn hình chính): 2622 x 1206 với mật độ điểm ảnh 460 pi - Dung lượng pin: xem video lên đến 30 giờ");
            dienThoai5.setHinhAnh("dt5.png");

            NhaCungCapResponse nhaCungCapResponse1 = nhaCungCapService.add(nhaCungCapRequest1);
//            NhaCungCap nhaCungCap1 = modelMapper().map(nhaCungCapResponse1, NhaCungCap.class);
            NhaCungCapResponse nhaCungCapResponse2 = nhaCungCapService.add(nhaCungCapRequest2);
//            NhaCungCap nhaCungCap2 = modelMapper().map(nhaCungCapResponse2, NhaCungCap.class);

            dienThoai1.setNhaCungCap(nhaCungCapResponse1);
            dienThoai2.setNhaCungCap(nhaCungCapResponse1);
            dienThoai3.setNhaCungCap(nhaCungCapResponse1);
            dienThoai4.setNhaCungCap(nhaCungCapResponse2);
            dienThoai5.setNhaCungCap(nhaCungCapResponse2);

            dienThoaiService.add(dienThoai1);
            dienThoaiService.add(dienThoai2);
            dienThoaiService.add(dienThoai3);
            dienThoaiService.add(dienThoai4);
            dienThoaiService.add(dienThoai5);
        };
    }
}
