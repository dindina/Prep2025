package common;

public class Utils {

    public static void printArray(int [] nums)
    {
        System.out.println("printing array");
        for(int i : nums)
        {
            System.out.print(i + "->");
        }
        System.out.println();
    }
}
