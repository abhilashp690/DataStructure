package Stack;

public class GetMinOperationConstantTime {

        Element top;
        /** initialize your data structure here. */
        public GetMinOperationConstantTime() {

        }

        public static void main(String[] args) {
            GetMinOperationConstantTime op = new GetMinOperationConstantTime();
            op.push(10);
            op.push(20);
            op.push(30);
            op.push(40);

            System.out.println(op.getMin());
        }

        public void push(int x) {

            if(top == null){
                Element newVal = new Element(x , x);
                top = newVal;
            }
            else {
                Element newVal = new Element(x , Math.min(x , top.min));
                newVal.next = top;
                top = newVal;
            }
        }


        public void pop() {
            if(top == null)
                return;

            Element next = top.next;
            top.next = null;
            top = next;

        }

        public int top() {
            if(top == null)
                return 0;
            return top.value;
        }

        public int getMin() {
            if(top == null)
                return 0;
            return top.min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    class Element {
        int value;
        int min;
        Element next;

        public Element(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }