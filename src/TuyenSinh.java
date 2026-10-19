import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<ThiSinh> danhSach = new ArrayList<>();

    public static void main(String[] args) {
        int luaChon;
        do {
            hienThiMenu();
            luaChon = nhapSoNguyen("Nhập lựa chọn: ");

            switch (luaChon) {
                case 1:
                    themThiSinh();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    timTheoSoBaoDanh();
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 4.");
            }
        } while (luaChon != 4);

        scanner.close();
    }

    private static void hienThiMenu() {
        System.out.println("\\n========== QUẢN LÝ THÍ SINH ĐẠI HỌC ==========");
        System.out.println("1. Thêm mới thí sinh");
        System.out.println("2. Hiển thị danh sách thí sinh");
        System.out.println("3. Tìm kiếm theo số báo danh");
        System.out.println("4. Thoát chương trình");
        System.out.println("==============================================");
    }

    private static void themThiSinh() {
        System.out.println("\\n--- THÊM THÍ SINH ---");
        System.out.print("Nhập số báo danh: ");
        String sbd = scanner.nextLine().trim();

        if (sbd.isEmpty()) {
            System.out.println("Số báo danh không được để trống.");
            return;
        }
        if (timThiSinh(sbd) != null) {
            System.out.println("Số báo danh đã tồn tại.");
            return;
        }

        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine().trim();
        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine().trim();
        int mucUuTien = nhapSoNguyen("Nhập mức ưu tiên: ");

        System.out.println("Chọn khối thi:");
        System.out.println("A. Toán, Lý, Hóa");
        System.out.println("B. Toán, Hóa, Sinh");
        System.out.println("C. Văn, Sử, Địa");
        System.out.print("Nhập A/B/C: ");
        String khoi = scanner.nextLine().trim().toUpperCase();

        ThiSinh thiSinh;
        switch (khoi) {
            case "A":
                thiSinh = new ThiSinhKhoiA(sbd, hoTen, diaChi, mucUuTien);
                break;
            case "B":
                thiSinh = new ThiSinhKhoiB(sbd, hoTen, diaChi, mucUuTien);
                break;
            case "C":
                thiSinh = new ThiSinhKhoiC(sbd, hoTen, diaChi, mucUuTien);
                break;
            default:
                System.out.println("Khối thi không hợp lệ. Chưa thêm thí sinh.");
                return;
        }

        danhSach.add(thiSinh);
        System.out.println("Thêm thí sinh thành công.");
    }

    private static void hienThiDanhSach() {
        System.out.println("\\n--- DANH SÁCH THÍ SINH ---");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách hiện chưa có thí sinh.");
            return;
        }

        for (ThiSinh thiSinh : danhSach) {
            thiSinh.hienThiThongTin();
        }
    }

    private static void timTheoSoBaoDanh() {
        System.out.print("Nhập số báo danh cần tìm: ");
        String sbd = scanner.nextLine().trim();
        ThiSinh thiSinh = timThiSinh(sbd);

        if (thiSinh == null) {
            System.out.println("Không tìm thấy thí sinh có số báo danh: " + sbd);
        } else {
            System.out.println("--- KẾT QUẢ TÌM KIẾM ---");
            thiSinh.hienThiThongTin();
        }
    }

    private static ThiSinh timThiSinh(String sbd) {
        for (ThiSinh thiSinh : danhSach) {
            if (thiSinh.getSoBaoDanh().equalsIgnoreCase(sbd)) {
                return thiSinh;
            }
        }
        return null;
    }

    private static int nhapSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
    }
}
