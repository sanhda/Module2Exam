package controller;
import request.FactoryRequest;
import request.Request;

import java.util.Scanner;

public class Controller {
    public static void showMenu() {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--");
        System.out.println("Chọn chức năng theo số để tiếp tục");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách các bệnh án");
        System.out.println("4. Thoát");
        System.out.println("Chọn chức năng");
    }
    public static boolean start() {
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        // quit if user use action 4
        if (action == 4) {
            return false;
        }

        // process request
        processRequest(action);
        return true;
    }

    public static void processRequest(int action) {

        // using factory pattern to get request subclass
        Request request = FactoryRequest.getRequest(action);
        if (request==null || !request.isValid()) {
            System.out.println("Action không hợp lệ");
            return;
        }

        // call abstract method
        request.processRequest();
    }
}
