//Ternary Search in arrays


import java.util.*;

class ternarySearch
{
    public static void main(String args[])
    {
        ternarySearch t = new ternarySearch();
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
        int index = t.terSearch(arr, num);
        if(index==-1)
        System.out.println("Not found");
        else
        System.out.println("Value found at index: "+ index);
        sc.close();
    }

    int terSearch(int a[], int num)
    {
        int beg = 0;
        int end=a.length;
        while(beg<=end)
        {
        int mid1 = beg + (end-beg)/3;
        int mid2 = end - (end-beg)/3;
        if(a[mid1]==num)
        return mid1;
        if(a[mid2]==num)
        return mid2;

        if(a[mid1]>num)
        end=mid1-1;
        else if(a[mid2]<num)
        beg=mid2+1;
        else
        {
            beg=mid1+1;
            end=mid1-1;
        }
    }
    return -1;
    }
}