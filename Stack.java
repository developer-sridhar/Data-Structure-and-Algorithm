
import java.util.*;

class stack {
    
    // Maximum size of the stack
    static final int MAX = 1000; 
    
    // Index of the top element
    int top; 
    
    // Array to hold stack elements
    int a[] = new int[MAX]; 

    // Checks if the stack is empty
    boolean isEmpty() {
        return (top < 0);
    }

    // Constructor to initialize the stack
    stack() {
        top = -1;
    }

    // Pushes an element onto the stack
    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("stack overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    // Removes and returns the top element from the stack
    int pop() {
        if (top < 0) {
            System.out.println("stack underflow");
            return 0;
        } else {
            // Decrement top after accessing the element
            int x = a[top--]; 
            return x;
        }
    }

    // Returns the top element without removing it
    int peek() {
        if (top < 0) {
            System.out.println("stack underflow");
            return 0;
        } else {
            int x = a[top];
            return x;
        }
    }

    // Prints all elements currently in the stack (from top to bottom)
    void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println("" + a[i]);
        }
    }

    public static void main(String args[]) {
        // Create a new stack instance
        stack s = new stack();

        // Push elements
        s.push(10);
        s.push(20);
        s.push(30);

        // Pop operation
        System.out.println(s.pop() + " popped from stack");

        // Peek operation
        System.out.println("top element is: " + s.peek());

        // Print remaining elements
        System.out.println("element present in stack:");
        s.print();
    }
}
