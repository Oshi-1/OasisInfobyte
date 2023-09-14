import java.util.Scanner;

public class numberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int myNumber = (int) (Math.random() * 100);
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.println("Guess my number (1-100): ");
            int userNumber = sc.nextInt();
            attempts++;

            if (userNumber == myNumber) {
                System.out.println("WOOHOOO..CORRECT NUMBER !!!");
                break;
            } else if (userNumber > myNumber) {
                System.out.println("Your number is too large.");
            } else {
                System.out.println("Your number is too small.");
            }

            int remainingAttempts = maxAttempts - attempts;
            System.out.println("Remaining attempts: " + remainingAttempts);
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. My number was: " + myNumber);
        }
    }
}
