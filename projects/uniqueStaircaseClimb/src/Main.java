import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println(">How many steps should there be on the staircase?");
        //boolean end = false;
        int steps = verifyInput();
        double mid = steps / 2;
        int end = steps;
        int i = 0;
        int pos = 0;
        List ones = initialiseList(steps);
        List twos = new ArrayList();
        while (twos.size() - 1 < mid) {
            boolean endTwo = false;
            int oneEnd = ones.size()-1;
            endTwo = printLists(ones, twos, pos, mid);
            if (i < 1) {
                ones.remove(oneEnd);
                ones.remove(oneEnd-1);
                twos.add(2);
            } else {
                pos++;
            }
            if (endTwo) {
                twos.add(2);
                if (twos.size() - 1 < mid) {
                    ones.remove(oneEnd);
                    ones.remove(oneEnd - 1);
                    pos = 0;
                }
            }
            i++;
        }
    }
    /*

    private static int stairMethods(int steps, int mid, int n) {
        int count = 0;
        System.out.print(">");
        for (int i = 0; i < steps-n; i++) {

            System.out.print("1");
            count++;
        }
        System.out.println();
        return count;
    }

    private static boolean OLDstairMethods(int steps, int pos) {
        int count = 0;
        System.out.print(">");
        for (int i = 0; i < steps; i++) {
            if(pos == 0) {
                System.out.print("1");
            } else if(pos >= steps) {
                System.out.print("2");
                count += 2;
                i++;
            }else if(pos-1 == i) {
                System.out.print("2");
                count += 2;
                i++;
            } else {
                System.out.print("1");
            }
            if(i < steps-1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        if(count >= steps) {
            return true;
        }
        return false;
    }*/

    private static boolean printLists(List ones, List twos, int pos, double mid) {
        int count = 0;
        int size = ones.size()+twos.size();
        boolean endTwo = false;
        for (int i = 0; i < size; i++) {
            if ((i == pos && twos.size() > 0) || twos.size() >= mid) {
                System.out.print(twos.get(count));
                count++;
                endTwo = true;
            } else {
                System.out.print(ones.get(i-count));
                endTwo = false;
            }
            if (i < size-1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
        return endTwo;
    }

    private static List initialiseList(int n) {
        List list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(1);
        }
        return list;
    }

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
                verified = true;
            } catch (NumberFormatException e) {
                System.out.println(">Input must be an integer.");
            }
        }
        return n;
    }
}