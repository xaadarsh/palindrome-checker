public class PalindromeChecker {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "1.8";

    public static void main(String[] args) {

        showWelcomeMessage();

        // UC9 Feature
        checkUsingRecursion();

        System.out.println("Application execution completed.");
    }

    private static void showWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("        " + APP_NAME);
        System.out.println("        Version: " + VERSION);
        System.out.println("======================================");
        System.out.println();
    }

    // 🔥 UC9 - Recursive Palindrome Check
    private static void checkUsingRecursion() {

        String word = "madam";   // Hardcoded string

        boolean isPalindrome = isPalindromeRecursive(word, 0, word.length() - 1);

        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }

    // Recursive function
    private static boolean isPalindromeRecursive(String word, int start, int end) {

        // Base condition
        if (start >= end)
            return true;

        // Compare characters
        if (word.charAt(start) != word.charAt(end))
            return false;

        // Recursive call
        return isPalindromeRecursive(word, start + 1, end - 1);
    }
}
