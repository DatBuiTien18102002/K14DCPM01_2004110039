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

        System.out.print("Ma hang(khong de trong): ");
        maHang = sc.nextInt();
        sc.nextLine();
        System.out.print("Ten hang:");
        tenHang = sc.nextLine();
        System.out.println("Loai: ");
        System.out.println("     1.Thuc pham");
        System.out.println("     2.Sanh su");
        System.out.println("     3.Dien may");
        System.out.print("Lua chon: ");
        luaChon = sc.nextInt();
        switch (luaChon) {
        case (1):
            loai = "Thuc pham";
            break;
        case (2):
            loai = "Sanh su";
            break;
        case (3):
            loai = "Dien may";
            break;
        }
        sc.nextLine();
        System.out.print("Gia nhap: ");
        giaNhap = sc.nextInt();
        System.out.print("So luong ton kho: ");
        sLTonKho = sc.nextInt();
        sc.nextLine();
        System.out.print("Ngay nhap kho(dd/mm/yyyy): ");
        try {
            ngayNhap = sdf.parse(sc.nextLine());
        } catch (Exception e) {
        }
    }

    void inThongTin() {
        System.out.printf("%-2s %-15d %-27s %-15s %-15d %-20d %-13s %-2s \n","**" ,maHang, tenHang, loai, giaNhap, sLTonKho,
                sdf.format(ngayNhap),"**");
    }

}
