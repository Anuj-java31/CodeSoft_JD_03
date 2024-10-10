import java.util.Scanner;

class BankAccount {
    private double bankBalance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.bankBalance = initialBalance;
        } else {
            System.out.println("Initial balnce can not be negative");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= bankBalance) {
            bankBalance -= amount;
            System.out.println(amount + " is withdrawed successfully");
        } else if (amount > bankBalance) {
            System.out.println("Insufficient balance");
        } else {
            System.out.println("Inavlid amount");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            bankBalance += amount;
            System.out.println(amount + " is deposited successfully");
        } else {
            System.out.println("Inavlid amount ");
        }
    }

    public String checkBalance() {
        return String.format("%.3f", bankBalance);
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // menu
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n... MENU ...");
            System.out.println("1: DEPOSIT AMOUNT");
            System.out.println("2: WITHDRAW AMOUNT");
            System.out.println("3: CHECK BALANCE");
            System.out.println("4: EXIT");
            System.out.println("CHOSE AN OPTION");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("ENTER THE AMOUNT TO DEPOSIT");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("ENTER THE AMOUNT TO WITHDRAW");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("AVAILABLE BALANCE " + account.checkBalance());
                    break;
                case 4:
                    System.out.println("Thanks for coming");
                    break;
                default:
                    System.out.println("CHOOSE A VALID OPTION");
                    break;
            }
        } while (choice != 4);
        sc.close();
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER INITIAL BALANCE FOR YOUR ACCOUNT");
        double initialBalance = sc.nextDouble();
        BankAccount myAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(myAccount);
        atm.displayMenu();
        sc.close();
    }
}
