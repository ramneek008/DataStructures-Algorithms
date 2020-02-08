class Stack
{
    int maxSize;
    int top;
    int stArr[];
    public Stack(int size)
    {
        maxSize = size;
        stArr = new int[maxSize];
        top=-1;
    }

    public void push(int item)
    {
        if(top==(maxSize-1))
        {
            System.out.println("Overflow");
        }
        else
        {
            stArr[++top] = item;
            System.out.println(stArr[top]+" is added to Stack.");
        }
    }

    public int pop()
    {
        if(top==-1)
        {
            System.out.println("Underflow");
            return -1;
        }
        else
        {
            int temp;
            temp=stArr[top--];
            System.out.println(temp+" is popped from Stack");
            return temp;
        }
    }

}

class Main
{
    public static void main(String args[])
    {
        Stack s = new Stack(10);
        int temp;
        s.push(1);
        s.push(2);
        temp=s.pop();
        s.push(3);
        s.push(4);
        temp=s.pop();
    }    
}