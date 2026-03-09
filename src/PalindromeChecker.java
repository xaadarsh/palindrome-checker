import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeChecker {

    public static void main(String[] args) {

        String word = "madam";

        System.out.println("Palindrome Performance Comparison");
        System.out.println("----------------------------------");

        runStackAlgorithm(word);
        runDequeAlgorithm(word);
        runRecursiveAlgorithm(word);
    }

    // Stack Approach
    private static void runStackAlgorithm(String word) {

        long startTime = System.nanoTime();

        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;

        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Stack Algorithm Result: " + isPalindrome);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        System.out.println();
    }

    // Deque Approach
    private static void runDequeAlgorithm(String word) {

        long startTime = System.nanoTime();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Deque Algorithm Result: " + isPalindrome);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        System.out.println();
    }

    // Recursive Approach
    private static void runRecursiveAlgorithm(String word) {

        long startTime = System.nanoTime();

        boolean result = isPalindromeRecursive(word, 0, word.length() - 1);

        long endTime = System.nanoTime();

        System.out.println("Recursive Algorithm Result: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        System.out.println();
    }

    private static boolean isPalindromeRecursive(String word, int start, int end) {

        if (start >= end)
            return true;

        if (word.charAt(start) != word.charAt(end))
            return false;

        return isPalindromeRecursive(word, start + 1, end - 1);
    }
}
