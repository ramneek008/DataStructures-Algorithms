import java.util.*;

class Prefix
{
    static int prefixEvaluation(String exp)
    {
        Stack<Integer> s = new Stack<Integer>();
        int i,op1,op2,answer;
        for(i=exp.length()-1;i>=0;i--)
        {
            char c = exp.charAt(i);
            if(Character.isDigit(c))
            {
                s.push(c-'0');
            }
            else
            {
                op1=s.pop();
                op2=s.pop();
                switch(c)
                {
                    case '+': s.push(op1 + op2); break;
                    case '-': s.push(op1 - op2); break;
                    case '*': s.push(op1 * op2); break;
                    case '/': s.push(op1 / op2); break;
                }
            }
        }
        answer=s.pop();
        return answer;

    }

}

class Main
{
    public static void main(String args[])
    {
        Prefix p =new Prefix();
        String exp = "+6*+237";
        System.out.println(p.prefixEvaluation(exp));
    }
}