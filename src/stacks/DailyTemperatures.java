package stacks;

import com.sun.source.tree.BreakTree;
import common.Utils;

import java.util.*;
import java.util.LinkedList;

/*
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.

Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.

Example 1:

Input: temperatures = [30,38,30,36,35,40,28]

Output: [1,4,1,2,1,0,0]
Example 2:

Input: temperatures = [22,21,20]

Output: [0,0,0]
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] nums = new int[] { 30,38,30,36,35,40,28};
        int [] result =  dailyTemperatures(nums);
        Utils.printArray(result);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int [] result = new int[temperatures.length];
        for(int i=0 ; i < temperatures.length; i++)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                System.out.println("popping index " + stack.peek());
                result[stack.peek()] = i - stack.pop();
            }
            System.out.println("pushing index " + i);
            stack.push(i);
        }
        return result;
    }
}
