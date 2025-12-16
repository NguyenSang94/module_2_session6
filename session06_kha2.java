package session06_Kha2;

import java.util.Scanner;


public class session06_kha2 {
    static String hoTen = "";
    static String email = "";
    static String dienThoai = "";
    static String matKhau = "";
    static void main() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n************** QUẢN LÝ NGƯỜI DÙNG **************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập họ tên: ");
                    hoTen = sc.nextLine();

                    System.out.print("Nhập email: ");
                    email = sc.nextLine();

                    System.out.print("Nhập số điện thoại: ");
                    dienThoai = sc.nextLine();

                    System.out.print("Nhập mật khẩu: ");
                    matKhau = sc.nextLine();
                    break;

                case 2:
                    if (hoTen.isEmpty()) {
                        System.out.println("⚠ Chưa nhập họ tên!");
                    } else {
                        hoTen = chuanHoaHoTen(hoTen);
                        System.out.println("Họ tên sau chuẩn hóa: " + hoTen);
                    }
                    break;

                case 3:
                    System.out.println(
                            kiemTraEmail(email)
                                    ? "✅ Email hợp lệ"
                                    : "❌ Email không hợp lệ"
                    );
                    break;

                case 4:
                    System.out.println(
                            kiemTraDienThoai(dienThoai)
                                    ? "✅ Số điện thoại hợp lệ"
                                    : "❌ Số điện thoại không hợp lệ"
                    );
                    break;

                case 5:
                    System.out.println(
                            kiemTraMatKhau(matKhau)
                                    ? "✅ Mật khẩu hợp lệ"
                                    : "❌ Mật khẩu không hợp lệ"
                    );
                    break;

                case 6:
                    System.out.println("👋 Thoát chương trình");
                    break;

                default:
                    System.out.println("⚠ Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);

        sc.close();
    }

    // ====== HÀM CHUẨN HÓA HỌ TÊN ======
    static String chuanHoaHoTen(String name) {
        name = name.trim().toLowerCase();
        String[] arr = name.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1))
                    .append(" ");
        }
        return result.toString().trim();
    }

    // ====== KIỂM TRA EMAIL ======
    static boolean kiemTraEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

    // ====== KIỂM TRA SĐT VIỆT NAM ======
    static boolean kiemTraDienThoai(String phone) {
        String regex = "^(03|05|07|08|09)[0-9]{8}$";
        return phone.matches(regex);
    }

    // ====== KIỂM TRA MẬT KHẨU ======
    static boolean kiemTraMatKhau(String password) {
        String regex =
                "^(?=.*[a-z])" +       // chữ thường
                        "(?=.*[A-Z])" +       // chữ hoa
                        "(?=.*\\d)" +          // chữ số
                        "(?=.*[@$!%*?&])" +    // ký tự đặc biệt
                        "[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(regex);
    }

}
