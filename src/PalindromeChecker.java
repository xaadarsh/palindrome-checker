public class PalindromeChecker {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "1.9";

    public static void main(String[] args) {

        showWelcomeMessage();

        // UC10 Feature
        checkIgnoringCaseAndSpaces();

        System.out.println("Application execution completed.");
    }

    private static void showWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("        " + APP_NAME);
        System.out.println("        Version: " + VERSION);
        System.out.println("======================================");
        System.out.println();
    }

    // 🔥 UC10 - Ignore Case and Spaces
    private static void checkIgnoringCaseAndSpaces() {

        String sentence = "Never Odd Or Even";

        // Normalize string
        String normalized = sentence
                .toLowerCase()
                .replaceAll("\\s+", "");   // remove spaces

        boolean isPalindrome = true;

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("\"" + sentence + "\" is a Palindrome (ignoring spaces & case).");
        } else {
            System.out.println("\"" + sentence + "\" is NOT a Palindrome.");
        }
    }
}
