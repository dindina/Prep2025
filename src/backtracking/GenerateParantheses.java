package backtracking;

import java.util.*;

public class GenerateParantheses {

    public static void main(String[] args) {

        System.out.println(new GenerateParantheses().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(n,result,new StringBuilder(), 0,0);
        return result ;


    }

    public void backtrack(int n, List<String> result , StringBuilder sbr , int open , int close){

        if(sbr.length() == 2*n)
        {
            result.add(sbr.toString());
            return;
        }
        if(open < n)
        {

                sbr.append("(");
                backtrack(n,result,sbr,open+1,close);
                sbr.deleteCharAt(sbr.length()-1);

        }
        if(close < open)
        {

                sbr.append(")");
                backtrack(n,result,sbr,open,close+1);
                sbr.deleteCharAt(sbr.length()-1);

        }

    }
}
