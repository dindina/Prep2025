package array;

import java.util.HashMap;
import java.util.Map;

class Tuple{
    String value;
    long time;

    public Tuple(String s , long t){
        this.value = s;
        this.time = t;
    }

}
public class MapTest {
    public static void main(String[] args) {
        Map<String,Tuple> map = new HashMap<>();
        map.put("dinesh" , new Tuple("dinesh",100));
        Tuple tuple = map.computeIfAbsent("dinesh",k -> new Tuple("test",0l));
        System.out.println(tuple.value);
        tuple.value = "saran";

        Tuple tuple1 = map.computeIfAbsent("dinesh",k ->{
            return new Tuple("test",0l);
        });
        System.out.println(tuple1.value);


    }
}
