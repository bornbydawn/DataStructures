import java.util.ArrayList;

class jumpSearch{

    public static int jSearch(int arr[], int toFind){

    if(arr.length == 0)
    return -1;

    int sizeOfArray = arr.length;

    int jumpSize = (int)Math.floor(Math.sqrt(sizeOfArray));
    
    int i = 0;

    while(arr[i + jumpSize] < toFind){

        i += jumpSize;

        if(i > sizeOfArray - 1)
        return 0;
    }

    while(arr[i] != toFind && i < sizeOfArray - 1)
    {
        i++;
        if(arr[i] == toFind)
        return i;
    }
    return -1;
    }


    public static void main(String[] args){

        int[] arr = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21,
            34, 55, 89, 144, 233, 377, 610};

            System.out.println(jSearch(arr, 55));

    }
}



// Important points:
// Works only sorted arrays.
// The optimal size of a block to be jumped is O(√ n). This makes the time complexity of Jump Search O(√ n).
// The time complexity of Jump Search is between Linear Search ( ( O(n) ) and Binary Search ( O (Log n) ).
// Binary Search is better than Jump Search, but Jump search has an advantage that we traverse back only once (Binary Search may require up to O(Log n) jumps, consider a situation where the element to be search is the smallest element or smaller than the smallest).
// So in a systems where jumping back is costly, we use Jump Search.