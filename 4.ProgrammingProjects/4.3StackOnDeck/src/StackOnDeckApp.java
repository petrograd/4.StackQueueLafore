class Deque {
    private int maxSize;
    protected long[] deqArray;
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
        if (isFull())
            throw new IllegalStateException("The Deck is full");
        if (rear == maxSize - 1) {
            rear = -1;
        }
        deqArray[++rear] = val;
        nItems++;
    }
    public long removeLeft() {
        return 0;
    }
    public long removeRight() {
        if (isEmpty())
            throw new IllegalStateException("The Deck is empty");
        long val = deqArray[rear--];
        if (rear == -1) {
            rear = maxSize-1;
        }
        nItems--;
        return val;
    }
    public boolean isEmpty() {
        return nItems == 0;
    }
    public boolean isFull() {
        return nItems == maxSize;
    }
    public void display() {
        int ind = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(deqArray[ind] + " ");
            ind++;
            if (ind == maxSize)
                ind = 0;
        }
        System.out.println();
    }
}
class Stack {
    private Deque theDeque;
    public Stack(int size) {
        theDeque = new Deque(size);
    }
    public void push(long val) {
        theDeque.insertRight(val);
    }
    public long pop() {
        return theDeque.removeRight();
    }
    public void display() {
        System.out.println("Print Stack from bottom to top");
        theDeque.display();
    }


}

public class StackOnDeckApp {
    public static void main(String[] args) {
        int stackSize = 10;
        Stack theStack = new Stack(stackSize);
        for (int i = 0; i < stackSize; i++) {
            theStack.push(i * 10);
        }
        theStack.display();
        System.out.println(theStack.pop());
        theStack.display();
    }
}
