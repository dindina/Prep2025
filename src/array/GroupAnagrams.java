package array;

import common.Utils;

import java.util.*;
import java.util.stream.Collectors;


public class GroupAnagrams {

    public static void main(String[] args) {
       String[] strs = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            String charMap = getMap(str);

            if(map.containsKey(charMap))
            {
                List<String> exist = map.get(charMap);
                exist.add(str);
                System.out.println("exist " + exist);
                map.put(charMap, exist);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(charMap,newList );

                System.out.println("newList " + newList);
            }
        }

        return map.values().stream().toList();

    }
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<List<String>, List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            List<String> charMap = getMap1(str);

            if(map.containsKey(charMap))
            {
                List<String> exist = map.get(charMap);
                exist.add(str);
                System.out.println("exist " + exist);
                map.put(charMap, exist);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(charMap,newList );

                System.out.println("newList " + newList);
            }
        }

        return map.values().stream().toList();

    }

    String getMap(String str)
    {

        int[] charMap = new int[128];

        for(int i=0 ; i <str.length(); i++)
        {
            charMap[str.charAt(i)]++;
        }
        Utils.printArray(charMap);
        StringBuilder result = new StringBuilder() ;
        for( int i  : charMap)
            result.append(i+"-");

        //System.out.println(result);
        return result.toString();
    }

    List<String> getMap1(String str)
    {
        List<String> list = new ArrayList<>();
        int[] charMap = new int[128];

        for(int i=0 ; i <str.length(); i++)
        {
            charMap[str.charAt(i)]++;
        }

        for(int i : charMap)
        {
            list.add(String.valueOf(i));
        }

        return list;
    }

}
