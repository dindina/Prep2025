package practice;

import java.util.HashMap;
import java.util.*;

public class ComputeIfAbsent {

    public static void main(String[] args) {


        String [] str = new String[] {"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(str));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str : strs){
            String charMap = getCharMap(str);
            map.computeIfAbsent(charMap, k-> new ArrayList<>()).add(str);
        }

        System.out.println(map.values());
        for(List<String> temp : map.values()){
            result.add(temp);
        }
        return result;


    }

    public static String getCharMap(String str){
        int[] charArray = new int[256];
        for(char ch : str.toCharArray()){
            charArray[ch]++;
        }

        return Arrays.toString(charArray);
    }
}
