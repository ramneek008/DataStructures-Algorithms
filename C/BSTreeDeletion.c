#include <stdio.h>
#include <stdlib.h>

struct BSTree
{
    int data;
    struct BSTree *left;
    struct BSTree *right;
};

struct BSTree* insert(struct BSTree* p, int val)
{
    struct BSTree *temp = NULL;
    if(p==NULL)
    {
        temp = (struct BSTree*)malloc(sizeof(struct BSTree));
        temp->data=val;
        temp->right=NULL;
        temp->left=NULL;
        p=temp;
    }
    else if(val<p->data)
    {
        p->left=insert(p->left,val);
    }
    else
    {
        p->right=insert(p->right,val);
    }
    return p;    
}

struct BSTree *minValueNode(struct BSTree* p)
{
    struct BSTree *current = p;
    while(current->left!=NULL)
    {
        current=current->left;
    }
    return current;
}

struct BSTree *delete(struct BSTree*p, int val)
{
    if(p==NULL)
    {
        printf("Node not found.");
        return p;
    }

    if(val<p->data)
    {
        p->left=delete(p->left,val);
    }
    else if(val>p->data)
    {
        p->right=delete(p->right,val);
    }
    else
    {
        struct BSTree *temp = NULL;
        if(p->left==NULL && p->right==NULL)
        {
            free(p);
            return NULL;
        }
        else if(p->left==NULL)
        {
            temp=p->right;
            free(p);
            return temp;
        }
        else if(p->right==NULL)
        {
            temp=p->left;
            free(p);
            return temp;
        }
        else
        {
            temp = minValueNode(p->right);
            p->data = temp->data;
            p->right=delete(p->right,temp->data);
            return p;
        }
        

    }
}

void inorder(struct BSTree *root)
{
    if(root!=NULL)
    {
        inorder(root->left);
        printf("%d ",root->data);
        inorder(root->right);
    }
}

int main()
{
    struct BSTree *root = NULL;
    int val,n,d;
    printf("Enter total numbers: ");
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        scanf("%d",&val);
        root = insert(root,val);
    }
    inorder(root);
    printf("enter number to delete: ");
    scanf("%d",&d);
    root = delete(root,d);
    inorder(root);


}