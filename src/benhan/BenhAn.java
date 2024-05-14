package benhan;

import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class BenhAn {
    protected int stt;
    protected String maBenhAn;
    protected String maBenhNhan;
    protected String tenBenhNhan;
    protected String ngayNhapVien;
    protected String ngayRaVien;
    protected String liDoNhapVien;

    protected List<String> data = new ArrayList<>();

    static final String csvFile = "medical_records.csv";

    // TODO: change data type for ngayNhapVien, ngayRaVien thành Date

    public BenhAn(String maBenhAn, String maBenhNhan,
                  String tenBenhNhan, String ngayNhapVien,
                  String ngayRaVien, String liDoNhapVien) {
        this.stt = getSttFromCsv() + 1;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.liDoNhapVien = liDoNhapVien;
        data = new ArrayList<>(Arrays.asList(String.valueOf(stt), maBenhAn, maBenhNhan, tenBenhNhan,
                ngayNhapVien, ngayRaVien, liDoNhapVien));
    }

    public void writeToCsv() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            String duLieuBenhNhan = String.join(",", this.data);
            writer.write(duLieuBenhNhan);
            writer.newLine();
            System.out.println("Đã lưu dữ liệu cho bệnh nhân " + this.maBenhNhan);

        } catch (IOException e) {
            System.out.println("Không thể lưu dữ liệu cho bệnh nhân " + this.maBenhNhan);
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static int getSttFromCsv() {
        return readCsvFile().size() + 1;
    }

    public static List<String> readCsvFile() {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            System.out.println("Không thể đọc dữ liệu từ file csv");
            System.out.println("Lỗi: " + e.getMessage());
        }

        return lines;
    }

    public static String[] getBenhAnFromMa(String maBenhAn) {
        List<String> duLieuBenhAns = readCsvFile();

        for (String duLieu : duLieuBenhAns) {
            String[] data = duLieu.split(",");

            if (data[1].equals(maBenhAn)) {
                return data;
            }
        }

        return null;
    }

    // read data from csv file
    // loop to each benh an and write data compare to du lieu can xoa
    public static void deleteBenhAn(String maBenhNhan) {
        List<String> duLieuBenhAns = readCsvFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            for (String duLieu : duLieuBenhAns) {
                String[] data = duLieu.split(",");

                System.out.println(data[1]);
                System.out.println(maBenhNhan);
                if (!data[1].equals(maBenhNhan)) {
                    writer.write(duLieu);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static void showAllBenhAn() {
        List<String> duLieuBenhAns = readCsvFile();

        for (String duLieu : duLieuBenhAns) {
            System.out.println(duLieu);
        }
    }
}
