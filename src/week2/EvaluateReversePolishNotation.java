package week2;


import java.util.Stack;

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String [] tokens = new String[] {"4","13","5","/","+"};
        System.out.println( new EvaluateReversePolishNotation().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(String characters : tokens){

            try {
                int number = Integer.parseInt(characters);
                stack.push(number);
            }
            catch (Exception e)
            {
                int no1 = stack.pop();
                int no2 = stack.pop();
                result = calc( no2, no1 , characters);
                stack.push(result);
            }
        }

        return stack.pop().intValue();

    }

    public int calc(int val1 , int val2 , String operator )
    {
        if ( operator.equals("+"))
        {
            return val1 + val2;
        }else if ( operator.equals("-"))
        {
            return val1 - val2;
        }
        else if ( operator.equals("/"))
        {
            return val1 / val2;
        }
        else if ( operator.equals("*"))
        {
            return val1 * val2;
        }
        else {
            return 0;
        }
    }
}
