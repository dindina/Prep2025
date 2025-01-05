package week4;

import java.util.*;

/*
https://leetcode.com/problems/time-based-key-value-store/description/

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".


Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
 */
public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeBasedKeyValueStore map = new TimeBasedKeyValueStore();
        map.set("key1","dinesh1",1000);
        map.set("key1","dinesh2",1001);
        map.set("key1","dinesh3",1002);
        System.out.println(map.get("key1",10000));
    }

    Map<String, List<Pair>> map = new HashMap<>();

    public TimeBasedKeyValueStore() {


    }
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair();
        pair.value=value;
        pair.timestamp=timestamp;;
        if(map.containsKey(key))
        {
            List<Pair> list = map.get(key);
            list.add(pair);
        }
        else {
            List<Pair> newValue = new ArrayList<>();
            newValue.add(pair);
            map.put(key, newValue );
        }
    }
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
        {
            return "";
        }
        List<Pair> valueList = map.get(key);
        int left = 0;
        int right = valueList.size()-1;
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(valueList.get(mid).timestamp > timestamp)
            {
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        if(right>=0)
            return valueList.get(right).value;
        else
            return "";


    }

}
class Pair{
    String value;
    int timestamp;


}
