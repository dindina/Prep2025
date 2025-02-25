package twopointers;

import java.util.*;
public class Three3Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(new Three3Sum().threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        int left=0;
        int right =0;
        Arrays.sort(nums);

        for(int i=0; i < nums.length ; i++){

            left= i+1;
            right = nums.length-1;
            while(left <right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    String str = nums[left] + ":" + nums[right] + ":" + nums[i];
                    if (!set.contains(str)) {
                        List<Integer> triplet = Arrays.asList(nums[left], nums[right], nums[i]);
                        result.add(triplet);
                        set.add(str);

                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return result;
    }

}
