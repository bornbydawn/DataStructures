
import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

class LCS {

    public static int[][] dp;

    // static int getLongestCommonSubsequence(char[] s1, char[] s2, int m, int n) {

    // if (m == 0 || n == 0)
    // return 0;

    // if (dp[m][n] != -1)
    // return dp[m][n];

    // else if (s1[m - 1] == s2[n - 1])
    // return dp[m][n] = 1 + getLongestCommonSubsequence(s1, s2, m - 1, n - 1);

    // else {
    // return Math.max(dp[m-1][n] = getLongestCommonSubsequence(s1, s2, m - 1, n),
    // dp[m][n -1] = getLongestCommonSubsequence(s1, s2, m, n - 1));
    // }

    // }

    static int getLongestCommonSubsequence(char[] s1, char[] s2, int m, int n) {

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

    public static void main(String[] args) {

        String x = "AGGTAB";
        String y = "GXTXAYB";

        char X[] = x.toCharArray();
        char Y[] = y.toCharArray();

        int m = x.length();
        int n = y.length();

        dp = new int[m + 1][n + 1];

        System.out.println(getLongestCommonSubsequence(X, Y, m, n));


        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        // int i = m; int j = n;
        // StringBuilder lcs = new StringBuilder();
        // while(i > 0 && j > 0){

        //     if(X[i - 1] == Y[j - 1]){
        //         lcs.append(X[i -1]); 
        //         i--; j--;
        //     }
        //     else if(dp[i - i][j] > dp[i][j - 1]){
        //         i--;
        //     }else{
        //         j--;
        //     }
            
        // }

        // lcs = lcs.reverse();
        // System.out.println(lcs.toString());
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
