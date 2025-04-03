package array;

import java.util.*;
import java.util.List;

public class CharArray {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("dinesh","#saran",",Ami","Avini#");
        //List<String> stringList = Arrays.asList("","");
        System.out.println(encode(stringList) );
        System.out.println(decode(encode(stringList)) );
        //System.out.println(lengthOfLongestSubstring("xyzxyz"));
    }

    public  static String encode(List<String> strs) {
        StringBuilder sbr = new StringBuilder();
        for(String str : strs){
            sbr.append(str.replace("#","##")).append(" # ");
        }
        return sbr.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        String[] tokens = str.split(" # ",-1); // -1 used to apply pattern many times
        for(int i=0 ; i < tokens.length-1; i++) // last token must not be considered
        {
            list.add(tokens[i].replace("##","#"));
        }
        return list;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i=0; i<s.length(); i++){

            int j=i;
            while(j < s.length() && set.contains(s.charAt(j))){

                set.remove(s.charAt(j));
                j++;
            }

            set.add(s.charAt(i));
            int len = set.size();
            max = Math.max(len,max);

        }
        return max;

    }


}
