import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeChecker {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "2.1";

    public static void main(String[] args) {

        showWelcomeMessage();

        String word = "madam";

        // Choose algorithm dynamically
        PalindromeStrategy strategy = new DequeStrategy();
        // PalindromeStrategy strategy = new StackStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(word);

        if (result) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("Application execution completed.");
    }

    private static void showWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("        " + APP_NAME);
        System.out.println("        Version: " + VERSION);
        System.out.println("======================================");
        System.out.println();
    }
}

/* Strategy Interface */
interface PalindromeStrategy {
    boolean checkPalindrome(String word);
}

/* Stack Strategy */
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {

        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/* Deque Strategy */
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

/* Context Class */
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String word) {
        return strategy.checkPalindrome(word);
    }
}
