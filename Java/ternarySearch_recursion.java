import java.util.*;

class ternarySearch_recursion
{
    public static void main(String args[])
    {
        ternarySearch_recursion t = new ternarySearch_recursion();
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
        int beg = 0;
        int end=size-1;
        int index = t.ternarySearch(arr, num, beg, end);
        if(index==-1)
        System.out.println("Not found");
        else
        System.out.println("Value found at index: "+ index);
    }

    int ternarySearch(int a[], int num, int beg, int end)
    {
        
        if(beg<=end)
        {
        int mid1 = beg + (end-beg)/3;
        int mid2 = end - (end-beg)/3;
        if(a[mid1]==num)
        return mid1;
        if(a[mid2]==num)
        return mid2;

        if(a[mid1]>num)
        return ternarySearch(a, num, beg, mid1-1);
        else if(a[mid2]<num)
        return ternarySearch(a,num,mid2+1,end);
        else
        return ternarySearch(a, num, mid1+1, mid2-1);
    }
    return -1;
    }
}