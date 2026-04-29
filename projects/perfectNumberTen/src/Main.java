import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.toRadians;

public class Main {
    public static void main(String[] args) {
        System.out.println(">Enter any whole, positive number.");
        int imperfect = verifyInput();
        int perfect = perfecting(imperfect);
        /*int total = perfectify(imperfect);
        int perfect = 10-(total);
        int perfect = 19 + (9*(imperfect-1));*/
        System.out.println(imperfect +"'s perfect number would be "+ perfect /*+ String.valueOf(perfect)*/);
    }

    private static int sum_of_digits(int n) {
        int current_sum = 0;
        while (n > 0) {
            current_sum += n % 10;
            n = n/10;
        }
        return current_sum;
    }

    private static int perfecting(int n) {
        int current = 0;
        int i = 0;
        while (current < n) {
            i++;
            if (sum_of_digits(i) == 10) {
                current++;
            }
        }
        return i;
    }

    /*private static int perfectify(int count) {
        int total = 0;
        while (count > 0) {
            int digit = count % 10;
            total += digit;
            count = count / 10;
        }
        return total;
    }*/

    private static int verifyInput() {
        //Verify that the input is an actual number
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean verified = false;
        while (!verified) {
            System.out.print(">");
            String inp = sc.next();
            try {
                //If the input is an integer, it will pass
                //Otherwise, it will not pass, and move directly to the "catch"
                n = Integer.parseInt(inp);
                if (n > 0) {
                    verified = true;
                } else {
                    System.out.println(">Input must have a positive value.");
                }
            } catch (NumberFormatException e) {
                System.out.println(">Input must be an integer.");
            }
        }
        return n;
    }
}