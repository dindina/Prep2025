package stacks;

import java.util.*;

public class StackUsingQueue {

    public static void main(String[] args) {

        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);

    }
    Queue<Integer> que;
    StackUsingQueue() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.offer(x);
        for (int i = 0; i < que.size() - 1; i++) {
            que.offer(que.poll());
        }

    }

    public int pop() {
        return que.poll();
    }

    public int top() {
        return que.peek();
    }

    public boolean empty() {
        return que.isEmpty();
    }
}
