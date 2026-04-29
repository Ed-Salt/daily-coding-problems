import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println(">List as many words as you want, use 'Enter' after each word.");
        System.out.println(">When you're finished, type \"NEXT\".");
        List<String> words = inputList();
        int size = words.size();
        boolean[] grouped = new boolean[size];
        List<List<String>> groups = new ArrayList<List<String>>();
        for (int i = 0; i < size; i++) {
            if (grouped[i] == false) {
                String word = words.get(i);
                int length = word.length();
                groups.add(new ArrayList<String>());
                int end = groups.size()-1;
                groups.get(end).add(word);
                grouped[i] = true;
                for (int j = i + 1; j < size; j++) {
                    if (length == words.get(j).length()) {
                        int count = 0;
                        for (int k = 0; k < length; k++) {
                            String letter = words.get(j).substring(k,k+1);
                            if (word.contains(letter)) {
                                count++;
                            }
                        }
                        if (count == length) {
                            groups.get(end).add(words.get(j));
                            grouped[j] = true;
                        }
                    }
                }
            }
        }
        System.out.print("[");
        for (int i = 0; i < groups.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < groups.get(i).size(); j++) {
                System.out.print("'"+ groups.get(i).get(j) +"'");
                if (j+1 < groups.get(i).size()) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i+1 < groups.size()) {
                System.out.print(",");
                System.out.println();
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }

    private static List inputList() {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<String>();
        boolean exit = false;
        while (!exit) {
            System.out.print(">");
            String inp = sc.next();
            if (inp.equals("NEXT")) {
                exit = true;
            } else {
                words.add(inp.toLowerCase());
            }
        }
        return words;
    }
}