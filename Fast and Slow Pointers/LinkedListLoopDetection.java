// Node class represents a
// node in a linked list

class Node {
     // Data stored in the node
    int data;  
    // Pointer to the next node in the list
    Node next;   
    
    // Constructor with both data and
    // next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a
    // parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class LinkedListLoopDetection {
    // Function to detect a loop in a linked list
    // and return the starting node of the loop
    public static Node detectLoop(Node head) {
        /*
        
        // Brute Approach
        // Use temp to traverse the linked list
        Node temp = head;
        
        // HashMap to store all visited nodes
        HashMap<Node, Integer> nodeMap = new HashMap<>();
        
        // Traverse the list using temp
        while (temp != null) {
            // Check if temp has been encountered again
            if (nodeMap.containsKey(temp)) {
                // A loop is detected, hence return temp
                return temp;
            }
            
            // Store temp as visited
            nodeMap.put(temp, 1);
            
            // Iterate through the list
            temp = temp.next;
        }
        
        // If no loop is detected, return null
        return null;
        */

        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create a sample linked list with a loop
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;

        // Make a loop from node5 to node2
        node5.next = node2;

        // Set the head of the linked list
        Node head = node1;

        // Detect the loop in the linked list
        Node loopStartNode = detectLoop(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
