import java.util.Scanner;

class OnlineQuizPlatform {
    private static double balance = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Welcome ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            //read the cutomer input
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        System.out.println("Thank you for using our banking app!");
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        //read the amount
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        }
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        //read the amount
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your balance is: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }
}