package array;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    class Pair{
        int key ;
        String value;

        Pair(int key  , String value)
        {
            this.key = key;
            this.value = value;
        }

    }

    public  int capacity;
    public int size;

    List<List<Pair>> map;
    public HashTable(int capacity){
        this.capacity = capacity;
        this.size = 0;
        map = new ArrayList<>(capacity);

        for(int i=0 ; i <capacity ; i++){
            map.add(new ArrayList<>());
        }
    }

    public int getSize(){
        return this.size;
    }
    public int getCapacity(){
        return this.capacity;
    }

    public int hashCode(int num)
    {
        return num % this.capacity;
    }

    public String get(int key){

        List<Pair> bucket = map.get(hashCode(key));
        for(Pair pair : bucket){
            if(pair.key == key){
                return pair.value;
            }
        }
        return null;
    }

    public boolean remove(int key){

        List<Pair> bucket = map.get(hashCode(key));
        for(int i =0 ; i <bucket.size() ; i++){
            if(bucket.get(i).key == key)
            {
                bucket.remove(bucket.get(i));
                this.size--;
                return true;
            }
        }
        return false;
    }

    public void insert(int key , String value){
        List<Pair> bucket = map.get(hashCode(key));
        for(int i =0 ; i <bucket.size() ; i++) {
            if(bucket.get(i).key == key)
            {
                //bucket.set(i,new Pair(key,value));
                bucket.get(i).value = value;
                return;
            }
        }
        // if no key exists
        bucket.add(new Pair(key,value));
        this.size++;
        if( (double) this.size/this.capacity >= 0.5)
            resize();

    }

    public void resize(){
        int newCapacity = getCapacity()*2;

        HashTable newTable = new HashTable(newCapacity);

        for(List<Pair> buckets: map){
            for(Pair pair : buckets){
                newTable.insert(pair.key,pair.value);
            }
        }

        this.map = newTable.map;
        this.size = newTable.size;
        this.capacity = newCapacity;



    }
    public static void main(String[] args) {
        HashTable table = new HashTable(2);
        System.out.println(table.capacity);
        table.insert(6,"dinesh");
        System.out.println(table.capacity);
        table.insert(1,"sran");
        System.out.println(table.capacity);
        table.insert(3,"amai");
        System.out.println(table.capacity);
        System.out.println(table.getSize());

        System.out.println(table.get(6));
        System.out.println(table.get(1));
        System.out.println(table.get(3));
        table.remove(3);
        table.remove(1);
        System.out.println(table.get(1));
        System.out.println(table.get(3));



    }

}
