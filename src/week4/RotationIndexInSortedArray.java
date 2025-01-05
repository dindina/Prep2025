package week4;

public class RotationIndexInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 3,4,5,6,1,2};
        int target = 2;
        int rotationIndex =  new RotationIndexInSortedArray().getRotationIndex(nums);
        System.out.println("rotationIndex" + rotationIndex);
        System.out.println("target at " +
                new RotationIndexInSortedArray().search(nums,target));

    }
    public int search(int[] nums, int target) {
        int rotationIndex =  getRotationIndex(nums);
        int high,low ;
        if(nums[rotationIndex] == target)
        {
            return rotationIndex;
        }

        if(nums[0] == nums[rotationIndex])
        {
            low = 0;
            high= nums.length-1;
        } else if(target >= nums[0])
        {
            low = 0;
            high = rotationIndex;
        }
        else {
            low=rotationIndex;
            high=nums.length-1;
        }

        while(low <= high)
        {
            int mid = (low + high)/2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
            {
                low= mid+1;
            }
            else {
                high=mid-1;
            }
        }

        return -1;

    }


    public int getRotationIndex(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            if( ((mid+1) <nums.length) && (nums[mid] > nums[mid+1]))
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
}
