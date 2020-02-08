#include <stdio.h>

#define SIZE 10

int Stack[SIZE], top = -1;

int push(int item)
{
    if(top==(SIZE-1))
    {
        printf("overflow");
        return -1;
    }
    else
    {
        top=top+1;
        Stack[top]=item;
        printf("%d added in Stack\n",Stack[top]);
    }
    
}

int pop()
{
    int temp;
    if(top==-1)
    {
        printf("Underflow");
    }
    else
    {
        temp=Stack[top--];
        printf("%d popped from Stack\n", temp);
        return temp;
    }
    
}

 int main()
 {
     int temp;
     push(1);
     push(2);
     temp=pop();
     push(3);
     push(4);
     temp=pop();


     return 0;
 }