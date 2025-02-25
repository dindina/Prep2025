package binarysearch;

import common.Utils;

public class FindFirstOccurence {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        Utils.printArray(new FindFirstOccurence().searchRange(nums,target));
        //System.out.println("last " + new FindFirstOccurence().findLast(nums,target));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);
        return result;

    }

    public int findFirst(int[] nums, int target)
    {
        int left=0;
        int right=nums.length-1;
        int result =-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            System.out.println("mid " + mid);
            if(target == nums[mid]){
                result = mid; // keep searching and on the left
                right = mid-1; // search left most element , so search in the left

            }else if(target > nums[mid])
            {
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return result;
    }

    public int findLast(int[] nums, int target)
    {
        int left=0;
        int right=nums.length-1;
        int result =-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            System.out.println("mid " + mid);
            if(target == nums[mid]){
                result = mid; // keep searching and on the right
                left = mid+1; // search right most element , so search in the left

            }else if(target > nums[mid])
            {
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return result;
    }
}

