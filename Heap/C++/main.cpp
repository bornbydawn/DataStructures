#include"main.hpp"
using namespace std;


#include<iostream>
#include<stdio.h>
#include<stdlib.h>


int main(){

 //Heap *h = NULL;
 //= CreateHeap(10,1);
 int arr[] = {1, 23, 12, 9, 30, 2, 50};
 int size = (sizeof(arr)/sizeof(arr[0]));
 /*
 int k = 3;
 Heap *h = MinHeapFromArray(arr, k);

 for(int i = 3; i< (sizeof(arr)/sizeof(arr[0])); i++){
    if(GetMaximum(h) < arr[i]){

        h->arr[0] = arr[i];
        MinHeapify(h, 0);
    }
 }

 for(int j = 0; j < k; j++){
    cout<<j<<"   "<<ExtractMin(h)<<endl;
 }
*/
HeapSort(arr, size);
for(int i = 0; i<size; i++){
cout<<arr[i]<<endl;
}
 return 0;
}
