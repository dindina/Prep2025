package array;
import java.util.*;
public class Testing {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        int[] result = nextGreater(nums);
        System.out.println(Arrays.toString(result));

        int[] nums1 = new int[]{7,6,5,4};
        int[] result1 = nextSmaller(nums1);
        System.out.println(Arrays.toString(result1));

    }

    private static int[] nextSmaller(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[nums.length];
        Arrays.fill(res,-1);

        // 7, 5, 4 , 3 ,1
        for( int i=0 ; i < nums.length ; i++){

            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                res[stack.peek()] = nums[i];
                stack.pop();
            }

            stack.push(i); // only the index
        }
        return res;
    }


    private static int[] nextGreater(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length; i++) {

            while ( !stack.isEmpty() && nums[i] > nums[stack.peek()] ) {
                res[stack.peek()] = nums[i];
                stack.pop();
            }

            stack.push(i); // push the index
        }

        return res;

    }
}






