package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    static Queue<Integer> queue1;
    static Queue<Integer> queue2;

    public static void main(String[] args) {
        System.out.println("Implement stack using queue .....");

        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

        push(10);
        push(20);
        push(30);
        push(40);

        int x = pop();
        System.out.println("Popped Element = " + x);
        x = pop();
        System.out.println("Popped Element = " + x);
        x = pop();
        System.out.println("Popped Element = " + x);
        push(50);
        push(60);
        x = pop();
        System.out.println("Popped Element = " + x);

        System.out.println("To Implement Stack using Queue ,  we either need to make push operation heavy or pop operation heavy.");

        x = getTop();
        System.out.println("Topped Element = " + x);

        x = pop();
        System.out.println("Popped Element = " + x);

        x = getTop();
        System.out.println("Topped Element = " + x);

        push(405);

    }

    public static void push(int x){
        if(queue2.isEmpty())
            queue1.add(x);
        else
            queue2.add(x);
    }

    public static int pop() {
        if(queue2.isEmpty()){
            while (queue1.size() != 1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }

        else {
            while (queue2.size() != 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public static int getTop() {
        if(!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                while (queue2.size() != 1){
                    queue1.add(queue2.poll());
                }
                int x = queue2.peek();
                queue1.add(queue2.poll());
                return x;
            }
            else {
                while (queue1.size() != 1){
                    queue2.add(queue1.poll());
                }
                int x = queue1.peek();
                queue2.add(queue1.poll());
                return x;
            }
        }
        return 0;
    }

    public static boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}



