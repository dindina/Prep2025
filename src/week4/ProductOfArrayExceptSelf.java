package week4;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static void printArray(int [] nums)
    {
        for(int i : nums)
        {
            System.out.print(i + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3,4};
        int[] res = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        printArray(res);

    }

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        int [] leftArray = new int[nums.length];
        int [] rightArray = new int[nums.length];
        int [] result = new int[nums.length];

        leftArray[0] = 1;
        for(int i = 1; i < len; i++)
        {
            leftArray[i] = leftArray[i-1] * nums[i-1];
        }
        printArray(leftArray);

        rightArray[len-1] = 1;
        for(int i = len-2; i >= 0; i--)
        {
            rightArray[i] = rightArray[i+1] * nums[i+1];
        }
        printArray(rightArray);

        for(int i=0 ; i<len;i++)
        {
            result[i] = leftArray[i] * rightArray[i];
        }
        return result;

    }
}
