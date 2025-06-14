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
        if (isFull()) throw new IllegalStateException("Deque is full");
        if (front == 0)
            front = maxSize;
        deqArray[--front] = val;
        nItems++;
    }
    //add to back
    public void insertRight(long val) {
        if (isFull()) throw new IllegalStateException("Deque is full");
        if (rear == maxSize - 1)
            rear = -1;
        deqArray[++rear] = val;
        nItems++;
    }

    //remove from front
    public long removeLeft() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        long val = deqArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return val;
    }
    //remove from back
    public long removeRight() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        long val = deqArray[rear--];
        if (rear == -1)
            rear = maxSize-1;
        nItems--;
        return val;

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
    public void display() {
        int cur = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(deqArray[cur] + " ");
            cur++;
            if (cur == maxSize)
                cur = 0;
        }
        System.out.println();
    }

}
public class DequeApp {
    static final int DEQUE_SIZE = 10;

    public static void main(String[] args) {
            Deque theDeque = new Deque(DEQUE_SIZE);
        for (int i = 0; i < DEQUE_SIZE; i++) {
            theDeque.insertRight(i * 10);
        }
        theDeque.display();


        //check overflow
        try {
            theDeque.insertRight(100);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        try {
            theDeque.insertLeft(-100);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        theDeque.removeLeft();
        theDeque.removeRight();
        theDeque.display();

        int curSize = theDeque.size();
        for (int i = 0; i < curSize; i++) {
            theDeque.removeLeft();
        }
        System.out.println("the Deque size : " + theDeque.size());
        theDeque.display();

        try {
            theDeque.removeLeft();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        theDeque.insertRight(10);
        theDeque.display();
        System.out.println(" Deleting : " + theDeque.removeLeft());
        theDeque.display();


    }
}
