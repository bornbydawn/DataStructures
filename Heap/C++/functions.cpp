#include<iostream>
#include<stdio.h>
#include<stdlib.h>


using namespace std;

#include"main.hpp"

Heap *CreateHeap(int capacity, int heap_type){

Heap *heap = (Heap *)malloc(sizeof(struct Heap));

if(heap == NULL){
    cout<<"Memory allocation error"<<endl;
    return NULL;
}

heap->heap_type = heap_type;
heap->capacity = capacity;
heap->arr = (int *)malloc(sizeof(int) * heap ->capacity);

if(heap -> arr == NULL){
    cout<<"Memory allocation error"<<endl;
    return NULL;
}
return heap;
}

void MinHeapify(Heap *h, int i){

int leftChild = LeftChild(h, i);
int rightChild = RightChild(h, i);

int smallest = i;

if(leftChild < (h)->count && (h)->arr[leftChild] < (h)->arr[smallest]){

    smallest = leftChild;
}

if(rightChild <(h)->count && (h)->arr[rightChild] < (h)->arr[smallest]){

    smallest = rightChild;
}

if(smallest != i){

    SwapData(&h, i, smallest);

    MinHeapify(h, smallest);
}
}

void MaxHeapify(Heap *h, int i){

int leftChild = LeftChild(h, i);
int rightChild = RightChild(h, i);

int largest = i;

if(leftChild != -1 && leftChild < (h)->count && (h)->arr[leftChild] > (h)->arr[largest]){

    largest = leftChild;
}

if(rightChild != -1 && rightChild <(h)->count && (h)->arr[rightChild] > (h)->arr[largest]){

    largest = rightChild;
}

if(largest != i){

    SwapData(&h, i, largest);

    MaxHeapify(h, largest);
}
}

Heap * MinHeapFromArray(int *arr, int sizeOfArray){

Heap *h = CreateHeap(sizeOfArray, 2);

for(int i = 0; i < sizeOfArray; i++){

    InsertMinHeap(h, arr[i]);
}
return h;
}

void SwapData(Heap **h, int i, int j){

int temp = (*h)->arr[i];
(*h)->arr[i] = (*h)->arr[j];
(*h)->arr[j] = temp;

}

int Parent(Heap *h, int i){

if(i <= 0 || i >= h->count){
    return -1;
}
return (i-1)/2;
}

int LeftChild(Heap *h, int i){

int left = 2*i + 1;
if(left >= h->count){
    return -1;
}
return left;
}

int RightChild(Heap *h, int i){

int right = 2*i + 2;
if(right >= h->count){
    return -1;
}
return right;
}

void InsertMinHeap(Heap *h, int val){

if(h->capacity == h->count){
    cout<<"Heap Overflow"<<endl;
}

h->count++;
int i = h->count - 1;
h->arr[i] = val;

 while(i != 0 and h->arr[i] < h->arr[Parent(h, i)]){
    SwapData(&h, i, Parent(h, i));
    i = Parent(h,i);
 }

}

int ExtractMin(Heap *h){

if(h->count <= 0){
    return INT_MAX;
}

if(h->count == 1){
    h->count--;
    return h->arr[0];
}

int returnValue = h->arr[0];
h->arr[0] = h->arr[h->count-1];
h->count--;
MinHeapify(h, 0);

return returnValue;
}

int GetMinimum(Heap *h){
if(h->count == 0){
    return -1;
}
return h->arr[0];
}

int GetMaximum(Heap *h){
if(h->count == 0){
    return -1;
}
return h->arr[0];
}

void HeapSort(int *arr, int n){

Heap *h = BuildHeap(arr, n);

int oldHeapSize = h->count;

//run n-2 times
for(int i = n-1 ; i>0 ; i--){

    arr[i] = h->arr[0];
    h->arr[0] = h->arr[i];
    h->count -= 1;
    MaxHeapify(h, 0);

}

h->count = oldHeapSize;

}

Heap* BuildHeap(int *arr, int n){

Heap *h = CreateHeap(n, 1);

for(int i = 0; i< n; i++){
    h->arr[i] = arr[i];
}

h->count = n;

for(int i = (n-1)/2 ; i >=0 ; i--){
    MaxHeapify(h, i);
}

return h;
}
