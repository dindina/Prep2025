package array;

import java.util.*;

public class TimeMap {

    Map<String, List<Pair>> map ;

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("one", "dinesh1", 1);
        timeMap.set("one", "dinesh2", 2);
        timeMap.set("one", "dinesh4", 4);
        timeMap.set("one", "dinesh6", 6);

        System.out.println(timeMap.get("one", 5));
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if(map.containsKey(key))
        {
            List<Pair> values = map.get(key);
            values.add(new Pair(value,timestamp));
            map.put(key,values);
        }else{
            List<Pair> values = new ArrayList<>();
            values.add(new Pair(value,timestamp));
            map.put(key,values);
        }
    }

    public String get(String key, int timestamp) {

        if(!map.containsKey(key))
            return "";

        List<Pair> values = map.get(key);

        Collections.sort(values);

        int left = 0;
        int right = values.size()-1;
        String result = "";
        while(left <= right){

            int mid = (left+right)/2;
            if(values.get(mid).timestamp <= timestamp){

                left=mid+1;
                result = values.get(mid).value;
            }else
            {
                right=mid-1;
            }
        }
        return result;

    }
    static class Pair implements Comparable<Pair>{
        String value;
        int timestamp;

        @Override
        public int compareTo( Pair pair){
            return this.timestamp - pair.timestamp;
        }

        public Pair(String value , int timestamp){
            this.timestamp=timestamp;
            this.value = value;
        }

    }
}
