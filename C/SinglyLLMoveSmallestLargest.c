//Move the smallest number at beginning and largest at the end in Singly Linked List

#include <stdio.h>
#include <stdlib.h>

 struct Node
{
    int data;
    struct Node* next;
};

struct Node *insertLast(struct Node *p,int val)
{
    struct Node *temp, *temp1;
    temp = (struct Node *)malloc(sizeof(struct Node));
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

struct Node * shiftSmallLarge(struct Node *org)
{
  struct Node *temp,*temp1, *temp2;
  temp = org;
  int s=temp->data,l=temp->data;
  while(temp!=NULL)
  {
    s=s<temp->data?s:temp->data;
    l= l>temp->data?l:temp->data;
    temp=temp->next;
  }
  temp=org;
  while(temp!=NULL)
  {
    if(temp->data == s)
    {
      temp1 = temp;
    }
    if(temp->data == l)
    {
      temp2 = temp;
    }
    temp=temp->next;
  }
  temp=org;
  while(temp->next!=temp1)
  {
    temp=temp->next;
  }
  temp->next = temp1->next;
  temp1->next = org;
  org =temp1;
  temp= org;
  while(temp->next!= temp2)
  {
    temp = temp->next;
  }
  temp->next=temp2->next;
  temp2->next=NULL;
  temp=org;
  while(temp->next!=NULL)
  {
    temp=temp->next;
  }
  temp->next = temp2;
  return org;
}

void display(struct Node *p)
{
    struct Node *temp = p;
    while(temp!=NULL)
    {
        printf("%d ",temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main()
{
    struct Node *start;
    start = NULL;
    int n,val,c;
    printf("Enter total numbers to enter: ");
    scanf("%d",&n);
            while(n-->0)
            {
                scanf("%d",&val);
                start= insertLast(start,val);
            }
    
    display(start);
    start = shiftSmallLarge(start);
    display(start);
}