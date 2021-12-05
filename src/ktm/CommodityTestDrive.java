package ktm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CommodityTestDrive {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        WareHouse ds = new WareHouse();
        ds.currentWareHouse();

        ds.printList();

        int luaChon;
        do {
            System.out.println("*********************** MENU ***********************");
            System.out.println("**  1.Quan ly danh sach                           **");
            System.out.println("**  2.Tra cuu                                     **");
            System.out.println("**  3.Thong ke                                    **");
            System.out.println("**  4.Bao cao                                     **");
            System.out.println("**  0.Thoat                                       **");
            System.out.println("****************************************************");
            System.out.print("Lua chon: ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case (1):
                    int luaChonQL;
                    do {
                        System.out.println("**************** Quan ly danh sach *****************");
                        System.out.println("**  1.Nhap danh sach moi                          **");
                        System.out.println("**  2.In danh sach hang hoa                       **");
                        System.out.println("**  3.Them hang hoa moi vao danh sach             **");
                        System.out.println("**  4.Xoa hang hoa khoi danh sach                 **");
                        System.out.println("**  5.Sua thong tin hang hoa                      **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon: ");
                        luaChonQL = sc.nextInt();
                        switch (luaChonQL) {
                            case (1):
                                System.out.print("Nhap so luong san pham cua danh sach: ");
                                int sL = sc.nextInt();
                                ds = new WareHouse(sL);
                                ds.addList();
                                break;
                            case (2):
                                ds.printList();
                                break;
                            case (3):
                                System.out.println("**************** Quan ly danh sach *****************");
                                System.out.println("**  1.Them dau danh sach                          **");
                                System.out.println("**  2.Them cuoi danh sach                         **");
                                System.out.println("**  3.Them vao truoc 1 hang hoa dua theo ma hang  **");
                                System.out.println("****************************************************");
                                System.out.print("Lua chon: ");
                                int luaChon3 = sc.nextInt();
                                if (luaChon3 == 1) {
                                    Commodity newCommodity = new Commodity();
                                    newCommodity.nhapThongTin();
                                    ds.addHead(newCommodity);
                                } else if (luaChon3 == 2) {
                                    Commodity newCommodity = new Commodity();
                                    newCommodity.nhapThongTin();
                                    ds.addTail(newCommodity);
                                } else {
                                    System.out.print("Nhap ma hang cua hang hoa muon them hang hoa moi vao truoc: ");
                                    int ma = sc.nextInt();
                                    Commodity newCommodity = new Commodity();
                                    newCommodity.nhapThongTin();
                                    ds.addCommodity(newCommodity, ma);
                                }
                                break;
                            case (4):
                                System.out.print("Nhap ma hang cua hang hoa can xoa: ");
                                int maxoa = sc.nextInt();
                                ds.removeCommodity(maxoa);
                                break;
                            case (5):
                                int luaChon4;
                                System.out.print("Nhap ma cua hang hoa muon sua: ");
                                int masua = sc.nextInt();
                                do {
                                    System.out.println("**************** Quan ly danh sach *****************");
                                    System.out.println("**  Chon noi dung can sua                         **");
                                    System.out.println("**  1.Ten hang                                    **");
                                    System.out.println("**  2.Loai hang                                   **");
                                    System.out.println("**  3.Gia hang                                    **");
                                    System.out.println("**  4.So luong ton kho                            **");
                                    System.out.println("**  5.Ngay nhap kho                               **");
                                    System.out.println("**  0.Thoat                                       **");
                                    System.out.println("****************************************************");
                                    System.out.print("Lua chon: ");
                                    luaChon4 = sc.nextInt();
                                    ds.repairCommodity(masua, luaChon4);
                                } while (luaChon4 != 0);
                                break;
                        }

                    } while (luaChonQL != 0);
                    break;
                case (2):
                    int luaChonTC;
                    do {
                        System.out.println("********************* Tra cuu **********************");
                        System.out.println("**  1.Theo loai hang                              **");
                        System.out.println("**  2.Theo khoang gia                             **");
                        System.out.println("**  3.Theo khoang ngay                            **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon: ");
                        luaChonTC = sc.nextInt();
                        switch (luaChonTC) {
                            case (1):
                                System.out.println("********************* Tra cuu **********************");
                                System.out.println("**  Chon loai hang can tra cuu                    **");
                                System.out.println("**  1.Thuc pham                                   **");
                                System.out.println("**  2.Sanh su                                     **");
                                System.out.println("**  3.Dien may                                    **");
                                System.out.println("****************************************************");
                                System.out.print("Lua chon: ");
                                int luaChonType = sc.nextInt();
                                System.out.println(
                                        "********************************************************************************************************************");
                                System.out.println(
                                        "**                                            Danh sách hàng hóa                                                  **");
                                System.out.println(
                                        "**----------------------------------------------------------------------------------------------------------------**");
                                System.out.printf("%-2s %-15s %-27s %-15s %-15s %-20s %-13s %-2s \n", "**", "Mã hàng",
                                        "Tên hàng hóa", "Loại",
                                        "Giá nhập", "Số lượng tồn kho", "Ngày nhập kho", "**");
                                System.out.println(
                                        "**----------------------------------------------------------------------------------------------------------------**");

                                if (luaChonType == 1) {
                                    ds.findType("Thuc pham");
                                } else if (luaChonType == 2) {
                                    ds.findType("Sanh su");
                                } else {
                                    ds.findType("Dien may");
                                }

                                System.out.println(
                                        "********************************************************************************************************************");
                                break;
                            case (2):
                                System.out.println("Nhap khoang gia can tim: ");
                                System.out.print("From: ");
                                int from = sc.nextInt();
                                System.out.print("To: ");
                                int to = sc.nextInt();
                                System.out.println(
                                        "********************************************************************************************************************");
                                System.out.println(
                                        "**                                            Danh sách hàng hóa                                                  **");
                                System.out.println(
                                        "**----------------------------------------------------------------------------------------------------------------**");
                                System.out.printf("%-2s %-15s %-27s %-15s %-15s %-20s %-13s %-2s \n", "**", "Mã hàng",
                                        "Tên hàng hóa", "Loại",
                                        "Giá nhập", "Số lượng tồn kho", "Ngày nhập kho", "**");
                                System.out.println(
                                        "**----------------------------------------------------------------------------------------------------------------**");

                                ds.findPrice(from, to);

                                System.out.println(
                                        "********************************************************************************************************************");
                                break;
                            case (3):
                                sc.nextLine();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                System.out.println("Nhap khoang ngay can tim: ");
                                System.out.print("From: ");
                                Date fromDate = sdf.parse(sc.nextLine());
                                System.out.print("To: ");
                                Date toDate = sdf.parse(sc.nextLine());
                                System.out.println(
                                        "********************************************************************************************************************");
                                System.out.println(
                                        "**                                            Danh sách hàng hóa                                                  **");
                                System.out.println(
                                        "**----------------------------------------------------------------------------------------------------------------**");
                                System.out.printf("%-2s %-15s %-27s %-15s %-15s %-20s %-13s %-2s \n", "**", "Mã hàng",
                                        "Tên hàng hóa", "Loại",
                                        "Giá nhập", "Số lượng tồn kho", "Ngày nhập kho", "**");
                                System.out.println(
                                        "**----------------------------------------------------------------------------------------------------------------**");

                                ds.findDate(fromDate, toDate);

                                System.out.println(
                                        "********************************************************************************************************************");
                                break;

                        }

                    } while (luaChonTC != 0);
                    break;
                case (3):
                    int luaChonTK;
                    do {
                        System.out.println("********************* Thong ke *********************");
                        System.out.println("**  1.Theo gia hang                               **");
                        System.out.println("**  2.Theo ngay nhap                              **");
                        System.out.println("**  3.Theo loai hang va gia                       **");
                        System.out.println("**  4.Theo loai hang va ngay nhap                 **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon: ");
                        luaChonTK = sc.nextInt();
                        switch (luaChonTK) {
                            case (1):
                                System.out.println("********************* Thong ke *********************");
                                System.out.println("**  1.Tang dan                                    **");
                                System.out.println("**  2.Giam dan                                    **");
                                System.out.println("****************************************************");
                                System.out.print("Lua chon: ");
                                int choice1 = sc.nextInt();
                                if (choice1 == 1) {
                                    ds.callSortPriceUp();
                                    ds.printList();
                                } else {
                                    ds.callSortPriceDown();
                                    ds.printList();
                                }
                                break;
                            case (2):
                                System.out.println("********************* Thong ke *********************");
                                System.out.println("**  1.Tang dan                                    **");
                                System.out.println("**  2.Giam dan                                    **");
                                System.out.println("****************************************************");
                                System.out.print("Lua chon: ");
                                int choice2 = sc.nextInt();
                                if (choice2 == 1) {
                                    ds.callSortDateUp();
                                    ds.printList();
                                } else {
                                    ds.callSortDateDown();
                                    ds.printList();
                                }
                                break;
                            case (3):
                                System.out.println("********************* Thong ke *********************");
                                System.out.println("**  1.Tang dan                                    **");
                                System.out.println("**  2.Giam dan                                    **");
                                System.out.println("****************************************************");
                                System.out.print("Lua chon: ");
                                int choice3 = sc.nextInt();
                                if (choice3 == 1) {
                                    ds.sortTypeandPriceUp();
                                    ;
                                    ds.printList();
                                } else {
                                    ds.sortTypeandPriceDown();
                                    ds.printList();
                                }
                                break;
                            case (4):
                                System.out.println("********************* Thong ke *********************");
                                System.out.println("**  1.Tang dan                                    **");
                                System.out.println("**  2.Giam dan                                    **");
                                System.out.println("****************************************************");
                                System.out.print("Lua chon: ");
                                int choice4 = sc.nextInt();
                                if (choice4 == 1) {
                                    ds.sortTypeandDateUp();
                                    ;
                                    ds.printList();
                                } else {
                                    ds.sortTypeandDateDown();
                                    ds.printList();
                                }
                                break;
                        }

                    } while (luaChonTK != 0);
                    break;
                case (4):
                    int luaChonBC;
                    do {
                        System.out.println("********************* Bao cao **********************");
                        System.out.println("**  1.Tong so luong hang hoa                      **");
                        System.out.println("**  2.Tong gia tri nhap kho                       **");
                        System.out.println("**  3.So luong tung loai hang                     **");
                        System.out.println("**  0.Thoat                                       **");
                        System.out.println("****************************************************");
                        System.out.print("Lua chon: ");
                        luaChonBC = sc.nextInt();
                        switch (luaChonBC) {
                            case (1):
                                System.out
                                        .println("Tong so luong hang hoa co trong danh sach: " + ds.numberCommodity());
                                break;
                            case (2):
                                System.out.println("Tong gia tri nhap kho: " + ds.sumValue());
                                break;
                            case (3):
                                System.out.println("So luong tung loai hang: ");
                                System.out.println("Thuc pham: " + ds.numberOfType("Thuc pham"));
                                System.out.println("Sanh su: " + ds.numberOfType("Sanh su"));
                                System.out.println("Dien may: " + ds.numberOfType("Dien may"));
                                break;
                        }

                    } while (luaChonBC != 0);
                    break;

            }

        } while (luaChon != 0);

    }
}
