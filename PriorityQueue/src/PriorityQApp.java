class QueueOverflowException extends RuntimeException {
    public QueueOverflowException(String message) {
        super(message);
    }
}
class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException(String message) {
        super(message);
    }
}
class PriorityQ {
    //array in sorted order, from max at 0 to min at size-1
    private final int maxSize;
    private final long[] queArray;
    private int nItems;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    public void insert(long v) {
        if (isFull()) throw new QueueOverflowException("the Queue is overflow with the value " + v);
        int j = nItems - 1;
        while( j>=0 && queArray[j] < v) {
            queArray[j+1] = queArray[j];
            j--;
        }
        queArray[j+1] = v;
        nItems++;
    }
    public long remove() {
        if (isEmpty()) throw new QueueUnderflowException("the Queue is empty");
        return queArray[--nItems];
    }
    public long peekMin() {
        return queArray[nItems-1];
    }
    public boolean isEmpty() {
        return (nItems == 0);
    }
    public boolean isFull() {
        return (nItems == maxSize);
    }
}
public class PriorityQApp {
    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(5);
        try {
            thePQ.insert(30);
            thePQ.insert(50);
            thePQ.insert(10);
            thePQ.insert(40);
            thePQ.insert(20);
            thePQ.insert(100); // check exception
        }catch (QueueOverflowException e) {
            System.out.println(e.getMessage());
        }
        while (!thePQ.isEmpty()) {
            System.out.println(thePQ.remove() + " ");
        }
        System.out.println();

    }
}
