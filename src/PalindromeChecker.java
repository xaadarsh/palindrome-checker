import java.util.Stack;

public class PalindromeChecker {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "1.4";

    public static void main(String[] args) {

        showWelcomeMessage();

        // UC5 Feature
        checkUsingStack();

        System.out.println("Application execution completed.");
    }

    private static void showWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("        " + APP_NAME);
        System.out.println("        Version: " + VERSION);
        System.out.println("======================================");
        System.out.println();
    }

    // 🔥 UC5 - Stack Based Palindrome Check
    private static void checkUsingStack() {

        String word = "madam";   // Hardcoded string

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop and compare
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }
}
