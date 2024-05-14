package request;

import benhan.BenhAn;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

public class RemoveRequest extends Request {
    public RemoveRequest() {
        super();
    }

    @Override
    public void processRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mã bệnh án cần xóa:");
        String maBenhAn = scanner.nextLine();

        String[] duLieuBenhNhan = BenhAn.getBenhAnFromMa(maBenhAn);
        if (duLieuBenhNhan == null) {
            System.out.println("Không tìm thấy dữ liệu bệnh nhân");
        } else {
            System.out.println("Bạn có muốn xóa dữ liệu của bệnh nhân: " + duLieuBenhNhan[3] + " (Yes/No)");
        }

        if (scanner.nextLine().equals("Yes")) {
            BenhAn.deleteBenhAn(maBenhAn);
            System.out.println("Đã xóa dữ liệu bênh nhân");
        }
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
