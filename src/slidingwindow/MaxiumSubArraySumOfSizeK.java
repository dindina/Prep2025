package slidingwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxiumSubArraySumOfSizeK {

    public static void main(String[] args) {
        int [] nums = new int[] { 1, 5, 6, 8, 89, 9};
        int k = 4;

        System.out.println(new MaxiumSubArraySumOfSizeK().findMax(nums,k));
        System.out.println(new MaxiumSubArraySumOfSizeK().findMax1(nums,k));
    }

    public int  findMax1(int [] nums , int k)
    {
        int sum =0;
        int result = 0;
        int left = 0;


        for(int right=0 ; right< nums.length; right++)
        {
            int counter = 0;
            int index = right;
            while(index < nums.length && counter++ < k){
                sum+=nums[index++];
            }
            result = Math.max(result,sum);
            sum-=nums[left++];
        }

        return result;

    }

    public int  findMax(int [] nums , int k)
    {
        int sum =0;
        for(int i=0; i<k;i++)
            sum+=nums[i];

        int result = sum;
        Deque<Character> stack = new LinkedList<>();


        for(int i=k ; i< nums.length; i++)
        {
            sum += nums[i] - nums[i-k]; // add right and subtract left most of the window
            result=Math.max(sum,result);
        }

        return result;

    }


}
