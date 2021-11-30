package ktm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class WareHouse {
    Node head = null;
    Node tail = null;
    int sL;

    WareHouse() {

    }

    WareHouse(int soLuong) {

        sL = soLuong;

    }
    //=================Quản lý danh sách=================

    void addHead(Commodity data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

    }

    void addTail(Commodity data) {

        Node newNode = new Node(data);
        if (head == null) {

            head = newNode;
            tail = newNode;

        } else {

            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;

        }

    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    void currentWareHouse() throws ParseException {

        addTail(new Commodity(1, "Nuoc nam", "Thuc pham", 150000, 15, sdf.parse("20/11/2018")));
        addTail(new Commodity(2, "Lo hoa", "Sanh su", 30000, 30, sdf.parse("12/10/2015")));
        addTail(new Commodity(3, "May say toc", "Dien may", 12000, 7, sdf.parse("03/09/2019")));
        addTail(new Commodity(4, "Coca", "Thuc pham", 30000, 50, sdf.parse("29/11/2020")));
        addTail(new Commodity(5, "Noi com dien", "Dien may", 100000, 20, sdf.parse("19/02/2008")));
        addTail(new Commodity(6, "Tivi", "Dien may", 75000, 7, sdf.parse("22/04/2020")));
        addTail(new Commodity(7, "Dien thoai", "Dien may", 3000000, 4, sdf.parse("05/05/2018")));

    }

    void addCommodity(Commodity data, int ma) {

        if (head.data.maHang == ma) {
            addHead(data);
            return;
        }
        Node current = head;
        Node newNode = new Node(data);
        while (current != null) {
            if (current.data.maHang == ma) {
                current.prev.next = newNode;
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev = newNode;
                break;
            }
            current = current.next;
        }

    }

    void removeCommodity(int ma) {

        Node current = head;
        if (head.next == null) {
            head = null;
            return;
        }
        if (head.data.maHang == ma) {// xóa đầu
            head.next.prev = null;
            head = head.next;
            return;
        }
        if (tail.data.maHang == ma) {// xóa cuối
            tail.prev.next = null;
            tail = tail.prev;
            return;
        }
        while (current != null) {
            if (current.data.maHang == ma) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                break;
            }
            current = current.next;

        }

    }

    void repairCommodity(int ma, int luaChon) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Node current = head;
        while (current != null) {
            if (current.data.maHang == ma) {
                switch (luaChon) {
                    case (1):
                        System.out.print("Nhap ten hang : ");
                        String newTen = sc.nextLine();
                        current.data.tenHang = newTen;
                        break;
                    case (2):
                        System.out.print("Nhap loai hang : ");
                        String newLoai = sc.nextLine();
                        current.data.loai = newLoai;
                        break;
                    case (3):
                        System.out.print("Nhap gia hang : ");
                        int newGia = sc.nextInt();
                        current.data.giaNhap = newGia;
                        break;
                    case (4):
                        System.out.print("Nhap so luong ton ko  : ");
                        int newSLTK = sc.nextInt();
                        current.data.sLTonKho = newSLTK;
                        break;
                    case (5):
                        System.out.print("Nhap ngay nhap kho: ");
                        Date newdate = sdf.parse(sc.nextLine());
                        current.data.ngayNhap = newdate;
                        break;
                }
            }
            current = current.next;
        }

    }

    void addList() {

        for (int i = 0; i < sL; i++) {

            System.out.println("===Sản phẩm " + i + "===");
            Commodity newCommodity = new Commodity();
            newCommodity.nhapThongTin();
            addTail(newCommodity);

        }

    }

    void printList() {

        Node current = head;
        System.out.println(
                "**********************************************Danh sách hàng hóa***********************************************");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-27s %-15s %-15s %-20s %-20s  \n", "Mã hàng", "Tên hàng hóa", "Loại",
                "Giá nhập", "Số lượng tồn kho", "Ngày nhập kho");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");
        while (current != null) {
            current.data.inThongTin();
            current = current.next;
        }
        System.out.println(
                "***************************************************************************************************************");

    }

    //=================Báo cáo-Thống kê=================
    int numberCommodity() {
        Node current = head;
        sL = 0;
        while (current != null) {
            sL++;
            current = current.next;
        }
        return sL;
    }

    long sumValue(){
        Node current = head;
        long S = 0;
        while (current != null) {
            S += current.data.giaNhap;
            current = current.next;
        }
        return S;
    }

    int numberOfType(String type){

        Node current ;
        int sl=0;
        current = head;
        while(current != null){
            if(current.data.loai.equalsIgnoreCase(type)){
                sl++;
            }
            current = current.next;
        }
        return sl;

    }

    // =================Tra cứu=================
    void findType(String type) {

        Node current = head;
        System.out.println(
                "**********************************************Danh sách hàng hóa***********************************************");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-27s %-15s %-15s %-20s %-20s  \n", "Mã hàng", "Tên hàng hóa", "Loại",
                "Giá nhập", "Số lượng tồn kho", "Ngày nhập kho");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");
        while (current != null) {
            if (current.data.loai.equalsIgnoreCase(type)) {
                current.data.inThongTin();
            }
            current = current.next;
        }
        System.out.println(
                "***************************************************************************************************************");

    }

    void findPrice(int from, int to) throws ParseException{

        sortPrice();
        int l = 0, r = numberCommodity() - 1;
        while (l <= r) {
            Node current = head;
            int m = l + (r - l) / 2;
            for (int i = 0; i < m; i++) {
                current = current.next;
            }
            if (current.prev == null) {
                if (current.data.giaNhap >= from) {
                    while (current.data.giaNhap <= to) {
                        current.data.inThongTin();
                        current = current.next;
                        if (current == null) {
                            return;
                        }
                    }
                    return;
                }
                if (current.data.giaNhap < from)
                    l = m + 1;
                else
                    r = m - 1;
                continue;
            }
            if (current.prev.data.giaNhap < from && current.data.giaNhap >= from) {
                while (current.data.giaNhap <= to) {
                    current.data.inThongTin();
                    current = current.next;
                    if (current == null) {
                        return;
                    }
                }
                return;
            }

            if (current.data.giaNhap < from)
                l = m + 1;
            else
                r = m - 1;
        }

    }

    void findDate(Date from, Date to) throws ParseException{

        sortDate();
        int l = 0, r = numberCommodity() - 1;
        while (l <= r) {
            Node current = head;
            int m = l + (r - l) / 2;
            for (int i = 0; i < m; i++) {
                current = current.next;
            }
            if (current.prev == null) {
                if (current.data.ngayNhap.after(from) || current.data.ngayNhap.equals(from)) {
                    while (current.data.ngayNhap.before(to) || current.data.ngayNhap.equals(to)) {
                        current.data.inThongTin();
                        current = current.next;
                        if (current == null) {
                            return;
                        }
                    }
                    return;
                }
                if (current.data.ngayNhap.before(from))
                    l = m + 1;
                else
                    r = m - 1;
                continue;

            }
            if (current.prev.data.ngayNhap.before(from) && (current.data.ngayNhap.after(from) || current.data.ngayNhap.equals(from))) {
                while (current.data.ngayNhap.before(to) || current.data.ngayNhap.equals(to)) {
                    current.data.inThongTin();
                    current = current.next;
                    if (current == null) {
                        return;
                    }
                }
                return;
            }

            if (current.data.ngayNhap.before(from))
                l = m + 1;
            else
                r = m - 1;
        }

    }

    void coppyData(Commodity a,Commodity b){

        a.maHang = b.maHang;
        a.tenHang = b.tenHang;
        a.loai = b.loai;
        a.giaNhap = b.giaNhap;
        a.sLTonKho = b.sLTonKho;
        a.ngayNhap = b.ngayNhap;

    }

    void swapData(Commodity a,Commodity b) throws ParseException{

        Node temp = new Node(new Commodity(0, "0", "0", 0, 0, sdf.parse("01/01/2001")));
        coppyData(temp.data, a);
        coppyData(a, b);
        coppyData(b, temp.data);

    }

    void sortPrice() throws ParseException{

        Node current;
        int number = 0;
        while (number <= numberCommodity() - 2) {
            current = head;
            for (int i = 0; i < numberCommodity() - 1 - number; i++) {
                if (current.data.giaNhap > current.next.data.giaNhap) {
                    swapData(current.data, current.next.data);
                }
                current = current.next;
            }
            number++;
        }

    }

    void sortDate() throws ParseException{

        Node current;
        int number = 0;
        while (number <= numberCommodity() - 2) {
            current = head;
            for (int i = 0; i < numberCommodity() - 1 - number; i++) {
                if (current.data.ngayNhap.after(current.next.data.ngayNhap)) {
                    swapData(current.data, current.next.data);
                }
                current = current.next;
            }
            number++;
        }

    }

}
