//Binary Search in arrays using recursion

import java.util.*;

class binarySearch_recursion
{
    public static void main(String args[])
    {
        binarySearch_recursion s = new binarySearch_recursion();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.print("Enter values of array: ");
        for(int i=0;i<size;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter value to search: ");
        int num=sc.nextInt();
        int beg=0, end=size-1;
        int index = s.binarySearch(arr,num,beg,end);
        if(index==-1)
        System.out.println("Not found");
        else
        System.out.println("Value found at index: "+ index);

        sc.close();
    }

    int binarySearch(int a[], int num, int beg, int end)
    {
        if(end>=1)
        {
            
        int mid = (beg+end)/2;
        
        if(a[mid]==num)
        return mid;

        if(a[mid]>num)
        return binarySearch(a,num,beg,mid-1);

        else
        return binarySearch(a,num,mid+1,end);
        }
        return -1;
    }
        
}