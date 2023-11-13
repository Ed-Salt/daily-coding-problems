import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import static java.lang.Math.abs;

public class Main {
    //*-------------------------------------------------------------------------------------------------*
    // Calculate the minimum distance possible when traversing through a sequence of points on a 2D grid
    //*-------------------------------------------------------------------------------------------------*

    public static void main(String[] args) {
        int min = 1;
        int max = 0;
        int distance = 0;
        System.out.println(">What value should 'x' be?");
        int x = verifyInput(min, max);
        System.out.println(">What value should 'y' be?");
        if (x == 1) {
            //If 'x' is a size 1, then the minimum for 'y' is changed to 2
            //This is to ensure there are at least 2 grid points available
            min += 1;
        }
        int y = verifyInput(min, max);
        System.out.println(">Grid made from (0,0) to ("+ (x-1) +", "+ (y-1) +").");
        //There can be a minimum of 2 points so that a distance is calculable
        min = 2;
        //A maximum value to limit the number of stops isn't required
        //But helps to keep the stops to input and calculate at a reasonable number
        max = x*y;
        System.out.println(">How many stops should there be?");
        int size = verifyInput(min, max);
        //Minimum of 0, as all grids will have (0,0) as the smallest possible point
        min = 0;
        List<int[]> stops = new ArrayList();
        for (int i = 0; i < size; i++) {
            int[] coords = new int[2];
            for (int j = 0; j < 2; j++) {
                System.out.println(">What should value "+ (j+1) +" be for stop #"+ (i+1) +"?");
                //When 'j' is 0, it asks for the 'x' coordinate
                //And when 'j' is 1, it asks for the 'y'
                if (j == 0) {
                    max = x-1;
                } else {
                    max = y-1;
                }
                //Record the entered value, either 'x' or 'y'
                coords[j] = verifyInput(min, max);
            }
            //Adds the entered 'x' and 'y' values to a list of the stops
            stops.add(coords);
            System.out.println(">Stop made at ("+ coords[0] +", "+ coords[1] +").");
            if (i > 0) {
                //It is possible to move any direction in the 2D grid (including diagonal)
                //Therefore, in order to calculate the distance, simply use whichever value is bigger:
                //The difference between x's or the difference between y's
                int xGap = abs(stops.get(i)[0] - stops.get(i - 1)[0]);
                int yGap = abs(stops.get(i)[1] - stops.get(i - 1)[1]);
                //Add the larger value to the total distance tracker
                if (xGap > yGap) {
                    distance += xGap;
                } else {
                    distance += yGap;
                }
            }
        }
        System.out.println(">The shortest path should be: "+ distance +".");
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
                //Check the input is larger than the min value
                if (n > min-1) {
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
