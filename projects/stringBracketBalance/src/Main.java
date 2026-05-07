import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem:
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 *
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 */

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(isBalanced("([])[]({})")); // true
        System.out.println(isBalanced("([)]")); // false
        System.out.println(isBalanced("")); // true
        System.out.println(isBalanced("((()")); // false
        System.out.println(isBalanced("((()))")); // true
        System.out.println(isBalanced("([)]{}")); // false
        System.out.println(isBalanced("({[a]})")); // null
    }

    public static Boolean isBalanced(String input)
    {
        if (input.isEmpty()) { return true; }

        boolean isValid = input.matches("[\\(\\)\\[\\]\\{\\}]+");
        if (!isValid) { return null; }

        boolean isEven = input.length() % 2 == 0;
        if (!isEven) { return false; }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (int i = 0; i < input.length(); i++)
        {
            char character = input.charAt(i);
            if (pairs.containsKey(character))
            {
                if (stack.isEmpty()) { return false; }
                Character lastOpen = stack.pop();
                if (!lastOpen.equals(pairs.get(character))) { return false; }
            }
            else { stack.push(character); }
        }
        return stack.isEmpty();
    }
}