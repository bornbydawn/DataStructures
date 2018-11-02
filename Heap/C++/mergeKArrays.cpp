#include<iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;

#define n 4


typedef struct MinHeapNode
{
    int element; // The element to be stored
    int i; // index of the array from which the element is taken
    int j; // index of the next element to be picked from array
} MinHeapNode;


class MinHeap
{

    MinHeapNode *arr;
    int heapSize;

public:

    MinHeap(MinHeapNode *a, int size)
    {

        heapSize = size;

        arr = a;

        int i = (heapSize - 1)/2;

        while (i >= 0)
        {

            MinHeapify(i);
            i--;
        }
    }


    void MinHeapify(int i)
    {

        int l = left(i);
        int r = right(i);

        int smallest = i;

        if(l < heapSize && arr[l].element < arr[i].element)
        {
            smallest = l;
        }
        if(r < heapSize && arr[r].element < arr[smallest].element)
        {

            smallest = r;
        }

        if(smallest != i)
        {

            swap(&arr[i], &arr[smallest]);
            MinHeapify(smallest);

        }


    }

    void swap(MinHeapNode *x, MinHeapNode *y)
    {
        MinHeapNode temp = *x;
        *x = *y;
        *y = temp;
    }

    // to get index of left child of node at index i
    int left(int i)
    {
        return (2*i + 1);
    }

    // to get index of right child of node at index i
    int right(int i)
    {
        return (2*i + 2);
    }

    // to get the root
    MinHeapNode getMin()
    {
        return arr[0];
    }

    void replaceMin(MinHeapNode x)
    {
        arr[0] = x;
        MinHeapify(0);
    }
};

int *mergeKArrays(int **, int);

int *mergeKArrays(int arr[][n], int k)
{

    int *output = new int[n*k];

    MinHeapNode *heapArray = new MinHeapNode[k];

    for(int i = 0; i<k; i++)
    {
        heapArray[i].element = arr[i][0];
        heapArray[i].i = i;
        heapArray[i].j = 1;
    }

    MinHeap mh(heapArray, k);

    for(int count = 0 ; count < n*k ; count++)
    {

        MinHeapNode root = mh.getMin();
        output[count] = root.element;

        if(root.j < n)
        {
            root.element = arr[root.i][root.j];
            root.j += 1;

        }
        else
        {
            root.element = INT_MAX;
        }

        mh.replaceMin(root);

    }

    return output;

}

void printArray(int arr[], int size)
{
    for (int i=0; i < size; i++)
        cout << arr[i] << " ";
}

int main()
{
    // Change n at the top to change number of elements
    // in an array
    int arr[][n] =  {{2, 6, 12, 34},
        {1, 9, 20, 1000},
        {23, 34, 90, 2000}
    };
    int k = sizeof(arr)/sizeof(arr[0]);

    int *output = mergeKArrays(arr, k);

    cout << "Merged array is " << endl;
    printArray(output, n*k);

    return 0;
}
