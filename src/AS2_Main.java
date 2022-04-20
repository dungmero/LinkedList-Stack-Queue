
import java.io.File;
import java.util.Scanner;

public class AS2_Main {
    public static void showMenu() {
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        MyList<Product> list = new MyList<>();
        OperationToProduct obj = new OperationToProduct();

        String fileName = new File("").getAbsolutePath();
        fileName = fileName + "\\src\\data.txt";
        
        Scanner sc = new Scanner(System.in);
        int choice;
        /**
         * Chương trình gồm các chức năng sau
         * 
         * 1.Đọc dữ liệu có sẵn từ file chứa các sản phẩm rồi lưu vào Linked List 
         * 2.Nhập và thêm một sản phẩm vào cuối của danh sách Linked List 
         * 3.Hiển thị thông tin của các sản phẩm trong Linked List 
         * 4.Lưu danh sách các sản phẩm vào file
         * 5.Tìm kiếm thông tin của sản phẩm theo ID 
         * 6.Xóa sản phẩm trong danh sách theo ID 
         * 7.Sắp xếp các sản phẩm trong danh sách theo ID 
         * 8.Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên
         * trong Linked List về hệ đếm nhị phân bằng phương pháp đệ quy. 
         * 9.Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Liệt kê ra màn 
         * hình các sản phẩm có trong stack. 
         * 10.Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình
         * các sản phẩm có trong queue.
         */
        do {
            showMenu();
            System.out.println();
            System.out.print("choice = ");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                obj.getAllItemsFromFile(fileName, list);
                break;
            case 2:
                obj.addLast(list);
                break;
            case 3:
                obj.displayAll(list);
                break;
            case 4:
                obj.writeAllItemsToFile(fileName, list);
                break;
            case 5:
                obj.searchByCode(list);
                break;
            case 6:
                obj.deleteByCode(list);
                break;
            case 7:
                obj.sortByCode(list);
                break;
            case 8:
                int topQuantity = list.getNode(0).info.getQuantity();
                int kq = obj.convertToBinary(topQuantity);
                System.out.println(String.format("Quantity = %d => (%d)", topQuantity, kq));
                break;
            case 9:
                MyStack<Product> stack = new MyStack<>();
                obj.getAllItemsFromFile(fileName, stack);
                break;
            case 10:
                MyQueue<Product> queue = new MyQueue<>();
                try {
                    obj.getAllItemsFromFile(fileName, queue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 0:
                System.out.println("Thanks!!!");
                break;
            default:
                System.err.println("Lua chon ko hop le");
                break;
            }
        } while (choice != 0);
        sc.close();
    }

}