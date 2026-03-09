public class PalindromeChecker {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "1.7";

    // Node class for Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        showWelcomeMessage();

        // UC8 Feature
        checkUsingLinkedList();

        System.out.println("Application execution completed.");
    }

    private static void showWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("        " + APP_NAME);
        System.out.println("        Version: " + VERSION);
        System.out.println("======================================");
        System.out.println();
    }

    // 🔥 UC8 - Linked List Based Palindrome Check
    private static void checkUsingLinkedList() {

        String word = "madam";   // Hardcoded string

        // Convert string to linked list
        Node head = null;
        Node tail = null;

        for (char c : word.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        boolean isPalindrome = isPalindrome(head);

        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }

    // Function to check palindrome using linked list
    private static boolean isPalindrome(Node head) {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        // Find middle using fast & slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Reverse Linked List
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
