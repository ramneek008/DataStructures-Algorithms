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


int findMiddle(struct Node* head) 
{
  if(head == NULL)
    return -1;
  else
  {
  struct Node *temp = head;
  int c=0;
  while(temp!=NULL)
  {
    c++;
    temp = temp->next;
  }
  temp = head;
  if(c%2==0)
  {
      c=(c/2);
    for(int i=0;i<c;i++)
    {
      temp=temp->next;
    }
  }
  else
  {
    int m = (c/2);
    for(int i=0;i<m;i++)
    {
      temp = temp->next;
    }
  }
  return temp->data;
  }

}

int findNLast(struct Node* head, int n)
{
  if(head==NULL)
    return -1;
  else
  {
  struct Node *temp = head;
  int c=0;
  while(temp != NULL)
  {
    c++;
    temp = temp->next;
  }
  temp = head;
  if(c<n)
  {
      while(temp->next!=NULL)
      {
          temp=temp->next;
      }
      return temp->data;
  }
  else{
  int m = c-n;
  temp=head;
  for(int i=0;i<m;i++)
  {
    temp=temp->next;
  }
  return temp->data;
  }
  }

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
    int last;
    
            while(n-->0)
            {
                scanf("%d",&val);
                start= insertLast(start,val);
            }
            scanf("%d",&last);
    display(start);
    
    int mid= findMiddle(start) ;
    int nlast= findNLast(start, last);
    printf("%d %d",mid,nlast);
}