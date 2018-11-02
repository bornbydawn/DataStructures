#include <iostream>

using namespace std;

int ReturnPivotIndex(int *, int, int);
int SearchInPivoted(int *, int, int, int);
int ReturnPivotIndex(int *arr, int startIndex, int endIndex){

    if(startIndex > endIndex)
        return -1;

    if(startIndex == endIndex)
    return startIndex;

    int midIndex = (startIndex + endIndex)/2;

    //cases like 34512
    if(midIndex < endIndex && arr[midIndex] > arr[midIndex + 1])
        return midIndex;

    //cases like 45123
    if(startIndex < midIndex && arr[midIndex] < arr[midIndex - 1])
        return midIndex -1;

    if(arr[startIndex] >= arr[midIndex])
        ReturnPivotIndex(arr, startIndex, midIndex - 1);
    return ReturnPivotIndex(arr, midIndex + 1, endIndex);



}

int SearchInPivoted(int *arr, int startIndex, int endIndex, int key){
/*
1) Find middle point mid = (l + h)/2
2) If key is present at middle point, return mid.
3) Else If arr[l..mid] is sorted
    a) If key to be searched lies in range from arr[l]
       to arr[mid], recur for arr[l..mid].
    b) Else recur for arr[mid+1..r]
4) Else (arr[mid+1..r] must be sorted)
    a) If key to be searched lies in range from arr[mid+1]
       to arr[r], recur for arr[mid+1..r].
    b) Else recur for arr[l..mid]
*/
if(startIndex > endIndex)
    return -1;

    int midIndex = (startIndex + endIndex) / 2;

    if(arr[midIndex] == key)
        return midIndex;

    //if firsthalf is sorted
    if(arr[startIndex] <= arr[midIndex]){
        if(key >= arr[startIndex] && key <= arr[midIndex])
            return SearchInPivoted(arr, startIndex, midIndex -1, key);

        return SearchInPivoted(arr, midIndex + 1, endIndex, key);
    }

    //if the second half is sorted
    if(key >= arr[midIndex] && key <= arr[endIndex])
        return SearchInPivoted(arr, midIndex + 1, endIndex, key);

    return SearchInPivoted(arr, startIndex, midIndex -1, key);
}
int main(){

int arr[] = {3,4,5,1,2};

int sizeOfArray = (sizeof(arr)/ sizeof(arr[0]) - 1);
//returns 2 i.e. index of 5
int pivotIndex = ReturnPivotIndex(arr, 0, sizeOfArray - 1);
cout<<pivotIndex<<endl;

int keyIndex = SearchInPivoted(arr, 0, sizeOfArray - 1, 1);
cout<<keyIndex<<endl;
/*
for (int i = 0; i<5 ; i++){
    cout<<arr[i]<<endl;
}
*/



};
