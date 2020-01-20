/*
Insertion
Deletion by index
Deletion by value
Search
*/

import java.util.*;

class array
{
    public static void main(String args[])
    {
        arrayDS m = new arrayDS();
    }
}

class arrayDS
{

    Scanner sc = new Scanner(System.in);
    static int cursize;
    arrayDS()
    {
        System.out.println("Enter array size:");
        int arrsize = sc.nextInt();
        System.out.println("Enter current array size:");
        cursize = sc.nextInt(); 
        int arr[] = new int[arrsize];
        System.out.println("Enter values of array:");
        for(int i=0;i<cursize;i++)
        {
            arr[i]=sc.nextInt();
        }
        int option=0;
        while(option!=5)
        {
        System.out.println("Select following:");
        System.out.println("1: Insertion");
        System.out.println("2: Deletion by index");
        System.out.println("3: Deletion by value");
        System.out.println("4: Search");
        System.out.println("5: Exit");
        
        option = sc.nextInt();
        switch(option) {
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
                exit();
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }
        
    }

    void display(int a[],int csize)
    {
        for(int i=0;i<csize;i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    void insert(int a[])
    {
        System.out.println("You chose insertion.");
        System.out.println("Enter index value:");
        int index = sc.nextInt();
        System.out.println("Enter insertion value:");
        int value = sc.nextInt();
        for(int i=cursize-1;i>=index;i--)
        {
            a[i+1] = a[i];
        }
        a[index]=value;
        display(a,++cursize);

    }
    void deletionIndex(int a[])
    {
        System.out.println("You chose deletion by index.");
        System.out.println("Enter index to delete:");
        int index = sc.nextInt();
        for(int i=index;i<cursize-1;i++)
        {
            a[i]=a[i+1];
        }
        display(a,--cursize);

    }
    void deletionValue(int a[])
    {
        System.out.println("You chose deletion by value.");
        System.out.println("Enter value to delete:");
        int value = sc.nextInt();
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
        System.out.println("You chose search.");
        System.out.println("Enter the value you want to search");
        int sear = sc.nextInt();
        int m=0,s=0;
        for(int i=0;i<cursize;i++)
        {
            if(a[i]==sear)
            {
                m++;
                s=i;
                break;}
        } 
        if(m!=0)
        System.out.println("Your searched value is found. Available at index: "+ s);
        else
        System.out.println("Not found");
    }
    void exit()
    {
        System.out.println("Thank You!");
    }
}