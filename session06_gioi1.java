package session06_Gioi1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class session06_gioi1 {
    static void main() {
     

        Scanner sc = new Scanner(System.in);
        String[] bienSo = new String[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n******** QUẢN LÝ BIỂN SỐ XE ********");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng biển số: ");
                    int n = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập biển số thứ " + (count + 1) + ": ");
                        bienSo[count] = sc.nextLine();
                        count++;
                    }
                    break;

                case 2:
                    System.out.println("Danh sách biển số:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(bienSo[i]);
                    }
                    break;

                case 3:
                    System.out.print("Nhập biển số cần tìm: ");
                    String tim = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (bienSo[i].equals(tim)) {
                            found = true;
                            break;
                        }
                    }

                    if (found)
                        System.out.println("✅ Tìm thấy biển số");
                    else
                        System.out.println("❌ Không tìm thấy");
                    break;

                case 4:
                    System.out.print("Nhập mã tỉnh (vd: 30, 51): ");
                    String maTinh = sc.nextLine();
                    boolean co = false;

                    for (int i = 0; i < count; i++) {
                        if (bienSo[i].startsWith(maTinh)) {
                            System.out.println(bienSo[i]);
                            co = true;
                        }
                    }

                    if (!co)
                        System.out.println("❌ Không có biển số thuộc tỉnh này");
                    break;

                case 5:
                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {
                            if (bienSo[i].compareTo(bienSo[j]) > 0) {
                                String temp = bienSo[i];
                                bienSo[i] = bienSo[j];
                                bienSo[j] = temp;
                            }
                        }
                    }
                    System.out.println("✅ Đã sắp xếp tăng dần");
                    break;

                case 6:
                    System.out.println("👋 Thoát chương trình");
                    break;

                default:
                    System.out.println("⚠ Lựa chọn không hợp lệ");
            }

        } while (choice != 6);

        sc.close();
    }
}
