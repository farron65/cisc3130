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

/*
Part 2 - ADT Questions

Q1: What does ADT stand for?
        Abstract Data Type

Q2: In your own words, what is an Abstract Data Type? 
        An Abstract Data Type is a description of what operations a data
        structure supports and how it should behave, without specifying
        how those operations are actually implemented

Q3: What is the difference between an ADT and its implementation? (Use
    the idea of WHAT vs. HOW in your explanation)
        ADT defines WHAT a structure does, its' operations and rules 
        e.g a Stack has to support push, pop and peek. It's implementation
        defines HOW those operations are done in code, 
        e.g using an array with a top index versus a linked list.

Q4: Can two programmers create different implementations of the same
    ADT? Explain your answer.
        Yes, ADT only specifies behavior not how the internals work.
        I used a regular array for a Stack, though I could have also
        used an ArrayList, as long as both correctly support push, pop, peek
        both are valid implementations. 

Q5: If one programmer creates a Stack using an array and another creates
    a Stack using a linked list, are both still Stacks? Explain why.
        Yes, ADT only specifies behavior not how the internals work.
        A stack is defined by its behavior, LIFO, push, peek and pop, not
        by what was used to make the Stack.
*/


/*
Part 8 - Stack Questions

Q6: What does LIFO mean?
        Last in First out

Q7: Why did 55 get removed before 15?
        Because a Stack follows LIFO - Last In, First Out
        meaning the most recently pushed item is always the first one popped.
        55 was pushed last, so it's removed first

Q8: If the Stack contains:

    A

    B

    C

    D

    and D was added last, which item should pop() remove first?
        D, because it was last element added


Q9: Give one real-world or software example where a Stack could be useful.

    Examples discussed in class may include:

    ●	Browser Back history
    ●	Undo operations
    ●	Function calls

    Explain your example.
        Undo functionality in a text editor is an example of a Stack.
        Each action, like typing a word or deleting a word gets pushed 
        onto a Stack as it happens. When you press Ctrl+Z, the last 
        action performed gets undone first, hence LIFO
*/


/*
Part 14 - Queue Questions:

Q10: What does FIFO mean?
        First In First out.

Q11: Why was 15 removed before 55?
        Because a Queue follows FIFO - First In, First Out
        meaning the item added earliest is always removed first.
        15 was enqueued before 55, so it comes out first

Q12: If customers enter a line in this order:
    Alex

    Maria

    John

    Sarah

    who should leave the Queue first?
        Alex, he was the first, he leaves first.

Q13: Give one real-world or software example where a Queue could be useful.
    Possible examples:

    ●	Printer jobs
    ●	Customer-service requests
    ●	Tasks waiting to be processed
    ●	People waiting in line

    Explain your answer.
        Printer jobs are an example of a queue. If two or more 
        people clicked 'print' button, the person who clicked it
        first, will get their paper printed first, hence FIFO
*/

/*
Part 15 - Stack vs Queue

Scenario 1 (Undo):
    A text editor remembers your recent actions.

    If you type:

    A

    B

    C

    the most recent action should be undone first.

    Stack or Queue?

    Explain.
        Stack, because of LIFO, the most recently typed action
        is the first one undone, just like the last item pushed
        onto a Stack is the first one popped.


Scenario 2 (Printer):
    Three students send documents to a printer.

    The first document submitted should normally print first.

    Stack or Queue?

    Explain.
        Queue because of FIFO, the first document submitted is
        the first one printed, since new jobs join the back of
        the line and only leave from the front.


Scenario 3 (Browser Back Button):
    You visit:

    Google

    YouTube

    GitHub

    Amazon

    You click the Back button.

    Which page should appear first?
        Github

    What ADT does this resemble?
        Stack
        each page you visit gets "pushed" onto your browsing history,
        and clicking Back "pops" the most recently visited page (GitHub).


Scenario 4 (Customer Service):
    Customers are waiting to talk to an employee.

    The person who arrived first should normally be helped first.

    Stack or Queue?
        Queue because the customer who arrived first is helped first,
        matching FIFO order.


Scenario 5 (Plates):
    You place five plates on top of one another.

    Which ADT does this represent?

    Explain.
        Stack, plates are LIFO. You can only add or remove from
        the top, so the last plate placed on the stack is the
        first one removed.
*/

/*
Part 16 - Predict the output

Stack: push(7), push(12), push(18), pop(), push(22), peek()

    Q14: what does pop() return?
            18

    Q15: What does the final peek() return?
            22


Queue: enqueue(7), enqueue(12), enqueue(18), dequeue(), enqueue(22), peek()

    Q16: What does dequeue() return?
            7

    Q17: What does the final peek() return?
            12
*/


/*
Part 17 - Compare the ADTs

    Feature            | Stack               | Queue
    Rule               | LIFO                | FIFO
    Add operation      | push()              | enqueue()
    Remove operation   | pop()               | dequeue()
    View next item     | peek()              | peek()
    First item removed | Most recently added | Earliest added
*/

/*
Part 18 - Connect the ADT to the Implementation

Q18: If you implement a Stack using an array, which part is the ADT?
        The behavior is the ADT, it supports push, pop, peek, and isEmpty,
        which follow LIFO order.

Q19: Which part is the implementation?
        The array and index logic, and how those operations are 
        carried out in code.

Q20: If you replace the array with a linked list but
    keep the same Stack operations, did the ADT change?
        No, the ADT didn't change. As long as 
        push, pop, peek still behave the same way,
        the Stack ADT itself is unchanged.
*/