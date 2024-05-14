package benhan;

public class BenhAnThuong extends BenhAn{
    protected double phiNamVien;

    public BenhAnThuong(String maBenhAn, String maBenhNhan,
                        String tenBenhNhan, String ngayNhapVien,
                        String ngayRaVien, String liDoNhapVien,
                        double phiNamVien) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.phiNamVien = phiNamVien;
        this.data.add(String.valueOf(phiNamVien));
    }
}
