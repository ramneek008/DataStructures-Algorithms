import java.util.*;

class binarySearch 
{
    public static void main(String args[])
    {
        binarySearch s = new binarySearch();
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
        int index = s.binSearch(arr, num);
        if(index==-1)
        System.out.print("Not found");
        else
        System.out.println("Value found at index: "+ index);
        
    }

    int binSearch(int a[], int num)
    {
        int beg = 0;
        int end = a.length - 1;
        
        while(beg<=end)
        {
         int mid = (beg+end)/2;
        if(a[mid]==num)
        return mid;

        if(a[mid]<num)
        {
            beg=mid+1;
        }
        else
        {
            end=mid-1;
        }
        }
        return -1;
    }
}
