/*
Insertion
Deletion by index
Deletion by value
Search
*/

#include <stdio.h>

void menu();
void insert();
void deletionIndex();
void deletionValue();
void search();
void exitprog();

int main()
{
    menu();
    return 0;
}
static int cursize;
void menu()
{
    int arrsize;
    printf("Enter array size: ");
    scanf("%d",&arrsize);
    printf("Enter current array size: ");
    scanf("%d",&cursize);
    int arr[cursize];
    printf("Enter values of array: ");
    for(int i=0;i<cursize;i++)
    {
        scanf("%d",&arr[i]);
    }
    int option=0;
    while(option!=5)
    {
    printf("Select following:\n1: Insertion\n2: Deletion by index\n3: Deletion by value\n4: Search\n5: exit\n To terminate press 5\n");
    scanf("%d",&option);
    switch(option){
        case 1: 
            insert(arr);
            break;
        case 2: 
            deletionIndex(arr);
            break;
        case 3: 
            deletionValue(arr);
            break;
        case 4: 
            search(arr);
            break;
        case 5: 
            exitprog();
            break;   
        default:
            printf("Invalid"); 
            break;
    }
    }
}

void display(int a[],int csize)
{
    for(int i=0;i<csize;i++)
    {
        printf("%d ",a[i]);
    }
    printf("\n");
}

void insert(int a[])
{
    printf("You chose insertion.\n");
    int index,value;
    printf("Enter index value: ");
    scanf("%d",&index);
    printf("Enter insertion value: ");
    scanf("%d",&value);
    for(int i=cursize-1;i>=index;i--)
    {
        a[i+1]=a[i];
    }
    a[index]=value;
    display(a,++cursize);
}

void deletionIndex(int a[])
{
    printf("You chose deletion by index.\n"); 
    int index;
    printf("Enter index value: ");
    scanf("%d",&index);
    for(int i=index;i<cursize-1;i++)
    {
        a[i]=a[i+1];
    }  
    display(a,--cursize);
}

void deletionValue(int a[])
{
    printf("You chose deletion by value.\n");
    printf("Enter value to delete:");
    int value;
    printf("%d",value);
    int s=0;
    for(int i=0;i<cursize;i++)
        {
            if(a[i]==value)
            {
                s=i;
                break;
            }
        }
    int index= s;
    for(int i=index;i<cursize-1;i++)
        {
            a[i]=a[i+1];
        }
    display(a,--cursize);
}

void search(int a[])
{
    printf("You chose search.\n");
    printf("Enter the value you want to search: ");
    int sear;
    scanf("%d",&sear);
    int m=0,s=0;
    for(int i=0;i<cursize;i++)
    {
        if(a[i]==sear)
        {
            m++;
            s=i;
            break;
        }
    } 
    if(m!=0)
        printf("Your searched value is found. Available at index: %d\n",s);
    else
        printf("Not found\n");    
}

void exitprog()
{
    printf("Thank You!");
}