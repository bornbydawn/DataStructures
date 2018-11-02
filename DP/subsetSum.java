
import java.io.*;
import java.util.*;

class Main {

    public static boolean[][] dp;

        static boolean checkIfSubsetOfSum(int[] arr, int sum) {

            dp = new boolean[arr.length + 1][sum + 1];
    
            //the result will be always true for sum 0
            for(int i = 0; i <= arr.length; i++) dp[i][0] = true;
    
            for (int i = 1; i <= arr.length; i++) {
                for (int j = 1; j <= sum; j++) {

                    if(arr[i - 1] > j) dp[i][j] = dp[i-1][j];
                    else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i - 1]];
                    }
                }
            }
    
           return dp[arr.length - 1][sum];
        }

        static int getMinimumDifferenceInSubsetSums(int[] arr){
            int sum = 0;
            for (int var : arr) {
                sum += var;
            }

            dp=new boolean[arr.length + 1][sum + 1];

            for(int i = 0; i < arr.length; i++) dp[i][0] = true;

            for(int i = 1; i <= arr.length; i++){
                for(int j = 1; j <= sum; j++){
                    if(j < arr[i - 1]) dp[i][j] = dp[i -1][j];
                    else{
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    }
                }
            }

            int minDifference = Integer.MAX_VALUE;
            for(int i = sum/2 ; i>=0 ; i--){
                if(dp[arr.length][i] == true){
                    //not sum/2 - i since if sum is odd, then division of it by two will lead to loss of one precision
                    minDifference = sum - 2*i;
                    break;
                }
            }

            return minDifference;
        }

        static void printSubsets(int arr[], int i, int sum, ArrayList<Integer> p){

            if(i == 0 && sum != 0 && dp[0][sum]){
                p.add(arr[i]);
                p.forEach(System.out::println);
                System.out.println();
                p.clear();
                return;
            }

            if(i == 0 && sum == 0){
                p.forEach(System.out::println);
                System.out.println();
                p.clear();
                return;
            }

            //this is actually where the branching is happening for this case since we initialize a new arraylist for cases
            //where we have a subset possible without this value also. if there is a different subset with this value also
            //then the next if block will handle it
            if(dp[i - 1][sum]){

                ArrayList<Integer> b = new ArrayList<>();
                //this is crucial, don't forget
                b.addAll(p);

                printSubsets(arr, i - 1, sum, b);

            }

            //if the current element is less than or equal to the sum left
            //and if we consider this element, the remaining sum can be handled in the remaining set
            if(sum >= arr[i] && dp[i - 1][sum - arr[i]]){
                p.add(arr[i]);
                printSubsets(arr, i - 1, sum - arr[i], p);
            }
        }

    public static void main(String[] args) {

        //int[] x = {8,32,12,16,4};
        //int[] set = {10, 5, 3, 15, 20};

        //int set[] = { 3, 1, 5, 9, 16 };
        
        //int[] set = {3, 34, 4, 12, 5, 2};
        //Arrays.sort(set);
        
        //int sum = 9;
        //int sum = 17;

        //int i = set.length; int j = sum;

        
        //boolean result = checkIfSubsetOfSum(set, sum);

        int set[] = {3, 1, 4, 2, 2, 1};
        int result = getMinimumDifferenceInSubsetSums(set);
        System.out.println(result);
        
        
        // if(result){

        //     ArrayList<Integer> p = new ArrayList<>();
        //     printSubsets(set, i - 1, sum, p);

        //     // while(i > 0 && j > 0){

        //     //     if(dp[i][j] == dp[i - 1][j]) i--;
        //     //     else{
        //     //         System.out.println(set[i - 1]);
    
        //     //         j = j - set[i - 1];
        //     //         i = i - 1;
                    
        //     //     }
        //     // }
        // }
    }
}
