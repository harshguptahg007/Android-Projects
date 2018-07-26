package com.example.android.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.android.services.Fragments.FragmentA;

import java.util.ArrayList;

public class MyService extends Service {

    private final IBinder mBinder = new LocalService();
    private ArrayList<Integer> quickSort = new ArrayList<>();
    private ArrayList<Integer> mergeSort = new ArrayList<>();
    private ArrayList<Integer> table = new ArrayList<>();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalService extends Binder
    {
        public MyService getService()
        {
            return MyService.this;
        }
    }


    public ArrayList<Integer> getQuickSortResult(){

        quickSortMethod();
        //Log.i("getSorted",sortedNumbers.size()+"");
        return quickSort;
    }



    /* This function takes last element as pivot, places the pivot element at its correct position
    in sorted array, and places all smaller (smaller than pivot) to left of pivot and all
    greater elements to right of pivot */
    private int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort() arr[] --> Array to be sorted,
    low  --> Starting index, high  --> Ending index */
    private void qsort(int arr[], int low, int high)
    {
        if (low < high)
        {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            qsort(arr, low, pi-1);
            qsort(arr, pi+1, high);
        }
    }

    // Driver program
    private void quickSortMethod() {

        ArrayList<Integer> numbers = FragmentA.numbers;
        int arr[] = new int[numbers.size()];

        for(int i=0;i<numbers.size();i++)
        {
            arr[i]=numbers.get(i);
        }

        //int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        MyService ob = new MyService();
        ob.qsort(arr, 0, n - 1);

        for (int i = 0; i < n; ++i) {

            quickSort.add(arr[i]);
        }


    }



    /* Java program for Merge Sort */

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using merge()
    private void msort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            msort(arr, l, m);
            msort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Driver method
    private void mergeSortMethod()
    {
        ArrayList<Integer> numbers = FragmentA.numbers;
        int arr[] = new int[numbers.size()];

        for(int i=0;i<numbers.size();i++)
        {
            arr[i]=numbers.get(i);
        }

        int n=arr.length;

        MyService ob = new MyService();
        ob.msort(arr, 0, arr.length-1);

        for (int i = 0; i < n; ++i) {

            mergeSort.add(arr[i]);
        }
    }

    public ArrayList<Integer> getMergeSortResult(){

        mergeSortMethod();
        //Log.i("getSorted",sortedNumbers.size()+"");
        return mergeSort;
    }


    private void tableGeneration()
    {
        int n = MainActivity.data;

        for (int i=1;i<=10;i++)
        {
            table.add(n*i);
        }
    }

    public ArrayList<Integer> getTableResult()
    {
        tableGeneration();
        return table;
    }
}
