package stacks;

import java.util.Deque;
import java.util.*;
import java.util.Stack;

public class MonotonicStack {

    public static void main(String[] args) {
        MonotonicStack stack1 = new MonotonicStack();
        /*stack1.push(100);
        stack1.push(101);
        stack1.push(102);

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());*/
        //int [] nums = new int[] {1,2,3,4,5,6,7};
        int [] nums = new int[] {1,2,-1,3 , 4,5,6};
        stack1.increasingMonotonicStack(nums);
        System.out.println("after");
        stack1.decreasingMonotonicStack(nums);


    }

    Deque<Integer> stack = new LinkedList<>();

    public  void push(int num){

        while(!stack.isEmpty() &&  stack.peek()> num)
        {
            stack.pop();
        }
        stack.push(num);
        System.out.println(stack);

    }

    public int pop(){
        return stack.pop();
    }

    public  void increasingMonotonicStack(int[] nums) {
        //Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() &&  stack.peek() > num ) {
                stack.pop();
            }
            stack.push(num);
            System.out.println(stack);
        }


    }

    public  void decreasingMonotonicStack(int[] nums) {
        //Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() &&  stack.peek() < num ) {
                stack.pop();
            }
            stack.push(num);
            System.out.println(stack);
        }


    }



}
