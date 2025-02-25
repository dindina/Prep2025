package array;

public class FindFirstOccurrence {

    public static void main(String[] args) {
        int [] nums = new int[] { 2,2,2,2,2,5};
        System.out.println(findFirst(nums,2));
        System.out.println(findLast(nums,2));

    }

    public static int findLast( int[] nums , int target  ) {

        int left = 0;
        int right = nums.length-1;
        int result = -1;
        while(left <= right){
            int mid = (left+right)/2;

            if(nums[mid] == target)
            {
                result= mid;
                left = mid+1;
            }else if( target > nums[mid])
            {
                left = mid+1;
            }
            else {
                right = mid-1;
            }


        }

        return result;
    }

    public static int findFirst( int[] nums , int target  ){


        int left= 0;
        int right = nums.length-1;
        int result = 0;
        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid] == target){
                result = mid;
                right = mid-1;

            }
            else if (nums[mid ] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }
}
