//Insertion in Singly Linked List


#include <stdio.h>
#include <stdlib.h>

struct ll 
{
    int data;
    struct ll *next;
};

struct ll *insertBegin(struct ll *p, int val)
{
    struct ll *temp;
    temp = (struct ll *)malloc(sizeof(struct ll));
    //temp = new struct linklist()  .....  in c++
    temp->data = val;
    temp->next = p;
    p = temp;
    return p;

}

struct ll *insertLast(struct ll *p,int val)
{
    struct ll *temp, *temp1;
    temp = (struct ll *)malloc(sizeof(struct ll));
    temp->data = val;
    temp->next = NULL;
    if(p==NULL)
    {
        p=temp;
    }
    else
    {
        temp1=p;
        while(temp1->next!=NULL)
        {
            temp1 = temp1->next;
        }
        temp1->next = temp;

    }
    return p;
    
}

void display(struct ll *p)
{
    struct ll *temp = p;
    while(temp!=NULL)
    {
        printf("%d ",temp->data);
        temp = temp->next;
    }
}

int main()
{
    struct ll *start;
    start = NULL;
    int n,val,c;
    printf("Enter total numbers to enter: ");
    scanf("%d",&n);
    printf("Select following: \n1. Insert at beginning. \n2. Insert at Last.\n");
    scanf("%d",&c);
    switch(c)
    {
        case 1: 
        {
            while(n-->0)
            {
                scanf("%d",&val);
                start = insertBegin(start,val);
            }
            break;
        }
        case 2:
        {
            while(n-->0)
            {
                scanf("%d",&val);
                start= insertLast(start,val);
            }
            break;
        }
        default:
        printf("Enter valid number");
        break;
    }
    
    display(start);
}