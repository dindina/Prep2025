package dynamic;
public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fib(600));
    }

    public static int fib(int n)
    {
        int[] dp = new int[n];
        dp[0]=0;
        dp[1]=1;
        for(int i=2 ; i< n ; i++)
        {
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
