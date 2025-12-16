package session06_Kha1;

import java.util.Scanner;
import java.util.Arrays;

public class session06_kha1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        double[] diemSV = new double[0];
        int choice;

        do {
            System.out.println("\n************* QUẢN LÝ ĐIỂM SV *************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = Integer.parseInt(sc.nextLine());
                    diemSV = new double[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                        diemSV[i] = Double.parseDouble(sc.nextLine());
                    }
                    break;

                case 2:
                    if (diemSV.length == 0) {
                        System.out.println("⚠ Chưa có dữ liệu!");
                    } else {
                        System.out.println("Danh sách điểm:");
                        for (double d : diemSV) {
                            System.out.print(d + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (diemSV.length == 0) {
                        System.out.println("⚠ Chưa có dữ liệu!");
                    } else {
                        double tong = 0;
                        for (double d : diemSV) {
                            tong += d;
                        }
                        System.out.println("Điểm trung bình = " + (tong / diemSV.length));
                    }
                    break;

                case 4:
                    if (diemSV.length == 0) {
                        System.out.println("⚠ Chưa có dữ liệu!");
                    } else {
                        double max = diemSV[0];
                        double min = diemSV[0];

                        for (double d : diemSV) {
                            if (d > max) max = d;
                            if (d < min) min = d;
                        }
                        System.out.println("Điểm cao nhất: " + max);
                        System.out.println("Điểm thấp nhất: " + min);
                    }
                    break;

                case 5:
                    if (diemSV.length == 0) {
                        System.out.println("⚠ Chưa có dữ liệu!");
                    } else {
                        int dat = 0, truot = 0;
                        for (double d : diemSV) {
                            if (d >= 5) dat++;
                            else truot++;
                        }
                        System.out.println("Số sinh viên ĐẠT: " + dat);
                        System.out.println("Số sinh viên TRƯỢT: " + truot);
                    }
                    break;

                case 6:
                    if (diemSV.length == 0) {
                        System.out.println("⚠ Chưa có dữ liệu!");
                    } else {
                        Arrays.sort(diemSV);
                        System.out.println("Đã sắp xếp điểm tăng dần!");
                    }
                    break;

                case 7:
                    if (diemSV.length == 0) {
                        System.out.println("⚠ Chưa có dữ liệu!");
                    } else {
                        int gioi = 0, xuatSac = 0;
                        for (double d : diemSV) {
                            if (d >= 9) xuatSac++;
                            else if (d >= 8) gioi++;
                        }
                        System.out.println("Số sinh viên GIỎI: " + gioi);
                        System.out.println("Số sinh viên XUẤT SẮC: " + xuatSac);
                    }
                    break;

                case 8:
                    System.out.println("👋 Thoát chương trình");
                    break;

                default:
                    System.out.println("⚠ Lựa chọn không hợp lệ!");
            }

        } while (choice != 8);

        sc.close();
    }
}
