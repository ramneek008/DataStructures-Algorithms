#include <stdio.h>
#include <stdlib.h>

struct BSTree
{
    int data;
    struct BSTree *next;
    struct BSTree *prev;
};

struct BSTree* insert(struct BSTree* p,int val)
{
    struct BSTree* temp;
    if(p==NULL)
    {
        temp = (struct BSTree*)malloc(sizeof(struct BSTree));
        temp->data = val;
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

void inorder(struct BSTree* root)
{
    if(root!=NULL)
    {
        inorder(root->prev);
        printf("%d ",root->data);
        inorder(root->next);
    }
}

void preorder(struct BSTree* root)
{
    if(root!=NULL)
    {
        
        printf("%d ",root->data);
        preorder(root->prev);
        preorder(root->next);
        
    }
}

void postorder(struct BSTree* root)
{
    if(root!=NULL)
    {
        postorder(root->prev);
        postorder(root->next);
        printf("%d ",root->data);
        
    }
}


int main()
{
    struct BSTree* root = NULL;
    root = insert(root,15);
    root = insert(root,8);
    root = insert(root,18);
    root = insert(root,48);
    printf("Inorder: ");
    inorder(root);
    printf("\nPreorder: ");
    preorder(root);
    printf("\nPostorder: ");
    postorder(root);
}

