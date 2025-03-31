package linkedlist;

import java.util.*;

public class LRUCacheUsingLinkedHashMap {
    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap lruCache = new LRUCacheUsingLinkedHashMap(3);
        lruCache.put(1,100);
        System.out.println(lruCache);

        lruCache.put(2,200);
        System.out.println(lruCache);
        lruCache.put(3,300);
        System.out.println(lruCache);
        lruCache.put(4,400);
        System.out.println(lruCache);

    }


    private LinkedHashMap<Integer, Integer> map;
    private int SIZE;
    public LRUCacheUsingLinkedHashMap(int capacity) {
        map = new LinkedHashMap<>();
        SIZE = capacity;
    }
    @Override
    public String toString()
    {
        return map.toString();
    }

    public int get(int key) {

        if(map.containsKey(key))
        {
            int value = map.remove(key);
            map.put(key,value);
            return value;

        }else {
            return -1;
        }

    }



    public void put(int key, int value) {


        map.remove(key);

        if(map.size()+1 > SIZE){
            // remove
            map.remove(map.keySet().iterator().next());

        }
        map.put(key,value);


    }
}
