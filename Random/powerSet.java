import java.util.*;

class PowerSet{

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};
        printPowerSet(arr);

    }


    private static void printPowerSet(int arr[]){
        
        //int setLength = Math.pow(2, arr.length);

        for(int i = 0; i < 1<<arr.length; i++){

            System.out.print("{");
            for(int j = 0; j < arr.length; j++){
                
                if((i & (1 << j)) > 0){
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
            //System.out.println();
        }
    }
}