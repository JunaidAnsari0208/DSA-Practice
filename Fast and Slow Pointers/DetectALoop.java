class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
    }
}

public class DetectALoop {
    public static boolean detectLoop(Node head){
        // // Brute Approach, traverse each 
        // HashMap<Node, Integer> mpp = new HashMap<>();
        // Node temp = head;
        // while(temp!=null){
        //     if(mpp.containsKey(temp))
        //         return true;
        //     mpp.put(temp, 1);
        //     temp = temp.next;
        // }
        // return false;

        // Optimal Approach, The Tortoise Hare Method
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    public static void main(String[] args) {
        // Create a sample linked list
        // with a loop for testing
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        boolean check = detectLoop(head);

        // Check if there is a loop 
        // in the linked list
        if (check) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
