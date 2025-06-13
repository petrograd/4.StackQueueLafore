class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        maxSize = size;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insert(long val) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = val;
        System.out.println("insert " + val + " at pos: " + rear);
        nItems++;
    }
    public long remove() {
        long rval = queArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return rval;
    }
    public long peekFront() {
        return queArray[front];
    }
    public boolean isEmpty() {
        return nItems == 0;
    }
    public boolean isFull() {
        return nItems == maxSize;
    }
    public void display() {
        int ind =  rear;
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[ind] + " ");
            ind--;
            if (ind == -1)
                ind = maxSize-1;

        }
        System.out.println();
    }
}

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(10);
        for (int i = 0; i < 10; i++) {
            long val = (long)(Math.random()* 11) * 10;
            theQueue.insert(val);
           // System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("front: " + theQueue.peekFront() );
        theQueue.display();

        System.out.println("remove " + theQueue.remove());
        System.out.println("remove " + theQueue.remove());


        theQueue.insert(10);

        theQueue.display();
    }
}
