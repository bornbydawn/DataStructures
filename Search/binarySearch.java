import java.util.ArrayList;

class binarySearch{

    public static int bSearch(int arr[], int toFind){

    if(arr.length == 0)
    return -1;

    int sizeOfArray = arr.length;

    int startIndex = 0;
    int endIndex = sizeOfArray - 1;
    int mid = startIndex +(endIndex-startIndex)/2;


    while(startIndex <= mid && toFind <= arr[endIndex] && toFind >= arr[startIndex]){

        if(arr[mid] == toFind)
        return mid;

        else if(arr[mid] < toFind)
        {
            
            startIndex = mid + 1;
            mid = startIndex + (endIndex - startIndex)/2;
        }
        else{
            endIndex = mid - 1;
            mid = startIndex + (endIndex - startIndex)/2;
        }
        
    }

    return -1;
    }


    public static void main(String[] args){

        int[] arr = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21,
            34, 55, 89, 144, 233, 377, 610};

            System.out.println(bSearch(arr, 108));

    }
}