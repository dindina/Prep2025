package array;

import java.util.*;

public class EncodeDeode {


    public static String encode(List<String> strs){
        StringBuilder sbr = new StringBuilder();
        for(String str :strs)
        {
            sbr.append(str.replace("#","##")).append(" # ");
        }
        return sbr.toString();

    }

    public static List<String> decode(String str){

        List<String> list = new ArrayList<>();
        String[] tokens = str.split(" # ",-1);
        for(int i=0; i< tokens.length ;i++){
            list.add(tokens[i].replace("##","#"));
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("dinesh","dinesh#","#dinesh#","saran");

        System.out.println(encode(stringList));
        System.out.println(decode(encode(stringList)));

    }
}
