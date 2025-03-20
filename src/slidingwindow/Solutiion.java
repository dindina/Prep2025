package slidingwindow;

public class Solutiion {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 205, 5, 1, 90, 10};
        // maximum sub array sum of size k
        System.out.println(maxsumofsizek(nums, 3));
    }

    public static int maxsumofsizek(int[] nums, int k) {
        int left = 0;
        int windowsum = 0;
        int right = 0;
        while(right < k)
        {
            windowsum += nums[right++];
        }
        int max = windowsum;
        System.out.println("right " + right);
        System.out.println("windowsum " + windowsum);
        for (; right < nums.length; right++) { // after calculating intial window , it is very easy

            windowsum+=nums[right];
            windowsum-=nums[left++];
            System.out.println("windowsum " + windowsum);
            max = Math.max(windowsum,max);
        }
        return max;

    }


}


