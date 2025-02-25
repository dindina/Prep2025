package slidingwindow;

/*
You are given two strings s1 and s2.

Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.

Both strings only contain lowercase letters.

Example 1:

Input: s1 = "abc", s2 = "lecabee"

Output: true
Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".

Example 2:

Input: s1 = "abc", s2 = "lecaabee"

Output: false
 */
public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "lecabee";

        System.out.println(new PermutationInString().checkInclusion(s1,s2));


    }

    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length())
            return false;
        String initialWindow = s2.substring(0,s1.length());
        System.out.println("initialWindow- > " + initialWindow);
        if(checkAnagram(initialWindow,s1))
            return true;

        for(int i = s1.length(); i < s2.length(); i++ ){

            initialWindow = initialWindow + s2.charAt(i);
            System.out.println("after appending -> " + initialWindow);
            initialWindow = initialWindow.substring(1);
            System.out.println("after removing-> " + initialWindow);
            if(checkAnagram(initialWindow,s1))
                return true;
        }
        return false;
    }

    boolean checkAnagram(String s1, String s2)
    {
        int[] charArray = new int[256];

        for(int i= 0 ; i < s1.length(); i++){
            charArray[s1.charAt(i)] +=1;
        }
        for(int i= 0 ; i < s2.length(); i++){
            charArray[s2.charAt(i)] -=1;
        }
        for(int i= 0 ; i < s2.length(); i++){
            if(charArray[s2.charAt(i)] !=0 )
                return false;
        }

        return true;

    }
}
