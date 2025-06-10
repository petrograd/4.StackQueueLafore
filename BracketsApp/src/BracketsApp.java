import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char ch) {
        stackArray[++top] = ch;
    }
    public char pop() {
        return stackArray[top--];
    }
    public char peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
}

class BracketChecker {
    private String input;
    public BracketChecker(String s) {
        input = s;
    }
    public void check() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            switch(ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = theStack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')) {
                            System.out.println("Error : " + ch + " at " + i);
                        }
                    } else { // prematurely empty
                        System.out.println("Error : " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }

        }
        if (!theStack.isEmpty())
            System.out.println("Error: missing right delimiter");
    }
}

public class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true){
            System.out.println("Enter string containing delimiters: ");
            input = getString();
            if (input.isEmpty())
                break;
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
