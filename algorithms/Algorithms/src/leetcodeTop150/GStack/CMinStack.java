package leetcodeTop150.GStack;
/*
Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]

Constraints:
-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class CMinStack {
    CMinStack next;
    Integer val;

    public CMinStack() {

    }

    public static void main(String[] args) {
        CMinStack test = new CMinStack();
        test.push(2147483646); test.push(2147483646); test.push(2147483647);
//        System.out.println(test.top()); //2147483647
        test.pop(); System.out.println(test.getMin()); //2147483646
        test.pop(); System.out.println(test.getMin()); //2147483646
        test.pop();
        test.push(2147483647); System.out.println(test.top()); //2147483647
        System.out.println(test.getMin()); //2147483647
        test.push(-2147483648); System.out.println(test.top()); //-2147483648
        System.out.println(test.getMin()); // -2147483648
        test.pop(); System.out.println(test.getMin()); //2147483647
    }
    public void push(int val) {
        if (this.val!=null){
            CMinStack newS = new CMinStack();
            newS.push(this.val);
            if (next == null){
                next = newS;
            } else {
                newS.next = next;
                next = newS;
            }
        }
        this.val=val;
    }

    public void pop() {
        if (val!=null){
            if (next!=null){
                val = next.val;
                if (next.next!=null){
                    CMinStack nextNext = next.next;
                    next = nextNext;
                } else{ next = null;}
            } else{val=null;}
        }
    }

    public int top() {
        if (val!=null){
        return val;}
        else return 0;
    }

    public int getMin() {
        if (val!=null) {
            int min = val;
            CMinStack nextS = next;
            while(nextS!=null){
                min = Math.min(min,nextS.val);
                nextS = nextS.next;
            }
            return min;
        }
        return 0;
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
