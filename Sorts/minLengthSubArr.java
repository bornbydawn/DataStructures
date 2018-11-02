import java.util.*;
import javafx.util.Pair;

// class MinLengthSubArray{

//     public static ArrayList<Pair<Integer, Integer>> getMinLengthSubArr(int arr[]){

//         ArrayList<Pair<Integer, Integer>> minIndexPairs = new ArrayList();

//         int arrCopy[] = arr.clone();

//         for(int i = 0; i < arr.length - 1; i++)
//         {
//             for(int j = 1; j < arr.length ; j++ ){
//                 sortSubArray(arrCopy, i, j);

//                 if(checkIfSorted(arrCopy)){
//                     minIndexPairs.add(new Pair(i,j));
//                 }
//                 arrCopy = arr.clone();
//             }
//         }
// 		return minIndexPairs;
//     }

//     public static void sortSubArray(int arr[], int startIndex, int endIndex){

//         int temp;
//         for(int i = startIndex; i < endIndex; i++){
//             for(int j = startIndex; j < endIndex ; j++){
//                 if(arr[j] > arr[j + 1])
//                 {
//                     temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                 }

//             }
//         }
//     }

//     public static boolean checkIfSorted(int arr[]){

//         for(int i = 0; i < arr.length - 1 ; i++){
//             if(arr[i] > arr[i+1])
//             return false;
//         }

//         return true;
//     }

//     public static void main(String[] args) {

//         int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50};            //{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}; 
//         ArrayList<Pair<Integer, Integer>> minIndexPairs = getMinLengthSubArr(arr);
//         int minDistance = arr.length;
//         int distance;
//         int firstIndex = 0;
//         int lastIndex = arr.length - 1;
//         for (Pair<Integer,Integer> var : minIndexPairs) {
//             distance = var.getValue() - var.getKey();
//             if(distance < minDistance){
//                 minDistance = distance;
//                 firstIndex = var.getKey();
//                 lastIndex = var.getValue();
//             }
//         }

//         System.out.println("start: " + firstIndex + ", end: " + lastIndex);
//     }
// }

class MinLengthSubArray {

    public static Pair<Integer, Integer> GetMinLengthSubArrayIndices(int arr[]) {

        int arrLength = arr.length;

        // if (arrLength == 0)
        //     return -1;
        // if (arrLength == 1)
        //     return 0;

        int startIndex = 0;
        int endIndex = arrLength - 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int finalStartIndex = 0;
        int finalEndIndex = 0;

        // find the first element that breaks the increasing order
        for (int i = 0; i < arrLength; i++) {

            if (arr[i + 1] < arr[i]) {
                startIndex = i;
                break;
            }

        }
        if(startIndex == arrLength - 1) return new Pair<Integer,Integer>(0, 0);
        System.out.println(startIndex);

        // find the first element that breaks the decreasing order
        for (int i = arrLength - 2; i >= 0; i--) {

            if (arr[i + 1] < arr[i]) {
                endIndex = i + 1;
                break;
            }

        }

        System.out.println(endIndex);
        // find the min and max in this subarray created from startIndex and endIndex
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] < min)
                min = arr[i];

            if (max < arr[i])
                max = arr[i];
        }

        // change the start and end index if in the array any element exists that is
        // less than or greater than values at these indices


        finalStartIndex = startIndex;
        for (int i = 0; i < startIndex; i++) {
            if (min < arr[i])
            {
                finalStartIndex = i;
                min = arr[i];
                break;
            }
            
            
        }

        finalEndIndex = endIndex;

        for (int i = arrLength - 1; i > endIndex; i--) {

            if (max > arr[i])
            {
                finalEndIndex = i;
                max = i;
                break;
            }
                
        }        

        return new Pair<Integer, Integer>(finalStartIndex, finalEndIndex);

    }

    public static void main(String[] args) {


        int[] arr = {5, 7, 9, 13, 16, 12, 15, 8, 14, 18, 17, 20};//{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}; //{0, 1, 15, 25, 6, 7, 30, 40, 50};            //
        System.out.println(GetMinLengthSubArrayIndices(arr).toString());
    }
}