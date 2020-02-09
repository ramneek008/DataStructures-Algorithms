// Find the minimum bracket reversals for balanced expression

import java.util.*;

class Result
{
  static int minReversal(String expr)
  {
    Stack<Character> st = new Stack<Character>();
    int len = expr.length();
    char c[] = expr.toCharArray();
    int m=0;
    if(len%2==1)
      return -1;
    else
    {
    for(int i=0;i<len;i++)
    {
      if(c[i]=='[')
      st.push(c[i]);
      else if(c[i]==']')
      {
        if(st.size()>0)
        st.pop();
        else
          m=m+2;
      }
    }
    
    return st.size()/2+m;
    }
  }
}

class Main
{
  public static void main(String[] args)
  {
    int t, ans;
    Scanner s=new Scanner(System.in);
    t = Integer.parseInt(s.nextLine().trim());
    while(t!=0)
    {
      String expr;
      expr = s.nextLine();
      ans = Result.minReversal(expr);
      System.out.println(ans);
      t--;
    }
  }
}