#include<iostream>

using namespace std;
#include "header.hpp"



int main(){

int arr[] = {23,4,12,465,234,21,41,341,445,121,4356,45,112,34,67,864,86};
int sizeofArr = sizeof(arr)/sizeof(arr[0]);
int temp[sizeofArr] = {0};
MergeSort(arr,0,sizeofArr-1);

for(int i = 0; i<sizeofArr; i++){
    cout<<arr[i]<<endl;
}
}
