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
      //  System.out.println("insert " + val + " at pos: " + rear);
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
        int ind =  front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[ind] + " ");
            ind++;
            if (ind == maxSize)
                ind = 0;

        }
        System.out.println();
    }
}

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(10);
        for (int i = 0; i < 10; i++) {
            long val = (long)(i * 10);
            theQueue.insert(val);
           // System.out.print(val + " ");
        }

        theQueue.display();

        System.out.println("remove " + theQueue.remove());
        System.out.println("remove " + theQueue.remove());

        System.out.println("вставим еще 2 значения в очередь 10 и 20");
        theQueue.insert(10);
        theQueue.insert(20);


        theQueue.display();
    }
}
