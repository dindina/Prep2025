package practice;

// you can also use imports, for example:
import java.util.*;

/*Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

        Given A = [1, 2, 3], the function should return 4.

        Given A = [−1, −3], the function should return 1.

        Write an efficient algorithm for the following assumptions:*/


class Codilitytest {

    public static void main(String[] args) {
        //int [] nums = new int[] { 1, 3, 6, 4, 1, 2 };
        int [] nums = new int[] { -1,-3};
        System.out.println(solution(nums));
    }
    public static int solution(int[] A) {
        Set<Integer> seen = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                seen.add(num);
            }
        }

        int smallestPositive = 1;
        while (seen.contains(smallestPositive)) {
            smallestPositive++;
        }

        return smallestPositive;
    }
}
