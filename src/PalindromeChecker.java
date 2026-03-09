public class PalindromeChecker {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "1.3";

    public static void main(String[] args) {

        showWelcomeMessage();

        // New Feature: char[] + Two Pointer Approach
        checkUsingCharArray();

        System.out.println("Application execution completed.");
    }

    private static void showWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("        " + APP_NAME);
        System.out.println("        Version: " + VERSION);
        System.out.println("======================================");
        System.out.println();
    }

    // 🔥 Feature: Convert String → char[] and check
    private static void checkUsingCharArray() {

        String word = "madam";   // Hardcoded string

        char[] characters = word.toCharArray();   // Convert to char[]

        int left = 0;
        int right = characters.length - 1;

        boolean isPalindrome = true;

        while (left < right) {
            if (characters[left] != characters[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }
}
