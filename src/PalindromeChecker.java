public class PalindromeChecker {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "2.0";

    public static void main(String[] args) {

        showWelcomeMessage();

        String word = "madam";

        // Create object of service class
        PalindromeService service = new PalindromeService();

        boolean result = service.checkPalindrome(word);

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

// 🔥 Service class that handles palindrome logic
class PalindromeService {

    // Public method exposed to the application
    public boolean checkPalindrome(String word) {

        char[] chars = word.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {

            if (chars[start] != chars[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
