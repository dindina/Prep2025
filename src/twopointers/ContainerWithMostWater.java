package twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1,7,2,5,4,7,3,6 // 36
        };

        System.out.println(new ContainerWithMostWater().maxArea(nums));
    }
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length-1;
        int max = 0;

        while(left < right)
        {
            int min = Math.min(heights[left],heights[right]);
            int area = min * (right-left);
            System.out.println(area);

            max = Math.max(area,max);

            if(heights[left] <= heights[right])
            {
                left++;
            }
            else {
                right--;
            }
        }

        return max;

    }
}
