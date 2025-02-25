package array;

import common.Utils;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int []{1,2,3,4};

        int [] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        Utils.printArray(result);
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] left = new int[len];
        int[] right = new int[len];

        left[0]=1;
        for(int i=1; i < len; i++)
        {
            left[i] = left[i-1]*nums[i-1];
        }

        right[len-1]=1;
        for(int i=len-2; i >= 0; i--)
        {

            right[i] = right[i+1]*nums[i+1];
        }

        Utils.printArray(right);

        int[] result = new int[len];
        for(int i=0 ; i<len;i++){
            result[i] = left[i]*right[i];
        }
        return result;
    }

}
