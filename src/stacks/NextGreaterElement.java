package stacks;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums = {30,38,30,36,35,40,28};
        int[] nextGreater = nextGreaterElement(nums);
        System.out.println(Arrays.toString(nextGreater)); // Output: [5, 25, 25, -1]

        int[] nextsmaller = nextSmallerElement(nums);
        //System.out.println(Arrays.toString(nextsmaller)); // Output: [5, 25, 25, -1]
    }

    private static int[] nextSmallerElement(int[] nums) {

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result,-1);

        for(int i=0 ; i< nums.length ; i++){

            while(!stack.isEmpty() && nums[i] < nums[stack.peek()])
            {
                result[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        return result;

    }



    private static int[] nextGreaterElement(int[] nums) {

        int [] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();

        // decreasing monotonic stack
        //{4, 5, 2, 25};
        for(int i=0 ; i< nums.length ; i++){

            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                //result[stack.peek()] = nums[i]; // result[0] = 5 .
                result[stack.peek()] = nums[i]; // result[0] = 5 .
                stack.pop(); // pop index - 0
            }

            stack.push(i); // we are pushing the index only and not the array value
            // 0


        }
        return result;


    }
}
