
public class ArrayQueue {
    private int[] arr;
    private int back;

    public ArrayQueue(int size) {
        this.arr = new int[size];
        this.back = 0;
    }

    public void enqueue(int val) {

        if (this.back == arr.length) {
            throw new IllegalStateException("Can't add anything, queue is filled");
        }

        this.arr[this.back] = val;
        this.back++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove anything, queue is empty");
        }

        int n = this.arr[0];

        for (int i = 0; i < this.back-1; i++) {
            this.arr[i] = this.arr[i+1];
        }

        this.back--;
        return n;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, can't peek anything");
        }
        else {
            return this.arr[0];
        }
    }

    public boolean isEmpty() {
        return (this.back == 0);
    }

    public int size() {
        return this.back;
    }
}
