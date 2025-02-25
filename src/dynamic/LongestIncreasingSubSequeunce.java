package dynamic;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequeunce {

    public static void main(String[] args) {
        //int [] nums = { 100,5,6,7,1001,9};
        int [] nums = { 0,3,2,5,4,6,1,1};

        //System.out.println(find(nums));
        List<Integer> componentSizes =  Arrays.asList(3,2,3);

        long totalPairs = 0;
        for (int i = 0; i < componentSizes.size(); i++) {
            for (int j = i + 1; j < componentSizes.size(); j++) {
                totalPairs += (long) componentSizes.get(i) * componentSizes.get(j);
            }
        }

        System.out.println(totalPairs);

    }

    public static int find(int [] nums)
    {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i = nums.length-1; i >=0; i--)
        {
            //System.out.println("i "+ i );
            for(int j=i; j <nums.length ; j++)
            {
                //System.out.println("j "+ j );
                if(nums[i] < nums[j] && (nums[j]-nums[i]==1))
                {
                    //System.out.println("inside");
                    dp[i]= Math.max(dp[i], 1+dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
