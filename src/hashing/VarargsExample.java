package hashing;

import java.util.Objects;

public class VarargsExample {

    public static int sum(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static void printStrings(String... strings) {
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println(); // New line at the end
    }

    public static int hashAll(Object... strings) {
        return Objects.hash(strings);
    }

    public static void main(String[] args) {
        int sum1 = sum(1, 2, 3);
        int sum2 = sum(10, 20, 30, 40, 50);
        int sum3 = sum(); // No arguments

        System.out.println("Sum1: " + sum1); // Output: Sum1: 6
        System.out.println("Sum2: " + sum2); // Output: Sum2: 150
        System.out.println("Sum3: " + sum3); // Output: Sum3: 0

        printStrings("Hello", "World", "!"); // Output: Hello World !
        printStrings("Java", "is", "awesome."); // Output: Java is awesome.
        printStrings(); // Output: (newline)
    }
}
