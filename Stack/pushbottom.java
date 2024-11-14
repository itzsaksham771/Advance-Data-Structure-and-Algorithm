import java.util.Stack;

public class pushbottom {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void reverseStack(Stack<Integer> s ) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void sortStack(Stack<Integer> s, int x) {
        if(s.isEmpty() || x>s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortStack(s, x);
        s.push(temp);
    }
    public static void sortingOfStack(Stack<Integer> s) {
        if(!s.isEmpty()) {
            int x =s.pop();
        
        sortingOfStack(s);
        sortStack(s, x);
        } 
    }
    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // pushAtBottom(s, 4);
        reverseStack(s);   // 3 2 1 
        printStack(s);  // 1 2 3

    }
}
