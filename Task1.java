import java.util.Scanner;

class ATM {
    private String userID;
    private int pin;
    private double balance;

    public ATM(String userID, int pin, double initialBalance) {
        this.userID = userID;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM system!");
        System.out.println("1. Balance Inquiry");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Change PIN");
        System.out.println("6. Exit");
    }

    public void executeTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Your balance is: $" + balance);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
                    balance -= withdrawalAmount;
                    System.out.println("Withdrawal successful!");
                } else {
                    System.out.println("Insufficient funds or invalid amount.");
                }
                break;
            case 3:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    balance += depositAmount;
                    System.out.println("Deposit successful!");
                } else {
                    System.out.println("Invalid deposit amount.");
                }
                break;
            case 4:
                // Implement fund transfer logic here
                break;
            case 5:
                System.out.print("Enter new PIN: ");
                int newPin = scanner.nextInt();
                this.pin = newPin;
                System.out.println("PIN changed successfully!");
                break;
            case 6:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your user ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        ATM atm = new ATM(userID, pin, 1000.0); // Initial balance is $1000.0

        while (true) {
            System.out.println("----------------------------");
            atm.displayMenu();
            System.out.print("Select an option (1-6): ");
            int choice = scanner.nextInt();

            atm.executeTransaction(choice, scanner);
        }
    }
}