class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
    }
}

public class PalindromicLinkedList {

    public static boolean isPalindrome(Node head) {
        /*
        // Ok Brute approach, store each element in a stack
        // Traverse the LL again and compare each item with the popped item from stack
        // If not equal, return false and done
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        
        temp = head;
        while(temp!=null){
            if(temp.data != st.peek()){
                return false;
            }
            st.pop();
            temp = temp.next;
        }
        return true;

        // T.C -> O(2*N) since we are traversing the linked list twice
        // S.C -> O(N) since we are using a Stack to store the data
        */
        
        // Base case: empty or single node
        if (head == null || head.next == null)
            return true;

        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; //  move two steps for fast
        }

        // Step 2: Reverse the second half
        Node secondHalfHead = reverseLL(slow);

        // Step 3: Compare both halves
        Node first = head;
        Node second = secondHalfHead;
        boolean palindrome = true;

        while (second != null) {
            if (first.data != second.data) {
                palindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore the list (optional)
        reverseLL(secondHalfHead);

        return palindrome;
    }

    // Reverse a linked list (iterative version)
    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
