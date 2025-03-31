package hashing;

import java.util.HashMap;
import java.util.*;

public class HashMapSample {
    public static void main(String[] args) {

        String string1 = "FB";
        String string2 = "Ea";

        System.out.println("HashCode of FB: " + string1.hashCode());
        System.out.println("HashCode of Ea: " + string2.hashCode());

        if (string1.hashCode() == string2.hashCode()){
            System.out.println("Collision Detected!");
        }

        Map<Integer,String> map = new HashMap<>();
        map.computeIfAbsent(0,k-> new String("dinesh").intern());
        map.put(1,"dinesh");
        System.out.println(map);
        if(map.get(0) == "dinesh"){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
