#include <stdio.h>
#include <stdlib.h>

struct BTree
{
    int data;
    struct BTree *left;
    struct BTree *right;
};

struct BTree *newtree(int val);
int height(struct BTree *p);
void printGivenLevel(struct BTree *p, int level);


void printLevelOrder(struct BTree *p)
{
    int h=height(p);
    for(int i=1;i<=h;i++)
    {
        printGivenLevel(p,i);
    }
}

void printGivenLevel(struct BTree *p, int level)
{
    if(p==NULL)
    return;
    if(level==1)
    printf("%d ", p->data);
    else if(level > 1)
    {
        printGivenLevel(p->left, level-1);
        printGivenLevel(p->right, level-1);
    }
}

int height(struct BTree *p)
{
    if(p==NULL)
    return 0;
    else
    {
        int lheight = height(p->left);
        int rheight = height(p->right);
        
        if(lheight>rheight)
        return (lheight+1);
        else
        return (rheight+1);
        
    }
    
}

struct BTree *newtree(int val)
{
    struct BTree *p = (struct BTree *)malloc(sizeof(struct BTree));
    p->data=val;
    p->left=NULL;
    p->right=NULL;
    return p;
}

int main()
{
    struct BTree *root = newtree(0);
    root->left = newtree(1);
    root->right = newtree(2);
    root->left->left = newtree(3);
    root->left->right = newtree(4);
    printf("Level order traversal: ");
    printLevelOrder(root);
    return 0;
}