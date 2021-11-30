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
    // Quản lý danh sách

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

        addTail(new Commodity(1, "Nuoc nam", "Thuc pham", 10000, 15, sdf.parse("20/11/2015")));
        addTail(new Commodity(2, "Lo hoa", "Sanh su", 15000, 30, sdf.parse("12/10/2018")));
        addTail(new Commodity(3, "May say toc", "Dien may", 25000, 7, sdf.parse("03/09/2019")));
        addTail(new Commodity(4, "Coca", "Thuc pham", 30000, 50, sdf.parse("29/11/2020")));
        addTail(new Commodity(5, "Noi com dien", "Dien may", 50000, 20, sdf.parse("19/02/2021")));
        addTail(new Commodity(6, "Tivi", "Dien may", 100000, 7, sdf.parse("22/04/2021")));

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

    // Báo cáo-Thống kê
    int numberCommodity() {
        Node current = head;
        sL = 0;
        while (current != null) {
            sL++;
            current = current.next;
        }
        return sL;
    }

    // Tra cứu
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

    void findCost(int from, int to) {
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

    void findDate(Date from, Date to) {
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
}
