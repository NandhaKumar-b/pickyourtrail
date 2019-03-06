import java.util.Scanner;

class MergeSort
{
    int splitArray(int arr[],int low,int high)
    {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low ;j<high ;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(int arr[],int low ,int high)
    {
        if(low<high)
        {
            int pivot = splitArray(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }
}


public class UniqueArraySum {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            // Get input for n and arr[n]
            int n = input.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }

            //Quick Sort is used for efficient sorting .
            new MergeSort().sort(arr,0,n-1);

            /*
                Traverse each element and if arr[i] is less than or equal to prevElem , increment it by 1 and add it to sum
                else sum = sum + arr[i] and assign the current element as prevElem

             */
            int sum = arr[0];
            int prevElem = arr[0];

            for (int i = 1; i < n; i++) {
                if (arr[i] <= prevElem) {

                    prevElem = prevElem + 1;
                    sum = sum + prevElem;

                } else {

                    sum = sum + arr[i];
                    prevElem = arr[i];

                }
            }

            System.out.println(sum);
        }
        catch(Exception ex)
        {
            System.out.println("Invalid input is given");
            ex.printStackTrace();
        }


    }
}
