package week1;

import java.math.BigInteger;

/*
Given two binary strings a and b, return their sum as a binary string.
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinary {


        public String addBinary(String a, String b) {
            BigInteger x = new BigInteger(a, 2);
            BigInteger y = new BigInteger(b, 2);
            BigInteger zero = new BigInteger("0", 2);
            BigInteger carry, answer;
            while (y.compareTo(zero) != 0) {
                answer = x.xor(y);
                carry = x.and(y).shiftLeft(1);
                x = answer;
                y = carry;
            }
            return x.toString(2);
        }

    }

