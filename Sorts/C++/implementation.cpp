#include<iostream>
#include<stdlib.h>
#include "header.hpp"

using namespace std;
//moves the largest element to the end of the list
//moves all the elements
void BubbleSort(int *arr, int n){

int temp = 0, swapped = 1, done = 1;

for(done; done < n && swapped; done ++){

   for(int i = 0 ; i< n-done ; i ++){
    swapped = 0;
    if(arr[i] > arr[i+1]){
        temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        swapped = 1;
    }
   }
}
cout<<"Exiting after "<<done<<" iterations out of maximum "<<n-1<<" iterations"<<endl;
}

//selects the least value and moves it to the front
//only moves the required element
void SelectionSort(int *arr, int n){
int min, temp;

for(int i = 0; i < n -1 ; i++){
    min = i;
    for(int j = i + 1; j < n; j++){
        if(arr[j] < arr[min]){
            min = j;
        }
    }
    if(min != i){
        temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;

    }
}
}

//repeatedly constructs sorted array
//moves all elements
// <=x x >=x pattern
void InsertionSort(int *arr, int n){

int currentPivot, backMover, currentValue;

for(int currentPivot = 1; currentPivot< n ; currentPivot++){

    currentValue = arr[currentPivot];
    backMover = currentPivot;

    while(arr[backMover -1] > currentValue && backMover > 0){
        arr[backMover] = arr[backMover -1];
        backMover --;
    }
    arr[backMover] = currentValue;

}

}

void MergeSort(int *arr, int left, int right){

int mid;
static int firstCall = 1;
static int * temp = NULL;


if(firstCall == 1){
const static int arrSize = right - left + 1;
temp = new int[arrSize];
firstCall ++;
}


if(right>left){
    mid = (left+right)/2;
    MergeSort(arr,left,mid);
    MergeSort(arr,mid+1,right);
    Merge(arr, temp, left,mid + 1 ,right);
}

}

void Merge(int *arr, int *temp, int left, int mid, int right){

    int left_end = mid - 1;
    int temp_pos = left;
    int batch_size = right - left + 1;

    while((left <= left_end) && (mid <= right)){
        if(arr[left] <= arr[mid]){
            temp[temp_pos] = arr[left];
            left++;
        }
        else{
            temp[temp_pos] = arr[mid];
            mid++;
        }
        temp_pos++;
    }
    while(left <= left_end){
        temp[temp_pos] = arr[left];
        temp_pos++;left++;
    }
    while(mid <= right){
        temp[temp_pos] = arr[mid];
        temp_pos++;mid++;
    }

    for(int i = 0; i < batch_size; i++){
        arr[right] = temp[right];
        right--;
    }
}




