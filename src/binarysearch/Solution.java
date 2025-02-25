package binarysearch;

public class Solution {

    public static void main(String[] args) {
        //int [] nums = new int[] { 4,5,6,7,8,1,2,3,};
        //System.out.println(searchLowest(nums));

        int [] nums = new int[] { 10,1,2,3,4,5};
        System.out.println(searchLowest(nums));
    }

    public static int searchLowest(int [] nums){

        if(nums[0] <= nums[nums.length-1]) // no rotation
            return nums[0];
        int left = 0;
        int right = nums.length-1;

        while(left <=right){

            //int mid = (left+right)/2;
            int mid = left + (right - left) / 2;
            System.out.println("mid "+ nums[mid]);

            if( mid+1 <= nums.length-1 && nums[mid]>nums[mid+1]){
                return nums[mid+1];

            }
            else if( nums[left] > nums[mid]){
                right=mid-1;
                System.out.println("right");
            }
            else {
                left=mid+1;
                System.out.println("left");
            }
        }
        return -1;
    }
}
