import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        ATMMachine obj = new ATMMachine();
        obj.checkpin();
    }
}


class ATMMachine {
    int Balance;
    int PIN = 5674;

    public void checkpin() {
        System.out.println("enter your PIN");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if (enteredpin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid Pin");
            return;
        }
    }

    public void menu() {
        System.out.println("Enter Your Choice");
        System.out.println("1. Check A/c Balance ");
        System.out.println("2. Balance Withdraw");
        System.out.println("3. Deposit Balance");
        System.out.println("4. Transfer");
        System.out.println("5. EXIT");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            BalanceWithdraw();
        } else if (opt == 3) {
            DepositBalance();
        } else if (opt == 4) {
            transferMoney();
        } else if (opt == 5) {
            return;
        } else {
            System.out.println("Enter a valid Choice");
        }
    }

    public void checkBalance() {
        System.out.println("Balance:" + Balance);
        menu();
    }

    public void BalanceWithdraw() {
        System.out.println("Enter an amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        if (amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - amount;
            System.out.println("Money Withdraw Successfully");
        }
        menu();
    }

    public void DepositBalance() {
        System.out.println("Enter the Amount");
        Scanner sc = new Scanner(System.in);
        int Amount = sc.nextInt();
        Balance = Balance + Amount;
        System.out.println("Money Deposited successfully");
        menu();
    }

    public void transferMoney() {
        System.out.println("Enter the account number to transfer to:");
        Scanner sc = new Scanner(System.in);
        int accountNumber = sc.nextInt();

       
        int[] accountNumbers = {1234, 5678, 91011};
        int[] accountBalances = {10000, 20000, 30000};

        boolean found = false;
        int transferIndex = -1;

        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == accountNumber) {
                found = true;
                transferIndex = i;
                break;
            }
        }

        if (found) {
            System.out.println("Enter the amount to transfer:");
            int transferAmount = sc.nextInt();

            if (transferAmount > Balance) {
                System.out.println("Insufficient Balance");
            } else {
                Balance -= transferAmount;
                accountBalances[transferIndex] += transferAmount;
                System.out.println("Money Transferred Successfully");
            }
        } else {
            System.out.println("Invalid account number");
        }

        menu();
    }
}

