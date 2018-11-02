
import java.io.*;
import java.util.*;
import javafx.util.Pair;


class Main {

    public static int[][] dp;



    static int getLongestCommonSubstring(char[] s1, char[] s2, int m, int n) {

        int max = 0;
        int maxI = -1;
        int maxJ = -1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (s1[i - 1] == s2[j - 1])
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(max < dp[i][j]){
                        max = dp[i][j];
                        maxI = i; maxJ = j;
                    }
                   
                }
                    
                else
                    dp[i][j] = 0;

            }
        }

        while(maxI != 0 && maxJ != 0 && dp[maxI][maxJ] > 0){
            System.out.print(s1[maxI - 1] + " ");
            maxI--; maxJ--;
        }

        return max;
    }

    public static void main(String[] args) {

        String x = "AGGTAB";
        String y = "GGXTXAYB";

        char X[] = x.toCharArray();
        char Y[] = y.toCharArray();

        int m = x.length();
        int n = y.length();

        dp = new int[m + 1][n + 1];

        System.out.println(getLongestCommonSubstring(X, Y, m, n));
    }
}
