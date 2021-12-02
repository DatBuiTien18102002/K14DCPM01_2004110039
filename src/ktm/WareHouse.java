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
    // =================Quản lý danh sách=================

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
        addTail(new Commodity(4, "Dien thoai", "Dien may", 3000000, 4, sdf.parse("05/05/2018")));
        addTail(new Commodity(5, "Coca", "Thuc pham", 30000, 50, sdf.parse("29/11/2020")));
        addTail(new Commodity(6, "Noi com dien", "Dien may", 100000, 20, sdf.parse("19/02/2008")));
        addTail(new Commodity(7, "Ca nuoc", "Sanh su", 56000, 100, sdf.parse("16/10/2015")));
        addTail(new Commodity(8, "Dau an", "Thuc pham", 37000, 26, sdf.parse("01/11/2020")));
        addTail(new Commodity(9, "Tivi", "Dien may", 75000, 7, sdf.parse("22/04/2020")));

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
        if (head.next == null) {//Xóa phần tử cuối cùng trong danh sách
            head = null;
            return;
        }
        if (head.data.maHang == ma) {// xóa đầu danh sách
            head.next.prev = null;
            head = head.next;
            return;
        }
        if (tail.data.maHang == ma) {// xóa cuối danh sách
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
    //Tìm kiếm nhị phân

    void findPrice(int from, int to) throws ParseException {

        sortPrice(numberCommodity(),head);
        int l = 0, r = numberCommodity() - 1;
        while (l <= r) {
            Node current = head;
            int m = l + (r - l) / 2;
            for (int i = 0; i < m; i++) {
                current = current.next;
            }
            if (current.prev == null) {// trường hợp current = head
                if (current.data.giaNhap >= from) {
                    while (current.data.giaNhap <= to) {
                        current.data.inThongTin();
                        current = current.next;
                        if (current == null) {//thoát vòng lặp để không gặp lỗi khi so sánh null với điều kiện
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
            //giá hàng hóa phía trước bé hơn khoảng tìm và giá hàng hóa hiện tại lớn hơn hoặc bằng khoảng tìm
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

    void findDate(Date from, Date to) throws ParseException {

        sortDate(numberCommodity(),head);
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
            if (current.prev.data.ngayNhap.before(from)
                    && (current.data.ngayNhap.after(from) || current.data.ngayNhap.equals(from))) {
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

    // =================Thống kê=================

    void coppyData(Commodity a, Commodity b) {

        a.maHang = b.maHang;
        a.tenHang = b.tenHang;
        a.loai = b.loai;
        a.giaNhap = b.giaNhap;
        a.sLTonKho = b.sLTonKho;
        a.ngayNhap = b.ngayNhap;

    }

    void swapData(Commodity a, Commodity b) throws ParseException {

        Node temp = new Node(new Commodity(0, "0", "0", 0, 0, sdf.parse("01/01/2001")));
        coppyData(temp.data, a);
        coppyData(a, b);
        coppyData(b, temp.data);

    }
    //Sắp xếp  nổi bọt
    void sortPrice(int slPT,Node start) throws ParseException {

        Node current;
        int number = 0;
        while (number <= slPT - 2) {
            current = start;
            for (int i = 0; i < slPT - 1 - number; i++) {
                if (current.data.giaNhap > current.next.data.giaNhap) {
                    swapData(current.data, current.next.data);
                }
                current = current.next;
            }
            number++;
        }

    }
    //Sắp xếp  nổi bọt
    void sortDate(int slPT,Node start) throws ParseException {

        Node current;
        int number = 0;
        while (number <= slPT - 2) {
            current = start;
            for (int i = 0; i < slPT - 1 - number; i++) {
                if (current.data.ngayNhap.after(current.next.data.ngayNhap)) {
                    swapData(current.data, current.next.data);
                }
                current = current.next;
            }
            number++;
        }

    }

    //sắp xếp sản phẩm cùng loại dứng liên tiếp nhau trong danh sách
    Node sortType(Node key , String type) throws ParseException{
        Node current = key.next;
        while(current != null){
            if(key.data.loai.equalsIgnoreCase(type)){
                key = key.next;
            }else{
                if(current.data.loai.equalsIgnoreCase(type)){
                    swapData(current.data, key.data);
                    key = key.next;
                }
            }
            current =current.next;
        }
        System.out.println("key:"+key.data.tenHang);
        return key;
    }

    void sortTypeandPrice() throws ParseException{

        Node keyTP = head;
        //Sau khi thực hiện hàm sortType biến tham chiếu key vẫn = head nên phải cho hàm sortType trả về key
        Node keySS = sortType(keyTP, "Thuc pham");
        sortPrice(numberOfType("Thuc pham"), keyTP);
        Node keyDM = sortType(keySS, "Sanh su");
        sortPrice(numberOfType("Sanh su"), keySS);
        sortPrice(numberOfType("Dien may"), keyDM);
      
    }

    void sortTypeandDate() throws ParseException{
        
        Node keyTP = head;
        //Sau khi thực hiện hàm sortType biến tham chiếu key vẫn = head nên phải cho hàm sortType trả về key
        Node keySS = sortType(keyTP, "Thuc pham");
        sortDate(numberOfType("Thuc pham"), keyTP);
        Node keyDM = sortType(keySS, "Sanh su");
        sortDate(numberOfType("Sanh su"), keySS);
        sortDate(numberOfType("Dien may"), keyDM);
      
    }



    // =================Báo cáo=================
    int numberCommodity() {
        Node current = head;
        sL = 0;
        while (current != null) {
            sL++;
            current = current.next;
        }
        return sL;
    }

    long sumValue() {
        Node current = head;
        long S = 0;
        while (current != null) {
            S += current.data.giaNhap;
            current = current.next;
        }
        return S;
    }

    int numberOfType(String type) {

        Node current;
        int sl = 0;
        current = head;
        while (current != null) {
            if (current.data.loai.equalsIgnoreCase(type)) {
                sl++;
            }
            current = current.next;
        }
        return sl;

    }
}