package ktm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WareHouse {
    public Node head = null;
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

        addTail(new Commodity(1, "Nuoc nam", "Thuc pham", 22000, 25, sdf.parse("25/09/2021")));
        addTail(new Commodity(2, "Binh hoa", "Sanh su", 62000, 10, sdf.parse("12/10/2019")));
        addTail(new Commodity(3, "May say toc", "Dien may", 198000, 5, sdf.parse("01/02/2018")));
        addTail(new Commodity(4, "Dien thoai", "Dien may", 3000000, 7, sdf.parse("05/05/2016")));
        addTail(new Commodity(5, "Coca", "Thuc pham", 17000, 20, sdf.parse("29/11/2021")));
        addTail(new Commodity(6, "Noi com dien", "Dien may", 900000, 12, sdf.parse("19/06/2017")));
        addTail(new Commodity(7, "Ly nuoc", "Sanh su", 13000, 35, sdf.parse("16/10/2015")));
        addTail(new Commodity(8, "Dau an", "Thuc pham", 42000, 26, sdf.parse("01/11/2021")));
        addTail(new Commodity(9, "Tivi", "Dien may", 8000000, 4, sdf.parse("22/04/2017")));
        addTail(new Commodity(10, "May Lanh", "Dien may", 5000000, 7, sdf.parse("26/12/2016")));
        addTail(new Commodity(11, "Ca hop", "Thuc pham", 13000, 15, sdf.parse("23/06/2021")));
        addTail(new Commodity(12, "Mi tom", "Thuc pham", 3500, 100, sdf.parse("29/10/2021")));
        addTail(new Commodity(13, "Den ngu", "Dien may", 169000, 19, sdf.parse("06/12/2017")));
        addTail(new Commodity(14, "Am tra", "Sanh su", 343000, 2, sdf.parse("19/08/2015")));
        addTail(new Commodity(15, "May giat", "Dien may", 6000000, 8, sdf.parse("19/03/2015")));
        addTail(new Commodity(16, "Dia su", "Sanh su", 16000, 42, sdf.parse("24/02/2017")));
        addTail(new Commodity(17, "Ca phe bich", "Thuc pham", 5000, 26, sdf.parse("01/12/2021")));
        addTail(new Commodity(18, "Tu lanh", "Dien may", 11000000, 1, sdf.parse("06/07/2016")));
        addTail(new Commodity(19, "Keo Ngam", "Thuc pham", 8000, 28, sdf.parse("09/11/2021")));
        addTail(new Commodity(20, "Den pin", "Dien may", 100000, 6, sdf.parse("03/07/2020")));

    }

    void addCommodity(Commodity data, int maNhap) {

        if (head.data.maHang == maNhap) {
            addHead(data);
            return;
        }
        Node current = head;
        Node newNode = new Node(data);
        while (current != null) {
            if (current.data.maHang == maNhap) {
                current.prev.next = newNode;
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev = newNode;
                return;
            }
            current = current.next;
        }
        System.out.println("   Ma san pham nhap vao khong ton tai");
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
                        System.out.print("Nhap ngay nhap kho(dd/mm/yyyy): ");
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

            System.out.println("===San pham " + i + "===");
            Commodity newCommodity = new Commodity();
            newCommodity.nhapThongTin();
            addTail(newCommodity);

        }

    }

    void printList() {

        Node current = head;
        System.out.println(
                "********************************************************************************************************************");
        System.out.println(
                "**                                            Danh sách hàng hóa                                                  **");
        System.out.println(
                "**----------------------------------------------------------------------------------------------------------------**");
        System.out.printf("%-2s %-15s %-27s %-15s %-15s %-20s %-13s %-2s \n", "**", "Ma hang",
                "Ten hang hoa", "Loai","Gia nhap", "So luong ton kho", "Ngay nhap kho", "**");
        System.out.println(
                "**----------------------------------------------------------------------------------------------------------------**");
        while (current != null) {
            current.data.inThongTin();
            current = current.next;
        }
        System.out.println(
                "********************************************************************************************************************");

    }

    // =================Tra cứu=================
    void findType(String type) {

        Node current = head;
        
        while (current != null) {
            if (current.data.loai.equalsIgnoreCase(type)) {
                current.data.inThongTin();
            }
            current = current.next;
        }

    }
    //Tìm kiếm nhị phân

    void findPrice(int from, int to) throws ParseException {

        sortPriceUp(numberCommodity(),head);
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

        sortDateUp(numberCommodity(),head);
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
    //-----------------Sắp xếp tăng dần
    //Sắp xếp  nổi bọt
    void sortPriceUp(int slPT,Node start) throws ParseException {

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

    void callSortPriceUp() throws ParseException{
        sortPriceUp(numberCommodity(), head);
    }
    //Sắp xếp  nổi bọt
    void sortDateUp(int slPT,Node start) throws ParseException {

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

    void callSortDateUp() throws ParseException{
        sortDateUp(numberCommodity(), head);
    }


    //sắp xếp sản phẩm cùng loại đứng liên tiếp nhau trong danh sách
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
        return key;//trả về vị trí hiện tại của key
    }

    void sortTypeandPriceUp() throws ParseException{

        Node keyTP = head;
        //Sau khi thực hiện hàm sortType biến tham chiếu key vẫn = head nên phải cho hàm sortType trả về key
        Node keySS = sortType(keyTP, "Thuc pham");
        sortPriceUp(numberOfType("Thuc pham"), keyTP);
        Node keyDM = sortType(keySS, "Sanh su");
        sortPriceUp(numberOfType("Sanh su"), keySS);
        sortPriceUp(numberOfType("Dien may"), keyDM);
      
    }

    void sortTypeandDateUp() throws ParseException{
        
        Node keyTP = head;
        //Sau khi thực hiện hàm sortType biến tham chiếu key vẫn = head nên phải cho hàm sortType trả về key
        Node keySS = sortType(keyTP, "Thuc pham");
        sortDateUp(numberOfType("Thuc pham"), keyTP);
        Node keyDM = sortType(keySS, "Sanh su");
        sortDateUp(numberOfType("Sanh su"), keySS);
        sortDateUp(numberOfType("Dien may"), keyDM);
      
    }
    //-----------------Sắp xếp giảm dần
    //Sắp xếp  nổi bọt
    void sortPriceDown(int slPT,Node start) throws ParseException {

        Node current;
        int number = 0;
        while (number <= slPT - 2) {
            current = start;
            for (int i = 0; i < slPT - 1 - number; i++) {
                if (current.data.giaNhap < current.next.data.giaNhap) {
                    swapData(current.data, current.next.data);
                }
                current = current.next;
            }
            number++;
        }

    }

    void callSortPriceDown() throws ParseException{
        sortPriceDown(numberCommodity(), head);
    }

    //Sắp xếp  nổi bọt
    void sortDateDown(int slPT,Node start) throws ParseException {

        Node current;
        int number = 0;
        while (number <= slPT - 2) {
            current = start;
            for (int i = 0; i < slPT - 1 - number; i++) {
                if (current.data.ngayNhap.before(current.next.data.ngayNhap)) {
                    swapData(current.data, current.next.data);
                }
                current = current.next;
            }
            number++;
        }

    }

    
    void callSortDateDown() throws ParseException{
        sortDateDown(numberCommodity(), head);
    }


    void sortTypeandPriceDown() throws ParseException{

        Node keyTP = head;
        //Sau khi thực hiện hàm sortType biến tham chiếu key vẫn = head nên phải cho hàm sortType trả về key
        Node keySS = sortType(keyTP, "Thuc pham");
        sortPriceDown(numberOfType("Thuc pham"), keyTP);
        Node keyDM = sortType(keySS, "Sanh su");
        sortPriceDown(numberOfType("Sanh su"), keySS);
        sortPriceDown(numberOfType("Dien may"), keyDM);
      
    }

    void sortTypeandDateDown() throws ParseException{
        
        Node keyTP = head;
        //Sau khi thực hiện hàm sortType biến tham chiếu key vẫn = head nên phải cho hàm sortType trả về key
        Node keySS = sortType(keyTP, "Thuc pham");
        sortDateDown(numberOfType("Thuc pham"), keyTP);
        Node keyDM = sortType(keySS, "Sanh su");
        sortDateDown(numberOfType("Sanh su"), keySS);
        sortDateDown(numberOfType("Dien may"), keyDM);
      
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
            S += current.data.giaNhap*current.data.sLTonKho;
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