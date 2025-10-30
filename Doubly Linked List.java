
import java.io.*;

public class SinglyLinkedList {

    node head;
    
    static class node {
        int data;
        node next;
        
        node(int d) {
            data = d;
            next = null;
        }
    }

    public static SinglyLinkedList insert(SinglyLinkedList list, int data) {
        // Create a new node with given data
        node new_node = new node(data);
        new_node.next = null;
        
        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = new_node;
            new_node.next = null; // Redundant, already set above
        } 
        // Else traverse till the last node and insert the new_node there
        else {
            node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }
        // Return the list by head
        return list;
    }

    public static void printList(SinglyLinkedList list) {
        node curmode = list.head;
        System.out.println("\n linked list:");
        // Traverse through the Linked List
        while (curmode != null) {
            // Print the data at current node
            System.out.println(curmode.data + " ");
            // Go to next node
            curmode = curmode.next;
        }
        System.out.println("\n");
    }

    public static SinglyLinkedList deleteByKey(SinglyLinkedList list, int key) {
        node curmode = list.head;
        node prev = null;
        
        // CASE 1: Key is present at head
        if (curmode != null && curmode.data == key) {
            list.head = curmode.next; // Change head
            System.out.println(key + " found and deleted");
            return list;
        }
        
        // CASE 2: Key is somewhere after the head
        // Search for the key to be deleted, keep track of the previous node
        // as prev.next needs to be changed
        while (curmode != null && curmode.data != key) {
            prev = curmode;
            curmode = curmode.next;
        }
        
        // If key was present, it should be at curmode
        if (curmode != null) {
            prev.next = curmode.next; // Unlink the node from the Linked List
            System.out.println(key + " found and delete"); // Likely a typo: "deleted"
        }
        
        // CASE 3: Key is not present
        if (curmode == null) {
            System.out.println(key + " not found");
        }
        
        return list;
    }

    public static SinglyLinkedList deleteAtPosition(SinglyLinkedList list, int index) {
        node curmode = list.head;
        node prev = null;
        
        // CASE 1: The index is 0, i.e., head node
        if (index == 0 && curmode != null) {
            list.head = curmode.next; // Change head
            System.out.println(index + " position element deleted");
            return list;
        }
        
        // CASE 2: The index is greater than 0 but less than the size of the list
        int counter = 0;
        // Traverse to find the position
        while (curmode != null) {
            if (counter == index) {
                // If index is found, delete the current node
                prev.next = curmode.next;
                System.out.println(index + " position element deleted");
                break; // Exit the while loop after deletion
            } else {
                // If current position is not the index, move to next node
                prev = curmode;
                curmode = curmode.next;
                counter++;
            }
        }
        
        // CASE 3: The index is greater than or equal to the size of the list
        // If curmode becomes null, the index was not found
        if (curmode == null) {
            System.out.println(index + " position element not found");
        }
        
        return list;
    }

    public static void main(String args[]) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Inserts
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        printList(list); // Output: 1 2 3 4 5

        // Deletes by Key
        list = deleteByKey(list, 1);  // Delete head (1)
        printList(list); // Output: 2 3 4 5
        list = deleteByKey(list, 10); // Not found
        printList(list); // Output: 2 3 4 5
        list = deleteByKey(list, 4);  // Delete middle/end (4)
        printList(list); // Output: 2 3 5

        // Deletes at Position
        list = deleteAtPosition(list, 0);  // Delete head (2)
        printList(list); // Output: 3 5
        list = deleteAtPosition(list, 2);  // Position 2 (out of bounds for 3, 5 list with indices 0, 1) - **Potential Error in Code Logic/Test**
        printList(list); // Output: 3 5 (If it correctly handles not found)
        list = deleteAtPosition(list, 10); // Not found
        printList(list); // Output: 3 5
    }
}
