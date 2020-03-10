#include <stdio.h>
#include <stdlib.h>

struct StackLL
{
    int data;
    struct StackLL* next;
};

struct StackLL* newElement(int data)
{
    struct StackLL* Stack = (struct StackLL*)malloc(sizeof(struct StackLL));
    if(!StackLL)
    {
        printf("Overflow\n");
    } 
    StackLL->data = data;
    StackLL->next = NULL;
    return StackLL;
}

int push(Struct StackLL*)
{

}

int main()
{
    struct StackLL* mainStack = null;
    int temp;
    push(&mainStack,1);
    push(&mainStack,2);
    pop(&mainStack);
    push(&mainStack,3);
    push(&mainStack,4);
    pop(&mainStack);
}