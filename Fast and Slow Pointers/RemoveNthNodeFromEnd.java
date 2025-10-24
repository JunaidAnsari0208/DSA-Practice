import java.util.Arrays;
import java.util.List;

class Node {
    int data;
    Node next;

    // Constructor for Node with data and next node
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor for Node with only data (next = null)
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class RemoveNthNodeFromEnd {
    

    // Function to print the linked list
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    public static Node deleteNthNodeFromEnd(Node head, int N){
        /*
        
        // Brute approach is basically if u want to delete Nth node from back
        // Delete L - N + 1 Node from front
        // So first find length then delete that node
        // If List is empty return null
        if(head == null)
        return null;
        
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        
        // If Length is equal to N that means its asking to delete head 
        // So return head.next
        if(cnt == N)
        return head.next;
        
        int res = cnt - N - 1;
        temp = head;
        
        // Traverse till before the node to be deleted
        while(res!=0){
            temp = temp.next;
            res--;
        }
        
        // Delete the node
        temp.next = temp.next.next;
        
        return head;
        
        */
        /*
         * Time Complexity: O(L)+O(L-N), We are calculating the length of the linked 
         * list and then iterating up to the (L-N)th node of the linked list, 
         * where L is the total length of the list.
         * 
         * Space Complexity: O(1), constant additional space is used. 
         */

        // Optimal Approach, basically the fast pointer will be exactly N nodes 
        // ahead of slow
        // After which, both of them will move one step at a time. 
        // When the fast pointer reaches the last node,the slow is 
        // guaranteed to be at the (L-N)-th node

        // Create a dummy node before head to handle edge cases
        Node dummy = new Node(0, head);

        // Initialize slow and fast pointers at dummy
        Node slow = dummy;
        Node fast = dummy;

        // Move fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return dummy.next;

        /*
         * Time Complexity: O(N), since the fast pointer will traverse the entire 
         * linked list, where N is the length of the linked list.
         * Space Complexity: O(1), constant additional space is used to check 
         * unique elements. 
         */
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        // Create linked list manually
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));


        // Delete the Nth node from the end
        head = deleteNthNodeFromEnd(head, N);

        // Print the modified linked list
        printLL(head);
    }
}
