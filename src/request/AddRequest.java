package request;

import benhan.BenhAn;
import benhan.BenhAnThuong;
import benhan.BenhAnVip;

import java.util.Scanner;

public class AddRequest extends Request {
    public AddRequest() {
        super();
    }

    @Override
    public void processRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mã bệnh án:");
        String maBenhAn = scanner.nextLine();

        System.out.print("Mã bệnh nhân:");
        String maBenhNhan = scanner.nextLine();

        System.out.print("Tên bệnh nhân:");
        String tenBenhNhan = scanner.nextLine();

        System.out.print("Ngày nhập viện:");
        String ngayNhapVien = scanner.nextLine();

        System.out.print("Ngày ra viện:");
        String ngayRaVien = scanner.nextLine();

        System.out.print("Lí do nhập viện:");
        String liDoNhapVien = scanner.nextLine();

        System.out.print("Loại bệnh nhân (1: bệnh nhân thường, 2: bệnh nhân vip):");
        int loaiBenhNhan = scanner.nextInt();

        // Bệnh nhân vip / bệnh nhân thường
        if (loaiBenhNhan == 2) {
            System.out.print("Loại Vip (1/2/3):");
            int loaiVip = scanner.nextInt();

            System.out.print("Thời hạn vip");
            String thoiHanVip = scanner.nextLine();

            BenhAnVip benhAn = new BenhAnVip(maBenhAn, maBenhNhan, tenBenhNhan,
                    ngayNhapVien, ngayRaVien, liDoNhapVien, "Vip" + loaiVip, thoiHanVip);
            benhAn.writeToCsv();

        } else {
            System.out.print("Phí nằm viện:");
            double phiNamVien = scanner.nextDouble();

            BenhAnThuong benhAn = new BenhAnThuong(maBenhAn, maBenhNhan, tenBenhNhan,
                    ngayNhapVien, ngayRaVien, liDoNhapVien, phiNamVien);
            benhAn.writeToCsv();
        }

    }

    @Override
    public boolean isValid() {
        return true;
    }
}
