#include <stdio.h>
#include <stdlib.h>

struct Tree
{
    int data;
    struct Tree *child1;
    struct Tree *child2;
    struct Tree *child3;
};

struct Tree *newTree(int val)
{
    struct Tree *p = (struct Tree*)malloc(sizeof(struct Tree)); 
    p->data=val;
    p->child1=NULL;
    p->child2=NULL;
    p->child3=NULL;
    return p;
}

int main()
{
    struct Tree *root = newTree(0);
    root->child1 = newTree(1);
    root->child2 = newTree(2);
    root->child3 = newTree(3);
    printf("Root Node: %d\n", root->data);
    printf("Child1: %d\n", root->child1->data);
    printf("Child2: %d\n", root->child2->data);
    printf("Child3: %d\n", root->child3->data);
}