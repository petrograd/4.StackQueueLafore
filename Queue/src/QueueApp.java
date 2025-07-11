import java.util.Random;

class Queue {
    private final int maxSize;
    private final long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        this.maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if (isFull()) {
            throw new IllegalStateException("The Queue is full");
        }
        if (rear == maxSize - 1) rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    public long remove() {
        if (isEmpty()) {
            throw new IllegalStateException("The Queue is empty");
        }
        long temp = queArray[front++];
        if (front == maxSize) front = 0;
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {  // true if queue is empty
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }
}

public class QueueApp {
    public static void main(String[] args) {

        Random random = new Random();

        Queue theQueue = new Queue(5);
        for (int i = 0; i < 5; i++) {

            theQueue.insert(random.nextInt(11) * 10);
        }

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        for (int i = 0; i < 5; i++) {
            try {
                theQueue.insert((int) (Math.random() * 11) * 10);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("size " + theQueue.size());
        while (!theQueue.isEmpty()) {
            long n = theQueue.remove();
            System.out.print(n + " ");
        }
    }
}
