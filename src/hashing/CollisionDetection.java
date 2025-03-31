package hashing;

import java.util.HashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CollisionDetection {

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("FB", 1);
        map.put("Ea", 2);
        map.put("another", 3);
        map.put("some other string", 4);
        map.put("a very long string", 5);

        int[] bucketSizes = getBucketSizes(map);

        if (bucketSizes != null) {
            for (int i = 0; i < bucketSizes.length; i++) {
                System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
            }
        }
    }

    public static int[] getBucketSizes(HashMap<?, ?> map) throws Exception {
        try {
            Field tableField = HashMap.class.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] table = (Object[]) tableField.get(map);

            if (table == null) {
                return null; // Empty map
            }

            int[] bucketSizes = new int[table.length];

            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    Object node = table[i];
                    int count = 0;
                    while (node != null) {
                        count++;
                        Method nextNode = node.getClass().getDeclaredMethod("getNextNode");
                        nextNode.setAccessible(true);
                        node = nextNode.invoke(node);
                    }
                    bucketSizes[i] = count;
                } else {
                    bucketSizes[i] = 0;
                }
            }
            return bucketSizes;
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}