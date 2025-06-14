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
    //add to front
    public void insertLeft(long val) {

    }
    //add to back
    public void insertRight(long val) {

    }
    //remove from front
    public long removeLeft() {
        return 0;
    }
    //remove from back
    public long removeRight() {
        return 0;

    }
    public boolean isEmpty() {
        return nItems == 0;
    }
    public boolean isFull() {
        return nItems == maxSize;
    }
    public int size() {
        return nItems;
    }

}
public class DequeApp {
}
