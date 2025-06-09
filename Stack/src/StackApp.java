class StackOverflowException extends RuntimeException {
    public StackOverflowException(String message) {
        super(message);
    }
}
class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String message) {
        super(message);
    }
}
class StackX {
    private int maxSize;
    private long[] stackArray;
    private int top;    //top of stack

    public StackX(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    public void push(long j) {
        if (isFull()) {
            throw new StackOverflowException("Стек переполнен");
        }
        top++;
        stackArray[top] = j;
    }
    public long pop() {
        if (isEmpty()) {
            throw new StackUnderflowException("Стек пуст");
        }
        return stackArray[top--];
    }
    public long peek() {
        if (isEmpty()) {
            throw new StackUnderflowException("Стек пуст");
        }
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == (maxSize-1));
    }
}

public class StackApp {
    public static void main(String[] args) {
        final int SIZE = 3;
        StackX theStack = new StackX(SIZE);  //make new stack
        try {
            theStack.push(20);
            theStack.push(40);
            theStack.push(60);
            theStack.push(80);  //invoke exception
        } catch (StackOverflowException e) {
            System.out.println(e.getMessage());
        }

        while (!theStack.isEmpty()) {
            long v = theStack.pop();
            System.out.print(v + "  ");

        }
        System.out.println();

        try {
            System.out.println(theStack.pop());
            System.out.println(theStack.pop());
            System.out.println(theStack.pop());
            System.out.println(theStack.pop());
            System.out.println(theStack.pop());
        } catch (StackUnderflowException e) {
            System.out.println(e.getMessage());
        }



    }
}
