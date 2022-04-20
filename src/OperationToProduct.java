
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct {
    Scanner sc = new Scanner(System.in);

    /**
     * Searching and returning the index of product p in the list. If not found
     * return -1.
     *
     * @param p    Product for searching
     * @param list The Linked List
     * @return The index of product p in the list
     */
    public int index(Product p, MyList<Product> list) {
        int index = 0;
        Node<Product> currentNode = list.head;

        if (p == null) {
            while (currentNode != null) {
                if (currentNode.info == null) {
                    return index;
                }
                currentNode = currentNode.next;
                index++;
            }
        } else {
            while (currentNode != null) {
                if (currentNode.info == p) {
                    return index;
                }
                currentNode = currentNode.next;
                index++;
            }
        }
        return -1;
    }

    /**
     * Creating and returning a product with info input from keyboard.
     *
     * @return The product
     */
    public Product createProduct() {
        System.out.print("\nInput new ID: ");
        String bcode = sc.nextLine();
        System.out.print("Input Product's Name: ");
        String title = sc.nextLine();
        System.out.print("Input Product's quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Input Product's price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println();

        Product newProduct = new Product(bcode, title, quantity, price);
        return newProduct;
    }

    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split("\\|");
                
                String id = arr[0].trim();
                String title = arr[1].trim();
                int quantity = Integer.parseInt(arr[2].trim());
                double price = Double.parseDouble(arr[3]);
                
                Product p = new Product(id, title, quantity, price);
                list.insertAfterPosition(list.length(), p);

            }
            displayAll(list);
            System.out.println("\nSuccessfully!\n");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param list     The Stack contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split("\\|");
                
                String id = arr[0].trim();
                String title = arr[1].trim();
                int quantity = Integer.parseInt(arr[2].trim());
                double price = Double.parseDouble(arr[3].trim());
                
                Product p = new Product(id, title, quantity, price);
                stack.push(p);

            }

            MyList<Product> list = new MyList<>();
            while(stack.head != null) {
                list.insertAfterPosition(list.length(), stack.pop());
            }

            displayAll(list);

            System.out.println("Successfully!\n");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param list     The Queue contains all products that read from file
     * @throws Exception
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws Exception {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split("\\|");
                
                String id = arr[0].trim();
                String title = arr[1].trim();
                int quantity = Integer.parseInt(arr[2].trim());
                double price = Double.parseDouble(arr[3].trim());
                
                Product p = new Product(id, title, quantity, price);
                queue.enqueue(p);

            }

            MyList<Product> list = new MyList<>();
            while(queue.head != null) {
                list.insertAfterPosition(list.length(), queue.dequeue());
            }

            displayAll(list);

            System.out.println("Successfully!\n");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     *
     * @param list The Linked list
     */
    public void addLast(MyList<Product> list) {
        Product product = createProduct();

        list.insertAfterPosition(list.length(), product);
    }

    /**
     * Printing all prodcuts of the list to console screen
     *
     * @param list
     */
    public void displayAll(MyList<Product> list) {
        System.out.println("\nID | Title | Quantuty | price");
        System.out.println("-----------------------------");

        for (int i = 0; i < list.length(); i++) {
            System.out.println(list.getNode(i).toString());
        }

        System.out.println();
    }

    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for (int i = 0; i < list.length(); i++) {
                myWriter.write(list.getNode(i).toString() + "\n");
            }
            myWriter.close();
            System.out.println("\nSuccessfully!\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Searching product by ID input from keyboard.
     *
     * @param list
     */
    public void searchByCode(MyList<Product> list) {
        System.out.print("Input the ID to search = ");
        String inID = sc.nextLine();
        
        Node<Product> curr = list.head;
        while(curr != null) {
            if(curr.info.getBcode().equalsIgnoreCase(inID)) {
                System.out.println("\nResult: " + curr.info.toString() + "\n");
                return;
            }
            curr = curr.next;
        }

        if(curr == null) {
            System.out.println("\nProduct does not exist\n");
        }

    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list
     */
    public void deleteByCode(MyList<Product> list) {
        System.out.print("Input the bcode to delete = ");
        String inID = sc.nextLine();

        Node<Product> curr = list.head;
        while(curr != null) {
            if(curr.info.getBcode().equalsIgnoreCase(inID)) {
                list.deleteElement(curr.info);
                System.out.println("\nDeleted!\n");
                return;
            }
            curr = curr.next;
        }

        if(curr == null) {
            System.out.println("\nThe product to be deleted does not exist\n");
        }

    }

    /**
     * Sorting products in linked list by ID
     *
     * @param list The Linked list
     */
    public void sortByCode(MyList<Product> list) {
        for (int i = 0; i < list.length() - 1; i++) {
            for (int j = i + 1; j < list.length(); j++) {
                if (list.getNode(i).info.getBcode().compareTo(list.getNode(j).info.getBcode()) > 0) {
                    list.swap(list.getNode(i), list.getNode(j));
                }
            }
        }
        System.out.println("\nSuccessfully!\n");
    }

    /**
     * Adding new product to head of Linked List. The info input from keyboard.
     *
     * @param list The linked list
     */
    public void addFirst(MyList<Product> list) {
        Product p = createProduct();

        list.insertToHead(p);
    }

    /**
     * Convert a decimal to an array of binary. Example: input i = 18 -> Output =
     * {0, 1, 0, 0, 0, 1}
     *
     * @param i Input decimal number
     * @return Array of binary numbers
     */
    public int convertToBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return i % 2 + 10 * convertToBinary(i / 2);
        }
    }

    /**
     * Deleting the product at position
     *
     * @param list The Linked List
     * @param pos  The position of product to be deleted
     */
    public void deleteAtPosition(MyList<Product> list, int pos) {
        list.deleteElement(list.getNode(pos).info);
    }
}