package binarysearch;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int [] nums = new int[] {4,5,6,7,8,1,2,3};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums));
        System.out.println(new FindMinimumInRotatedSortedArray().findRotationIndex(nums));

    }


    public int findRotationIndex(int[] nums) {

        if(nums[0] <= nums[nums.length-1]) return 0; // already sorted
        int low = 0;
        int high = nums.length-1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            //System.out.println("mid  " + mid);

            if( nums[mid] > nums[mid+1])
            {
                return mid+1;
            }

            if(nums[mid] < nums[low])
            {
                high= mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return 0;

    }



    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;

        while(left <= right ){
            int mid = (left+right)/2;

            // find which half is sorted
            if(nums[left] <= nums[mid]) // left is sorted
            {
                min = Math.min(min,nums[left]);
                left = mid+1;
            }else {
                min = Math.min(min,nums[mid]);
                right = mid-1;
            }
        }
        return min;
    }
}
