package backtracking;

import java.util.*;
/*
https://neetcode.io/problems/combinations-of-a-phone-number
You are given a string digits made up of digits from 2 through 9 inclusive.

Each digit (not including 1) is mapped to a set of characters as shown below:

A digit could represent any one of the characters it maps to.

Return all possible letter combinations that digits could represent. You may return the answer in any order.
Input: digits = "34"

Output: ["dg","dh","di","eg","eh","ei","fg","fh","fi"]

 */
public class LetterCombinations {

    public static void main(String[] args) {

        String str = "34";
        System.out.println(get(str));

    }

    public static List<String> get(String str){

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        backtrackNumbers(0,str,map,result, new StringBuilder());
        return result;



    }

    private static void backtrackNumbers(int start, String str, Map<Character, String> map, List<String> result, StringBuilder stringBuilder) {

        System.out.println(stringBuilder);
        if(stringBuilder.length() == str.length())
        {
            result.add(stringBuilder.toString());
            return;
        }

        String mapped = map.get(str.charAt(start));
        for(int i=0; i < mapped.length(); i++){
            stringBuilder.append(mapped.charAt(i));
            backtrackNumbers(start+1,str,map, result,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
