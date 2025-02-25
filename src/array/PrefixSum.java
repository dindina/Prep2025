package array;

import common.Utils;

public class PrefixSum {
    public static void main(String[] args) {
        int [] nums = new int[] { -2, 0, 3, -5, 2, -1};
        int [] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1 ; i < nums.length ; i++){
            //prefix[i] += prefix[i-1]+nums[i];
            prefix[i] = prefix[i-1]+nums[i];
        }
        Utils.printArray(prefix);

        for(int i=1 ; i < nums.length ; i++){
            nums[i] += nums[i-1];
        }
        Utils.printArray(nums);
    }
}
