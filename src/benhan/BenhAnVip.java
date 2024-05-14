package benhan;

import java.util.Date;

public class BenhAnVip extends BenhAn {
    protected String loaiVip;
    protected String thoiHanVip;

    public BenhAnVip(String maBenhAn, String maBenhNhan,
                        String tenBenhNhan, String ngayNhapVien,
                        String ngayRaVien, String liDoNhapVien,
                        String loaiVip, String thoiHanVip) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }
}
