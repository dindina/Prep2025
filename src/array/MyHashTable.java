package array;

import java.util.ArrayList;
import java.util.List;

class MyHashTable {

    record Pair(int key, int value) {}

    private static final double LOAD_FACTOR_THRESHOLD = 0.5;

    List<List<Pair>> map;

    int capacity ;
    private int size; // Track the current number of elements

    public MyHashTable(int capacity) {

        map = new ArrayList<>(capacity);
        this.capacity= capacity;
        for(int i=0 ; i <capacity ; i++){
            map.add(i,new ArrayList<>());
        }
        this.size = 0;

    }

    public int getHashCode(int key)
    {
        return key%getCapacity();

    }

    public void insert(int key, int value) {

        System.out.println("inserting " +key +","+value);


        List<Pair> bucket = map.get(getHashCode(key));
        // to check if the same key exist
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.set(i, new Pair(key, value));
                return;
            }
        }
        bucket.add(new Pair(key, value));
        this.size++;
        if((double) getSize()/capacity >= LOAD_FACTOR_THRESHOLD) resize();

    }

    public int get(int key) {
        List<Pair> bucket = map.get(getHashCode(key));
        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;


    }

    public boolean remove(int key) {

        List<Pair> bucket = map.get(getHashCode(key));
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i);
                this.size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        int newCapacity = capacity * 2;
        MyHashTable newTable = new MyHashTable(newCapacity);

        for (List<Pair> bucket : map) {
            for (Pair pair : bucket) {
                newTable.insert(pair.key(), pair.value());
            }
        }

        this.capacity = newCapacity;
        this.map = newTable.map;
        this.size = newTable.size; // Update the size after resizing

    }

    public static void main(String[] args) {
        MyHashTable table = new MyHashTable(2);
        System.out.println(table.capacity);
        table.insert(6,7);
        System.out.println(table.capacity);
        table.insert(1,2);
        System.out.println(table.capacity);
        table.insert(3,4);
        System.out.println(table.capacity);
        System.out.println(table.getSize());

    }
}
