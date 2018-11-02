
import java.io.*;
import java.util.*;

class DivSubset {

    public static int[][] dp;

    static void getMaximumDivisibleSubset(int[] arr) {

        // array that maintains the maximum index till which the condition is satisfied
        int l[] = new int[arr.length];
        // we will always have atleast one element divisible by itself
        Arrays.fill(l, 1);

        // maintain the index of the last increment
        int prev[] = new int[arr.length];
        Arrays.fill(prev, -1);

        // index at which last increment happened
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                // only increment the maximum index if this iteration will increase it
                if (arr[i] % arr[j] == 0 && l[i] < l[j] + 1) {
                    prev[i] = j;
                    l[i] = l[j] + 1;

                }

            }

            if (l[i] > l[maxIndex])
                maxIndex = i;
        }

        int k = maxIndex;
        while (k >= 0) {
            System.out.print(arr[k] + " ");
            k = prev[k];
        }

    }

    public static void main(String[] args) {

        int[] x = { 1, 2, 17, 4};

        // sort the array
        Arrays.sort(x);

        getMaximumDivisibleSubset(x);
    }
}
