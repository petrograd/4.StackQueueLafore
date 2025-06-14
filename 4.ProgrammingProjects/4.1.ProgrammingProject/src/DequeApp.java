class Deque {
    private final int maxSize;
    private long[] deqArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int size) {
        maxSize = size;
        deqArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insertLeft(long val) {

    }
    public void insertRight(long val) {

    }
    public long removeLeft() {
        return 0;
    }
    public long removeRight() {
        return 0;

    }
    public boolean isEmpty() {
        return nItems == 0;
    }
    public boolean isFull() {
        return nItems == maxSize;
    }

}
public class DequeApp {
}
