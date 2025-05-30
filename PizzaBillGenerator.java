import java.util.Scanner;

class Pizza {
    protected String type;
    protected int basePrice;
    protected final int CHEESE_PRICE = 100;
    protected final int TOPPINGS_PRICE = 150;
    protected final int TAKEAWAY_PRICE = 20;
    protected boolean isTakeaway = false;

    public Pizza(String type, int basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }

    public void addTakeaway(boolean choice) {
        isTakeaway = choice;
    }

    public int getTotalPrice() {
        int total = basePrice;
        if (isTakeaway) total += TAKEAWAY_PRICE;
        return total;
    }

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("-------- PIZZAMANIA BILL --------\n");
        bill.append("Pizza Type       : ").append(type).append("\n");
        bill.append("Base Price       : ₹").append(basePrice).append("\n");
        if (isTakeaway) {
            bill.append("Takeaway Charges : ₹").append(TAKEAWAY_PRICE).append("\n");
        }
        bill.append("---------------------------------\n");
        bill.append("Total Price      : ₹").append(getTotalPrice()).append("\n");
        bill.append("---------------------------------\n");
        return bill.toString();
    }
}

class DeluxePizza extends Pizza {
    public DeluxePizza(String type, int basePrice) {
        super(type, basePrice);
    }

    @Override
    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("-------- PIZZAMANIA BILL --------\n");
        bill.append("Pizza Type       : ").append(type).append(" (Deluxe)\n");
        bill.append("Base Price       : ₹").append(basePrice - CHEESE_PRICE - TOPPINGS_PRICE).append("\n");
        bill.append("Included Cheese  : ₹").append(CHEESE_PRICE).append("\n");
        bill.append("Included Toppings: ₹").append(TOPPINGS_PRICE).append("\n");
        if (isTakeaway) {
            bill.append("Takeaway Charges : ₹").append(TAKEAWAY_PRICE).append("\n");
        }
        bill.append("---------------------------------\n");
        bill.append("Total Price      : ₹").append(getTotalPrice()).append("\n");
        bill.append("---------------------------------\n");
        return bill.toString();
    }
}

public class PizzaBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pizza pizza = null;

        System.out.println("===== Welcome to PIZZAMANIA =====");
        System.out.println("Select your pizza:");
        System.out.println("1. Veg Pizza           ₹300");
        System.out.println("2. Non-Veg Pizza       ₹400");
        System.out.println("3. Deluxe Veg Pizza    ₹550 (includes cheese + toppings)");
        System.out.println("4. Deluxe Non-Veg Pizza ₹650 (includes cheese + toppings)");
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                pizza = new Pizza("Veg Pizza", 300);
                break;
            case 2:
                pizza = new Pizza("Non-Veg Pizza", 400);
                break;
            case 3:
                pizza = new DeluxePizza("Deluxe Veg Pizza", 550);
                break;
            case 4:
                pizza = new DeluxePizza("Deluxe Non-Veg Pizza", 650);
                break;
            default:
                System.out.println("Invalid selection. Please restart.");
                sc.close();
                return;
        }

        System.out.print("Do you want takeaway? (Y/N): ");
        char takeAway = sc.next().charAt(0);
        pizza.addTakeaway(takeAway == 'Y' || takeAway == 'y');

        // Generate and display the bill
        System.out.println();
        System.out.println(pizza.generateBill());

        sc.close();
    }
}
