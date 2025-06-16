/*
4.4 The priority queue features fast removal of the high-priority
item but slow insertion of new items. Write a program with a revised
PriorityQ class that has fast O(1) insertion time but slower removal of the highpriority
item.
 */
class QueUnderflowException extends RuntimeException {
    public QueUnderflowException(String message) {
        super(message);
    }
}
class PriorityQ {
    private final int maxSize;
    private final long[] queArray;
    private int nItems;

    public PriorityQ(int size) {
        maxSize = size;
        queArray = new long[maxSize];
        nItems = 0;
    }
    public void insertWithPriority(long val) {
        if (isFull()) throw new IllegalStateException("The Queue is full");
        int curInd = nItems-1;
        while (curInd >= 0 && (queArray[curInd] < val)) {
            queArray[curInd+1] = queArray[curInd];
            curInd--;
        }
        queArray[++curInd] = val;
        nItems++;
    }
    public void insert(long val) {
        if (isFull()) throw new IllegalStateException("The Queue is full");
        queArray[nItems++] = val;
    }
    public long remove() {
        if (isEmpty()) throw new QueUnderflowException("The Queue is empty");
        return queArray[--nItems];
    }
    public long removeWithPriority() {
        if (isEmpty()) throw new QueUnderflowException("The Queue is empty");
        int minInd = 0;
        for (int i = 1; i < nItems; i++) {
            if (queArray[minInd] > queArray[i])
                minInd = i;
        }
        long val = queArray[minInd];
        while (minInd < nItems-1) {
            queArray[minInd] = queArray[minInd+1];
            minInd++;
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
        System.out.println("Priority Queue from bottom to top: ");
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
    }
}
public class PriorityQueAPP {
    public static void main(String[] args) {
        int queSize = 10;
        PriorityQ theQue = new PriorityQ(queSize);
        int i = 0;
        for (i = 0; i < queSize; i++) {
            theQue.insert(i*10);
        }
        theQue.display();

        for (int j = 0; j < queSize - 5; j++) {
            long val = theQue.removeWithPriority();
            System.out.println("removing min priority " + val);
            theQue.display();
        }
        System.out.println("removing the rest");
        while (!theQue.isEmpty()){
            System.out.println("removing: " + theQue.removeWithPriority());
        }
        theQue.display();


    }
}
