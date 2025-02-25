package slidingwindow;

/*
You are given a binary string s (a string containing only "0" and "1"). You may choose up to one "0" and flip it to a "1". What is the length of the longest substring achievable that contains only "1"?

For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string becomes 1111100111.
 */

/*
Because the string can only contain "1" and "0", another way to look at this problem is "what is the longest substring that contains at most one "0"?"

 */
public class BinaryStringProblem {
    public static void main(String[] args) {

        String s1 = "1101100111";
        System.out.println("Longest ones: " + longest(s1)); // Output: 5

        String s2 = "10101";
        System.out.println("Longest ones: " + longest(s2)); // Output: 3

        String s3 = "00000";
        System.out.println("Longest ones: " + longest(s3)); // Output: 1

        String s4 = "11111";
        System.out.println("Longest ones: " + longest(s4)); // Output: 5

        String s5 = "1001";
        System.out.println("Longest ones: " + longest(s5)); // Output: 2
    }

    public static int longest(String s)
    {
        int left = 0;
        int zeroCount = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right)== '0') {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (s.charAt(left) == '0') {
                    zeroCount--;
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;

    }



}
