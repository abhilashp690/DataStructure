package Queue;

import java.util.Stack;

public class QueueImplementationUsingStack {

    static Stack<Integer> s1;
    static Stack<Integer> s2;

    public static void main(String[] args) {
        System.out.println("Queue Implementation using stack...");

        s1 = new Stack<>();
        s2 = new Stack<>();

        add(10);
        add(20);
        add(30);
        add(40);
        add(50);

        int x = peek();
        System.out.println("Peek Element = " + x);

        x = poll();
        System.out.println("Polled Element = " + x);

    }

    public static void add(int x){
        if(s1.isEmpty())
            s2.push(x);
        else
            s1.push(x);
    }

    public static int poll() {
        if(s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            int x =  s1.pop();
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return x;
        }
        else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int x = s2.pop();
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return x;
        }
    }

    public static int peek() {
        if(s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            int x =  s1.peek();
            while (!s1.isEmpty())
                s2.push(s1.pop());
            return x;
        }
        else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int x =  s2.peek();
            while (!s2.isEmpty())
                s1.push(s2.pop());
            return x;
        }
    }

    public static boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
