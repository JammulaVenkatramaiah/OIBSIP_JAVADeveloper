import java.util.*;

class Account {
    String userId, userPin;
    double balance = 1000.0;
    List<String> history = new ArrayList<>();
    Account(String id, String pin) {
        userId = id; userPin = pin;
    }
    void deposit(double amt) { balance += amt; history.add("Deposited: " + amt); }
    boolean withdraw(double amt) {
        if (amt > balance) return false;
        balance -= amt; history.add("Withdrew: " + amt); return true;
    }
}

public class ATMInterface {
    private static Scanner sc = new Scanner(System.in);
    private static Account account = new Account("user", "1234");

    public static void main(String[] args) {
        System.out.print("Enter UserId: "); String id = sc.next();
        System.out.print("Enter Pin: "); String pin = sc.next();
        if (!id.equals(account.userId) || !pin.equals(account.userPin)) {
            System.out.println("Invalid credentials!"); return;
        }
        OUTER:
        while (true) {
            System.out.println("\n1.Transactions 2.Deposit 3.Withdraw 4.Transfer 5.Quit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.println("--Transactions History--");
                    for (String s : account.history) System.out.println(s);
                    System.out.println("Balance: " + account.balance);
                }
                case 2 ->                     {
                        System.out.print("Deposit amount: ");
                        double amt = sc.nextDouble();
                        account.deposit(amt);
                    }
                case 3 ->                     {
                        System.out.print("Withdraw amount: ");
                        double amt = sc.nextDouble();
                        if (account.withdraw(amt))
                            System.out.println("Amount withdrawn.");
                        else
                            System.out.println("Insufficient balance.");
                    }
                case 4 ->                     {
                        System.out.print("Transfer amount: ");
                        double amt = sc.nextDouble();
                        if (account.withdraw(amt))
                            System.out.println("Transferred " + amt);
                        else
                            System.out.println("Insufficient balance.");
                    }
                case 5 -> {
                    break OUTER;
                }
                default -> {
                }
            }
        }
    }
}
