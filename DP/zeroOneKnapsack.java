
import java.io.*;
import java.util.*;

class Main {

    public static int[][] dp;

    static int knapsack(int[] weight, int[] value, int sum) {

        dp = new int[weight.length + 1][sum + 1];

        for(int i = 0 ; i <= weight.length; i ++){
            for(int j = 0; j <= sum; j++){
                
                if(i == 0 || j == 0) dp[i][j] = 0;

                else if(weight[i - 1] <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

       
       return dp[weight.length][sum];
    }

        // static void printSubsets(int arr[], int i, int sum, ArrayList<Integer> p){

        //     if(i == 0 && sum != 0 && dp[0][sum]){
        //         p.add(arr[i]);
        //         p.forEach(System.out::println);
        //         System.out.println();
        //         p.clear();
        //         return;
        //     }

        //     if(i == 0 && sum == 0){
        //         p.forEach(System.out::println);
        //         System.out.println();
        //         p.clear();
        //         return;
        //     }

        //     //this is actually where the branching is happening for this case since we initialize a new arraylist for cases
        //     //where we have a subset possible without this value also. if there is a different subset with this value also
        //     //then the next if block will handle it
        //     if(dp[i - 1][sum]){

        //         ArrayList<Integer> b = new ArrayList<>();
        //         //this is crucial, don't forget
        //         b.addAll(p);

        //         printSubsets(arr, i - 1, sum, b);

        //     }

        //     //if the current element is less than or equal to the sum left
        //     //and if we consider this element, the remaining sum can be handled in the remaining set
        //     if(sum >= arr[i] && dp[i - 1][sum - arr[i]]){
        //         p.add(arr[i]);
        //         printSubsets(arr, i - 1, sum - arr[i], p);
        //     }
        // }

    public static void main(String[] args) {

        //int[] x = {8,32,12,16,4};
        //int[] set = {10, 5, 3, 15, 20};

        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  W = 50;

        //int[] set = {3, 34, 4, 12, 5, 2};
        //Arrays.sort(val);
        //int sum = 9;


        //int i = set.length; int j = sum;

        
        int result = knapsack(wt, val ,W);

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
