import java.util.*;

class Postfix
{
    public int Prec(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public String infixToPostfix(String exp)
    {
        String result = new String("");
        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                result += c;
            }

            else if(c=='(')
            stack.push(c);

            else if(c==')')
            {
                while(!stack.isEmpty() && stack.peek()!='(')
                {
                    result += stack.pop();
                }
                if(!stack.isEmpty() && stack.peek()!='(')
                    return "Invalid Expression";
                else
                    stack.pop();
            }

            else
            {
                while(!stack.isEmpty() && Prec(c)<=Prec(stack.peek()))
                {
                    if(stack.peek()=='(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty())
        {
            if(stack.peek()=='(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;

    }

}

class Main
{
    public static void main(String args[])
    {
        Postfix p = new Postfix();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(p.infixToPostfix(exp));

    }

}