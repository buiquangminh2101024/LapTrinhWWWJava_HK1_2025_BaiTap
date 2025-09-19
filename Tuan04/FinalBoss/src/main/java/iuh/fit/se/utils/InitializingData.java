package iuh.fit.se.utils;

import iuh.fit.se.daos.DanhMucDao;
import iuh.fit.se.daos.TinTucDao;
import iuh.fit.se.daos.impl.DanhMucDaoImpl;
import iuh.fit.se.daos.impl.TinTucDaoImpl;
import iuh.fit.se.models.DanhMuc;
import iuh.fit.se.models.TinTuc;
import jakarta.persistence.EntityManager;

public class InitializingData {
    public static void createInitialData() {
        DanhMucDao danhMucDao = new DanhMucDaoImpl();
        TinTucDao tinTucDao = new TinTucDaoImpl();

        DanhMuc danhMuc1 = new DanhMuc();
        danhMuc1.setTenDanhMuc("Chính trị");
        danhMuc1.setGhiChu("");
        danhMuc1.setNguoiQuanLy("ABC");
        danhMucDao.save(danhMuc1);

        DanhMuc danhMuc2 = new DanhMuc();
        danhMuc2.setTenDanhMuc("Thời sự");
        danhMuc2.setGhiChu("");
        danhMuc2.setNguoiQuanLy("DEF");
        danhMucDao.save(danhMuc2);

        DanhMuc danhMuc3 = new DanhMuc();
        danhMuc3.setTenDanhMuc("Kinh tế");
        danhMuc3.setGhiChu("");
        danhMuc3.setNguoiQuanLy("GHI");
        danhMucDao.save(danhMuc3);

        DanhMuc danhMuc4 = new DanhMuc();
        danhMuc4.setTenDanhMuc("Đời sống");
        danhMuc4.setGhiChu("");
        danhMuc4.setNguoiQuanLy("JKL");
        danhMucDao.save(danhMuc4);

        DanhMuc danhMuc5 = new DanhMuc();
        danhMuc5.setTenDanhMuc("Sức khỏe");
        danhMuc5.setGhiChu("");
        danhMuc5.setNguoiQuanLy("MNO");
        danhMucDao.save(danhMuc5);

        TinTuc tinTuc1 = new TinTuc();
        tinTuc1.setDanhMuc(danhMuc1);
        tinTuc1.setLienKet("https://thanhnien.vn/bo-chinh-tri-chi-dinh-2-pho-bi-thu-tinh-uy-thanh-hoa-185250917102731759.htm");
        tinTuc1.setTieuDe("Bộ Chính trị chỉ định 2 Phó bí thư Tỉnh ủy Thanh Hóa");
        tinTuc1.setNoiDungTT("Ông Nguyễn Hoài Anh, Phó bí thư thường trực Tỉnh ủy Lâm Đồng và thiếu tướng Nguyễn Hồng Phong được điều động, phân công giữ chức Phó bí thư Tỉnh ủy Thanh Hóa.");
        tinTucDao.save(tinTuc1);

        TinTuc tinTuc2 = new TinTuc();
        tinTuc2.setDanhMuc(danhMuc2);
        tinTuc2.setLienKet("https://thanhnien.vn/chu-tich-tap-doan-thuan-an-nguyen-duy-hung-10-nam-6-thang-tu-185250918141225714.htm");
        tinTuc2.setTieuDe("Chủ tịch Tập đoàn Thuận An Nguyễn Duy Hưng 10 năm 6 tháng tù");
        tinTuc2.setNoiDungTT("Tòa tuyên phạt cựu Phó chủ nhiệm Văn phòng Quốc hội Phạm Thái Hà 5 năm 6 tháng tù, Chủ tịch Tập đoàn Thuận An Nguyễn Duy Hưng 10 năm 6 tháng tù.");
        tinTucDao.save(tinTuc2);

        TinTuc tinTuc3 = new TinTuc();
        tinTuc3.setDanhMuc(danhMuc3);
        tinTuc3.setLienKet("https://thanhnien.vn/nghi-dinh-119-2024-nd-cp-cot-moc-01102025-trach-nhiem-cong-dong-trong-chuyen-doi-tai-khoan-giao-thong-185250918163231218.htm");
        tinTuc3.setTieuDe("Nghị định 119/2024/NĐ-CP cột mốc 01.10.2025: Trách nhiệm cộng đồng trong chuyển đổi tài khoản giao thông");
        tinTuc3.setNoiDungTT("Ngày 01.10.2025, theo Nghị định 119/2024/NĐ-CP, mọi phương tiện phải hoàn tất chuyển đổi từ tài khoản thu phí sang tài khoản giao thông được định danh và liên kết phương tiện thanh toán không tiền mặt.");
        tinTucDao.save(tinTuc3);

        TinTuc tinTuc4 = new TinTuc();
        tinTuc4.setDanhMuc(danhMuc4);
        tinTuc4.setLienKet("https://thanhnien.vn/cho-re-phai-khi-den-do-o-tphcm-cho-dau-ma-nhuong-185250916152835857.htm");
        tinTuc4.setTieuDe("Cho rẽ phải khi đèn đỏ ở TP.HCM: 'Chỗ đâu mà nhường?'");
        tinTuc4.setNoiDungTT("Cho rẽ phải khi đèn đỏ nhưng không được nhường đường, nhiều người đổ tại 'mấy người kia ý thức kém', có người lấy lý do 'đường quá hẹp, không có chỗ nhường'.");
        tinTucDao.save(tinTuc4);

        TinTuc tinTuc5 = new TinTuc();
        tinTuc5.setDanhMuc(danhMuc5);
        tinTuc5.setLienKet("https://thanhnien.vn/cu-ong-bi-manh-xuong-ca-dai-4-cm-cua-thung-ruot-185250918120051581.htm");
        tinTuc5.setTieuDe("Cụ ông bị mảnh xương cá dài 4 cm cứa thủng ruột");
        tinTuc5.setNoiDungTT("Cụ ông P.V.C (86 tuổi, sống tại tỉnh Tây Ninh) đột nhiên xuất hiện cơn đau âm ỉ vùng hông phải. Vài giờ sau, cơn đau trở nên dữ dội, bụng chướng căng khiến ông mệt mỏi và khó thở.");
        tinTucDao.save(tinTuc5);
    }

    public static void main(String[] args) {
        InitializingData.createInitialData();
    }
}
