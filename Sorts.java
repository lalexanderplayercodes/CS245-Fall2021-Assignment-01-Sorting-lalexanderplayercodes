import java.util.*;
import java.util.concurrent.TimeUnit;


public class Sorts {

    static void selectionSort(int arr[])
    {
        int n = arr.length;
        // loop to move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // loop to find min. element of array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // switch the found min. element with first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;

        }
    }



    static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int open = arr[i];
            int j = i - 1;

            //  Elements of arr[0..i-1], > than open, to 1pos ahead
            // of their current position
            while (j >= 0 && arr[j] > open) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = open;
        }
    }




    static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }

    }


    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {

            // partin is partition index, arr[p]
            // is now at right place
            int partin = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, partin - 1);
            quickSort(arr, partin + 1, high);
        }
    }







    // Merges two subarrays of arr. first subarray is arr[x,y] second subarray is arr [y+1, z}
    static void merge(int arr[], int x, int y, int z)
    {
        // Find sizes of two subarrays to be merged
        int n1 = y - x + 1;
        int n2 = z - y;

        /* creating temp arrays */
        int firsttemp[] = new int[n1];
        int nexttemp[] = new int[n2];

        // copy arr ints to temp arrays //
        for (int i = 0; i < n1; ++i)
            firsttemp[i] = arr[x + i];
        for (int j = 0; j < n2; ++j)
            nexttemp[j] = arr[y + 1 + j];

        // merge the temp arrays //
        // initial index of first and second subarrays
        int i = 0, j = 0;

        // initial index of merged subarray
        int k = x;
        while (i < n1 && j < n2) {
            if (firsttemp[i] <= nexttemp[j]) {
                arr[k] = firsttemp[i];
                i++;
            }
            else {
                arr[k] = nexttemp[j];
                j++;
            }
            k++;
        }
        // copy rem. elem. of firsttemp[] //
        while (i < n1) {
            arr[k] = firsttemp[i];
            i++;
            k++;
        }
        // copy rem. elem. of R[] //
        while (j < n2) {
            arr[k] = nexttemp[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int x, int z) {
        if (x < z) {
            // to find the mid. point
            int m = x + (z - x) / 2;

            // recursive func. that sorts first and second portions
            mergeSort(arr, x, m);
            mergeSort(arr, m + 1, z);

            // Merge the sorted portions
            merge(arr, x, m, z);
        }
    }



    // function to swap elements of arr
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // function to print each elem. of array
    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }




    // function to take elem. of pivot and move it to correct position in sorted array. move
    // pivot elements smaller than pivot to the left and elements greater than pivot
    // to right
    static int partition(int[] arr, int low, int high)
    {
        // create the pivot
        int pivot = arr[high];
        // index of smaller element and gets right pos. of found pivot
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            // If current element is smaller than pivot
            if (arr[j] < pivot)
            {
                // increase index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }



    public static void main(String[] args) throws InterruptedException {

        int arr[] = new int[100000];

        for(int i=0;i<100000;++i) {
            arr[i] = (int) (Math.random()*10000);
        }

        // all below occurrences will find difference from start time to end time and print
        int num = 100000;
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Bubble Sort running time in milliseconds: " + timeElapsed);

        for(int i=0;i<100000;++i) {
            arr[i] = (int) (Math.random()*10000);
        }

        startTime = System.currentTimeMillis();
        selectionSort(arr);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Selection Sort running time in milliseconds: " + timeElapsed);

        for(int i=0;i<100000;++i) {
            arr[i] = (int) (Math.random()*10000);
        }

        startTime = System.currentTimeMillis();
        insertionSort(arr);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Insertion Sort running time in milliseconds: " + timeElapsed);

        for(int i=0;i<100000;++i) {
            arr[i] = (int) (Math.random()*10000);
        }

        startTime = System.currentTimeMillis();
        quickSort(arr,0,num-1);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Quick Sort running time in milliseconds: " + timeElapsed);

        for(int i=0;i<100000;++i) {
            arr[i] = (int) (Math.random()*10000);
        }

        startTime = System.currentTimeMillis();
        mergeSort(arr,0,num-1);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Merge Sort running time in milliseconds: " + timeElapsed);





    }
}







