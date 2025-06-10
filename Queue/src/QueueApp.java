class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        this.maxSize = s;
        queArray = new long[maxSize];
        front  =  0;
        rear   = -1;
        nItems =  0;
    }
    public void insert(long j) {
        if (rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }
    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }
    public long peekFront() {
        return queArray[front];
    }

}

public class QueueApp {

}
