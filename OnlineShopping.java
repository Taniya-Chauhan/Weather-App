import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class OnlineShopping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Product List
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Mobile", 20000));
        products.add(new Product(3, "Headphones", 2000));
        products.add(new Product(4, "Smart Watch", 5000));

        ArrayList<Product> cart = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : products) {
                        System.out.println(p.id + ". " + p.name + " - ₹" + p.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to add: ");
                    int pid = sc.nextInt();
                    boolean found = false;

                    for (Product p : products) {
                        if (p.id == pid) {
                            cart.add(p);
                            System.out.println("Product added to cart!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty!");
                    } else {
                        System.out.println("\nItems in Cart:");
                        for (Product p : cart) {
                            System.out.println(p.name + " - ₹" + p.price);
                        }
                    }
                    break;

                case 4:
                    double total = 0;
                    System.out.println("\n----- BILL -----");
                    for (Product p : cart) {
                        System.out.println(p.name + " - ₹" + p.price);
                        total += p.price;
                    }
                    System.out.println("Total Amount: ₹" + total);
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
