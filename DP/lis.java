
import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

class LIS {

    public static int[][] dp;

    static int getLongestIncreasingSubsequenceByCopy(int[] s1, int[] s2, int m, int n) {

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }

        return dp[m][n];
    }

    static int getLongestIncreasingSubsequence(int[] arr) {

        int l[] = new int[arr.length];

        Arrays.fill(l, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j] && l[i] < l[j] + 1)
                    l[i] = l[j] + 1;

            }
            Arrays.stream(l).forEach(System.out :: print);
            System.out.println();
        }


        // for(int i = 0, j = 0; i < arr.length - 1; i++){
        //     j = i + 1;

        //     if(arr[j] > arr[i] && l[j] < l[i] + 1 ){
        //         l[j] = l[i] + 1;
        //     }
        // }

        //Arrays.stream(l).forEach(System.out :: print);
        return Arrays.stream(l).max().getAsInt();
    }

    public static void main(String[] args) {

        int[] x = { 10, 22, 9, 33, 21, 50, 41, 60 };
 
        int[] y = { 10, 22, 9, 33, 21, 50, 41, 60 };

        Arrays.sort(y);

        int m = x.length;
        int n = y.length;

        dp = new int[m + 1][n + 1];

        //System.out.println(getLongestIncreasingSubsequenceByCopy(x, y, m, n));

        System.out.println(getLongestIncreasingSubsequence(x));
       
        // debug this why is it not prinitng all the values
        // int i = m; int j = n;
        // ArrayList<Integer> lcs = new ArrayList<>();
        // while(i > 0 && j > 0){

        // if(x[i - 1] == y[j - 1]){
        // lcs.add(x[i -1]);
        // i--; j--;
        // }
        // else if(dp[i - i][j] > dp[i][j - 1]){
        // i--;
        // }else{
        // j--;
        // }

        // }

        // for(int k = lcs.size() - 1; k >=0; k--){
        // System.out.println(lcs.get(k));
        // }
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
