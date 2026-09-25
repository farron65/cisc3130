public class ArrayStack {
    private int[] arr;
    private int top;

    public ArrayStack(int size) {
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int val) {
        if (this.top == arr.length-1) {
            throw new IllegalStateException("Stack is full, can't push " + val);
        }
        else {
            this.top++;
            this.arr[this.top] = val;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, can't pop anything");
        }
        else {
            int n = this.arr[this.top];
            this.top--;

            return n;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, can't peek anything");
        }
        else {
            return this.arr[this.top];
        }
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public int size() {
        return (this.top+1);
    }
}
