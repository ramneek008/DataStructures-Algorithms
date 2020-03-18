#include <stdio.h>
#include <stdlib.h>

struct BSTree
{
    int data;
    struct BSTree *prev;
    struct BSTree *next;
};

struct BSTree* insert(struct BSTree* p, int val)
{
    struct BSTree *temp = NULL;
    if(p==NULL)
    {
        temp = (struct BSTree*)malloc(sizeof(struct BSTree));
        temp->data=val;
        temp->next=NULL;
        temp->prev=NULL;
        p=temp;
    }
    else if(val<p->data)
    {
        p->prev=insert(p->prev,val);
    }
    else
    {
        p->next=insert(p->next,val);
    }
    return p;    
}

void inorder(struct BSTree *root)
{
    if(root!=NULL)
    {
        inorder(root->prev);
        printf("%d ",root->data);
        inorder(root->next);
    }
}

int search(struct BSTree *p,int s)
{
    if(p==NULL)
    return 0;
    else if(s==p->data)
    {
     return 1;                                                                                                                                                                                                                                                                                          
    }
    else if(s<p->data)
    {
        return search(p->prev,s);
    }
    else
    {
        return search(p->next,s);
    }
    
}

int main()
{
    int n,val,s;
    struct BSTree *root = NULL;
    printf("Enter total numbers: ");
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        scanf("%d",&val);
        root = insert(root,val);
    }
    inorder(root);
    printf("Enter number to search: ");
    scanf("%d",&s);
   int x= search(root,s);
    if(x==1)
    {
        printf("%d found.",s);
    }
    else
    {
        printf("%d not found.",s);
    }
    
}