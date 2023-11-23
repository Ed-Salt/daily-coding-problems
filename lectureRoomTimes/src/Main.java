import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(">How many time slots are there?");
        int slots = verifyInput(1,0);
        int[][] times = new int[2][slots];
        int endTime = 0;
        for (int i = 0; i < slots; i++) {
            System.out.println(">What time does slot "+ (i+1) +" start? (in minutes)");
            times[0][i] = verifyInput(0,0);
            System.out.println(">What time does slot "+ (i+1) +" end? (in minutes)");
            times[1][i] = verifyInput(times[0][i], 0);
            if (times[1][i] > endTime) {
                endTime = times[1][i];
            }
        }
        int maxRooms = 0;
        for (int i = 0; i < endTime; i++) {
            int count = 0;
            for (int j = 0; j < slots; j++) {
                if (times[0][j] <= i && times[1][j] >= i) {
                    count ++;
                }
            }
            if (count > maxRooms) {
                maxRooms = count;
            }
        }
        System.out.println(">To fit all slots, there should be at least "+ maxRooms +" rooms.");
    }

    private static int verifyInput(int min, int max) {
        //Verify that the input is an actual number, and falls between the provided min and max values
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
                //Check the input isn't smaller than the min value
                if (n >= min) {
                    verified = true;
                    //Maximum limit is optional, so if 'max' = 0, then a maximum limit will be ignored
                    //Otherwise, it will be checked against the input, and undo the 'true' pass
                    //If it falls above the maximum
                    if (max > 1) {
                        if (n > max) {
                            System.out.println(">Input must be no more than "+ (max) +".");
                            verified = false;
                        }
                    }
                } else {
                    System.out.println(">Input must be at least "+ (min) +".");
                }
            } catch (NumberFormatException e) {
                System.out.println(">Input must be an integer.");
            }
        }
        return n;
    }
}