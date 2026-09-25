// Name: Bezhan Sangov
// Programming Language: Java
// IDE: VS Code

public class Main {
    public static void main(String[] args) {
        // --------------------
        // Stack
        // --------------------
        System.out.println("\nSTACK DEMONSTRATION");

        ArrayStack stack = new ArrayStack(10);

        System.out.println("Adding: 15 25 35 45 55");
        stack.push(15);
        stack.push(25);
        stack.push(35);
        stack.push(45);
        stack.push(55);

        System.out.println("Top item: " + stack.peek());

        System.out.println("Removing: " + stack.pop());
        System.out.println("Removing: " + stack.pop());

        System.out.println("New top: " + stack.peek());
        System.out.println("Is Stack empty? " + stack.isEmpty());

        // --------------------
        // Queue
        // --------------------
        System.out.println("\nQUEUE DEMONSTRATION");

        ArrayQueue queue = new ArrayQueue(10);

        System.out.println("Adding: 15 25 35 45 55");
        queue.enqueue(15);
        queue.enqueue(25);
        queue.enqueue(35);
        queue.enqueue(45);
        queue.enqueue(55);

        System.out.println("Front item: " + queue.peek());

        System.out.println("Removing: " + queue.dequeue());
        System.out.println("Removing: " + queue.dequeue());

        System.out.println("New front: " + queue.peek());
        System.out.println("Is Queue empty? " + queue.isEmpty());
    }
}
