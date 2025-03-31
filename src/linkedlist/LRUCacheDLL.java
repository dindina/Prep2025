package linkedlist;


import java.util.*;



class DNode{
    int val;
    int key;
    DNode next;
    DNode prev;
    @Override
    public String toString(){
        return "key->"+key + ",val->"+val ;
    }
    public DNode(int key, int val)
    {
        this.val = val;
        this.key = key;
        next = null;
        prev = null;
    }
    public DNode()
    {
        this.val = -1;
        next = null;
        prev = null;
    }
};


public class LRUCacheDLL {

    @Override
    public String toString(){
        return map.toString();
    }

    public static void main(String[]args){
        LRUCacheDLL cache = new LRUCacheDLL(3);
        cache.put(1,100);
        System.out.println(cache);
        cache.put(2,200);
        System.out.println(cache);
        cache.put(3,300);
        System.out.println(cache);
        cache.put(4,400);
        System.out.println(cache);
        cache.put(5,400);
        System.out.println(cache);

        System.out.println(cache.get(2));
        System.out.println(cache);
        cache.get(3);
        System.out.println(cache.get(3));

    }

    DNode head;
    DNode tail;
    int SIZE;
    Map<Integer,DNode> map;

    public LRUCacheDLL(int capacity) {

        map = new HashMap<>();
        head = new DNode(-1,-1);
        tail = new DNode(-1,-1);
        head.next=tail;
        tail.prev=head;
        SIZE = capacity;

    }

    public int get(int key) {

        if(map.containsKey(key)) {
            DNode node = map.get(key);
            remove(node);
            addToFront(node);
            return node.val;
        }
        else {
            return -1;
        }

    }

    // removing from the tail
    public void remove(DNode node){

        DNode prev = node.prev;
        DNode next = node.next;

        prev.next =next;
        next.prev = prev;

    }



    public boolean addToFront(DNode node)
    {

            DNode next = head.next;
            node.prev = head;
            node.next = next;
            head.next = node;
            next.prev = node;
            return true;


    }



    public void put(int key, int value) {

    if(map.containsKey(key)){
        DNode node = map.get(key);
        node.val = value;
        remove(node);
        addToFront(node);
        map.put(key,node);
    }else {
        DNode newNode = new DNode(key,value);
        if(addToFront(newNode)){
            map.put(key,newNode);
        }
    }

    if(map.size()+1 > SIZE)
    {
        DNode del = tail.prev;
        System.out.println("deleting before tail " + del);
        remove(del);
        //removeLast();
        map.remove(del.key);
    }



    }
}
