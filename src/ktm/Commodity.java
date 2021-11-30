package ktm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Commodity {
    int maHang;
    String tenHang;
    String loai;
    int giaNhap;
    int sLTonKho;
    Date ngayNhap;

    int luaChon;

    Commodity(){

    }

    Commodity(int mH, String tH, String l, int gN, int sLTK, Date nN) {
        maHang = mH;
        tenHang = tH;
        loai = l;
        giaNhap = gN;
        sLTonKho = sLTK;
        ngayNhap = nN;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    void nhapThongTin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Mã hàng(không để trống): ");
        maHang = sc.nextInt();
        sc.nextLine();
        System.out.print("Tên hàng:");
        tenHang = sc.nextLine();
        System.out.println("Loại: ");
        System.out.println("     1.Thực phẩm");
        System.out.println("     2.Sành sứ");
        System.out.println("     3.Điện máy");
        System.out.print("Lựa chọn: ");
        luaChon = sc.nextInt();
        switch (luaChon) {
        case (1):
            loai = "Thực phẩm";
            break;
        case (2):
            loai = "Sành sứ";
            break;
        case (3):
            loai = "Điện máy";
            break;
        }
        sc.nextLine();
        System.out.print("Giá nhập: ");
        giaNhap = sc.nextInt();
        System.out.print("Số lượng tồn kho: ");
        sLTonKho = sc.nextInt();
        sc.nextLine();
        System.out.print("Ngày nhập kho(dd/mm/yyy): ");
        try {
            ngayNhap = sdf.parse(sc.nextLine());
        } catch (Exception e) {
        }
    }

    void inThongTin() {
        System.out.printf("%-15d %-27s %-15s %-15d %-20d %-20s  \n", maHang, tenHang, loai, giaNhap, sLTonKho,
                sdf.format(ngayNhap));
    }

}
