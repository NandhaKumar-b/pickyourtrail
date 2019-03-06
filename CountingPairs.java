import java.util.Scanner;

class MergeSort
{
    int splitArray(long arr[],int low,int high)
    {
        long pivot = arr[high];
        int i = low - 1;
        for(int j = low ;j<high ;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        long temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(long arr[],int low ,int high)
    {
        if(low<high)
        {
            int pivot = splitArray(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }
}

public class CountingPairs {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            // Get input for n and arr[n] (long is used for arr[] since it ranges upto 10^9)
            int n = input.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = input.nextLong();
            }

            long k = input.nextLong();

            //Quick Sort is used for efficient sorting .
            new MergeSort().sort(arr,0,n-1);

            //Removing the duplicate elements in the arr[]
            int j= 0;
            for(int i=0; i<n-1 ; i++)
            {
                if(arr[i] != arr[i+1]) {
                    arr[j] = arr[i];
                    j++;
                }
            }
            arr[j] = arr[n-1];

            /*
                left and right points to the first element , if arr[right] - arr[left] equals to k , increment both
                else arr[right] - arr[left] is greater than k increment left else increment right
             */
            int left=0,right=0,count=0;

            while(right <= j)
            {
                if(arr[right] - arr[left] == k)
                {
                    count++;
                    left++;
                    right++;
                }
                else if(arr[right] - arr[left] > k)
                    left++;
                else
                    right++;
            }

            System.out.println(count);

        }
        catch(Exception ex)
        {
            System.out.println("Invalid input is given");
            ex.printStackTrace();
        }


    }
}


