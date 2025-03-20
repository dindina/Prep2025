package practice;

import java.util.Arrays;

public class JustLikeThat {

    public static void main(String[] args) {
        int [] nums = new int[] { 1,2,3,3,4,4,6,6,8};
        for(int i= 0 ; i < nums.length ; i++)
        {
            System.out.println(find(nums,nums[i]));
        }
        System.out.println("find first");
        System.out.println(findFirst(nums,2));
        System.out.println(findFirst(nums,3));
        System.out.println(findFirst(nums,4));
        System.out.println(findFirst(nums,6));

        System.out.println("find last");
        System.out.println(findLast(nums,2));
        System.out.println(findLast(nums,3));
        System.out.println(findLast(nums,4));
        System.out.println(findLast(nums,6));

        System.out.println("find rotation");
        int [] nums1 = new int[] { 4,5,6,7,8,1,2,3};

        for(int i= 0 ; i < nums1.length ; i++)
        {
            System.out.println(findInRotatedArray(nums1,nums1[i]));
        }
        System.out.println("rotation index");
        Arrays.sort(nums1);
        System.out.println(findRotationIndex(nums));
        System.out.println(findRotationIndex(nums1));


    }
    public static int findRotationIndex(int[] nums) {
        if(nums[0] <= nums[nums.length-1])
        {
            return 0;
        }

        int left = 0;
        int right = nums.length-1;

        while(left <= right){

            int mid = (left + right) /2;

            if(mid < nums.length-1 && nums[mid] > nums[mid+1]){
                return mid+1;
            }

            if(nums[left] <= nums[mid]) { // left side is sorted 4,5,6,7,1,4
                left = mid + 1 ;
            }
            else {
                right = mid - 1 ;
            }
        }
        return -1;

    }


    public static int findInRotatedArray(int[] nums , int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){

            int mid = (left + right) /2;
            if(nums[mid] == target )
                return mid;

            if(nums[left] <= nums [mid]) // left is sorted // 4,5,6,7,1,2
            {
                if( target > nums[mid] || target < nums[left] )
                {
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }else{
                // 7,6,1,2,3,4,5
                if(target < nums[mid] || target > nums[right] )
                {
                    right = mid -1;
                }else {
                    left = mid +1;
                }

            }

        }
        return -1;
    }

    public static int findLast(int[] nums , int target){
        int left = 0;
        int right = nums.length-1;
        int result = -1;
        while(left <= right){

            int mid = (left + right)/2;

            if(nums[mid] == target){

                result=mid;
                left = mid +1;
            }else if( target > nums[mid])
            {
                left = mid + 1;
            }else{
                right = mid - 1;

            }
        }
        return result;

    }


    public static int findFirst(int[] nums , int target){
        int left = 0;
        int right = nums.length-1;
        int result =-1;

        while(left <= right){
            int mid = (left + right) /2;

            if( nums[mid] == target) {
                result = mid;
                right = mid-1;
            } else if(target > nums[mid])
            {
                left = mid+1;
            }
            else {
                right= mid-1;

            }
        }

        return result;
    }

    public static int find(int[] nums , int target){

        int left =0;
        int right = nums.length-1;

        while(left <= right){

            int mid = (left+right)/2;

            if(nums[mid] == target)
            {
                return mid;
            }
            else if( target > nums[mid])
            {
                left = mid+1;
            }
            else{

                right = mid-1;
            }

        }
        return -1;
    }
}
