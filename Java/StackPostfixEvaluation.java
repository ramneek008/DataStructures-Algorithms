import java.util.*;

class Postfix
{
    static int postfixEvaluation(String exp)
    {
        Stack<Integer> s = new Stack<Integer>();
        int i,op1,op2,answer;
        for(i=0;i<exp.length();i++)
        {
            char c = exp.charAt(i);
            if(Character.isDigit(c))
            {
                s.push(c-'0');
            }
            else
            {
                op2=s.pop();
                op1=s.pop();
                switch(c)
                {
                    case '+': s.push(op1+op2); break;
                    case '-': s.push(op1-op2); break;
                    case '*': s.push(op1*op2); break;
                    case '/': s.push(op1/op2); break;
                    case '^': s.push((int)Math.pow(op1,op2)); break;
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
        Postfix p = new Postfix();
        String exp= "632+7*+";
        System.out.println(p.postfixEvaluation(exp));
    }
}