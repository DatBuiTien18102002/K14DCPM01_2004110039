package ktm;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        // System.out.print("Nhap so luong hang hoa: ");
        // int sL = sc.nextInt();

        WareHouse ds = new WareHouse();

        //ds.addList();

        //ds.printList();



        // System.out.print("Nhap ma hang  muon them hang hoa moi vao truoc: ");
        // int ma = sc.nextInt();  
        // ds.removeCommodity(ma);
        // Commodity newCommodity = new Commodity();
        // newCommodity.nhapThongTin();
        // ds.addCommodity(newCommodity,ma);  
        
        ds.currentWareHouse();
        ds.printList();
        // System.out.print("Nhập ma cua hang hoa can sua: ");
        // int ma = sc.nextInt();
        // System.out.print("Nhập lựa chọn :");
        // int luaChon = sc.nextInt();
        // ds.repairCommodity(ma, luaChon);
        // ds.printList();

        // System.out.println("1.Thuc pham");
        // System.out.println("2.Sanh su");
        // System.out.println("3.Dien may");
        // int luaChon;
        // System.out.print("Lua chon: ");
        // luaChon = sc.nextInt();
        // switch (luaChon) {
        //     case (1):
        //         ds.findType("Thuc pham");
        //         break;
        //     case (2):
        //         ds.findType("Sanh su");
        //         break;
        //     case (3):
        //         ds.findType("Dien may");
        //         break;
        // }

        // System.out.println("Nhap khoang gia can tim :");
        // System.out.print("From: ");
        // int from = sc.nextInt();
        // System.out.print("To: ");
        // int to = sc.nextInt();
        // System.out.println("**********************************************Danh sách hàng hóa***********************************************");
        // System.out.println("---------------------------------------------------------------------------------------------------------------");
        // System.out.printf("%-15s %-27s %-15s %-15s %-20s %-20s  \n","Mã hàng","Tên hàng hóa","Loại",
        // "Giá nhập","Số lượng tồn kho","Ngày nhập kho");
        // System.out.println("---------------------------------------------------------------------------------------------------------------");
        // ds.findCost(from, to);
        // System.out.println("***************************************************************************************************************");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhap khoang ngay :");
        System.out.print("From(dd/mm/yyyy) :");
        Date from = sdf.parse(sc.nextLine());
        System.out.print("To(dd/mm/yyyy) :");
        Date to = sdf.parse(sc.nextLine());
        System.out.println("**********************************************Danh sách hàng hóa***********************************************");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-27s %-15s %-15s %-20s %-20s  \n","Mã hàng","Tên hàng hóa","Loại",
        "Giá nhập","Số lượng tồn kho","Ngày nhập kho");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        ds.findDate(from, to);
        System.out.println("***************************************************************************************************************");



    }
}
