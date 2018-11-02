//https://www.spoj.com/problems/TRT/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class TreatForTheCows {

    public static int[][] dp;

    public static void print() throws IOException {

        FastReader s = new FastReader();
        int arrSize = s.nextInt();

        int[] treatArray = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            treatArray[i] = s.nextInt();
        }

        dp = new int[arrSize][arrSize];
        
        
        for(int i = 0; i < arrSize; i++){
            for(int j = 0; j < arrSize; j++){
                dp[i][j] = -1;
            }
        }

        int x = getMaxProfit(treatArray, 0, treatArray.length - 1, 1);

        System.out.println(dp[0][treatArray.length - 1]);

    }

    static int getMaxProfit(int arr[], int start, int end, int day) {

        
        if (start > end)
            return 0;

        
        if(dp[start][end]!=-1) return dp[start][end];

        return dp[start][end]= Math.max(arr[start]*day + getMaxProfit(arr, start+1, end, day+1), arr[end]*day +getMaxProfit(arr, start, end-1, day+1));

    }

    public static void main(String[] args) {

        try {
            print();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
