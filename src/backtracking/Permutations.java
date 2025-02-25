package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int []  nums = new int[]{1,2,3};

        System.out.println(getPerm(nums));
    }

    public static  List<List<Integer>> getPerm(int [] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result, new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> objects) {

        if(objects.size() == nums.length) {
            result.add(new ArrayList<>(objects));
            return;
        }

        for(int i=0; i< nums.length ; i++)
        {
            if(objects.contains(nums[i])) continue; // same number must not be repeated
            objects.add(nums[i]);
            backtrack(nums,result,objects);
            objects.remove(objects.size()-1);
        }
    }
}
