import java.util.ArrayList;

class MergeSort{


    public static void mergesort(int arr[], int low, int high){

       
        if(low < high){
            int mid = low + (high-low)/2;

            mergesort(arr, low, mid);

            mergesort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }


    public static void merge(int arr[], int low, int mid, int high){

        int firstHalfLength = mid - low + 1;
        int secondHalfLength = high - mid;

        int arrLeft[] = new int[firstHalfLength];

        int arrRight[] = new int[secondHalfLength];

        for(int i = 0; i < firstHalfLength; i++) arrLeft[i] = arr[low + i];

        for(int i =0; i < secondHalfLength; i++) arrRight[i] = arr[mid + 1 + i];

        int firstArrayTracker = 0; int secondArrayTracker = 0;
        int mainArrayTracker = low;

        while(firstArrayTracker < firstHalfLength && secondArrayTracker < secondHalfLength){
            if(arrLeft[firstArrayTracker] <= arrRight[secondArrayTracker])
                arr[mainArrayTracker++] = arrLeft[firstArrayTracker++];

            else arr[mainArrayTracker++] = arrRight[secondArrayTracker++];
        }

        while(firstArrayTracker < firstHalfLength){
            arr[mainArrayTracker++] = arrLeft[firstArrayTracker++];

        }

        while(secondArrayTracker < secondHalfLength){
            arr[mainArrayTracker++] = arrRight[secondArrayTracker++];
        }
        
    }

    public static void main(String[] args) {
        int arr[] = {342,46,562,23,234,656,35,324,23,4324,3422,324,32432,4234324,32432,4324324};

        mergesort(arr, 0, arr.length - 1);

        for (int var : arr) {
            System.out.println(var);
            
        }
    }
}