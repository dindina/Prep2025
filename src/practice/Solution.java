package practice;

import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.name="dinesh";
        emp1.no=1;
        emp1.salary=100;
        emp1.scores = new int[]{10,20,30};

        Employee emp2 = new Employee();
        emp2.name="dinesh1";
        emp2.no=2;
        emp2.salary=200;
        emp2.scores = new int[]{10,10,20};

        Employee emp3 = new Employee();
        emp3.name="dinesh2";
        emp3.no=3;
        emp3.salary=300;
        emp3.scores = new int[]{10,10,10};

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        // find the maximum salary
        long max = list.stream().mapToInt(emp->emp.salary).max().getAsInt();
        System.out.println(max);

        // find the emp with maximum salary
        Optional<Employee> op = list.stream().max(Comparator.comparingInt(emp->emp.salary));
        if(!op.isEmpty()){
            System.out.println(op.get().name);
        }

        // find the average salary of all the employee
        int sum = list.stream().mapToInt(emp->emp.salary).sum();
        System.out.println("sum" + sum);

        Optional<Employee> maxAverageScoreEmployee = list.stream()
                .max(Comparator.comparingDouble(Employee::getAverageScore));
        System.out.println("maxAverageScoreEmployee" + maxAverageScoreEmployee.get().name);

    }


}

class Employee{
    int no;
    String name;
    int salary;

    public double getAverageScore() {
        if (scores == null || scores.length == 0) {
            return 0.0;
        }
        return Arrays.stream(scores).average().orElse(0.0);
    }

    int[] scores;
}