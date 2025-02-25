package slidingwindow;

/*
Given an array of positive integers nums and a positive integer target, return the maximum length of a
subarray
 whose sum is equal to target. If there is no such subarray, return 0 instead.
 */
public class MaximumSizeSubArraySum {

    public static void main(String[] args) {
        int [] nums = new int[] {2,3,1,1,4,3,1,1,1,1,1,1,1};
        int target =7;
        // ans 4 ;
        System.out.println(new MaximumSizeSubArraySum().maxSubArrayLen(target,nums));
    }

        private int maxSubArrayLen(int target, int[] nums) {
            int left = 0;
            int  maxLen = Integer.MIN_VALUE;
            int sum =0;
            for(int right =0 ; right < nums.length; right++){
                sum+=nums[right];
                System.out.println("sum " + sum);
                while(sum > target)
                {
                    sum-=nums[left++];

                }
                if (sum == target) {
                    maxLen= Math.max(maxLen,right-left+1);
                }
            }
            return maxLen;
        }
}
