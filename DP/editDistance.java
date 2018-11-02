class Main {
    public static void main(String[] args) {

        char[] s = "hello".toCharArray();
        char[] t = "heeloo".toCharArray();

        ////top down
        // int[][] dp = new int[s.length + 1][t.length + 1];

        // for(int i = 0; i <= s.length; i++){
        // for(int j = 0; j <= t.length ; j++){
        // dp[i][j] = Integer.MAX_VALUE;
        // }
        // }
        // System.out.println(minEdits(s, t, s.length, t.length, dp));

        System.out.println(minEdits(s, t));

    }

    //memoized with top down
    private static int minEdits(char[] s, char[] t, int m, int n, int[][] dp) {

        // if str1 is empty, add all from str2
        if (m == 0)
            return n;

        // if str2 is empty, remove all from str1
        if (n == 0)
            return m;

        if (dp[m][n] != Integer.MAX_VALUE)
            return dp[m][n];

        // if last characters of both the strings are same recur for the remaining
        // string
        if (s[m - 1] == t[n - 1])
            return dp[m][n] = minEdits(s, t, m - 1, n - 1, dp);

        else
            return dp[m][n] = 1
                    + min(minEdits(s, t, m, n - 1, dp), minEdits(s, t, m - 1, n, dp), minEdits(s, t, m - 1, n - 1, dp));
    }

    //bottom up
    private static int minEdits(char[] s, char[] t) {

        int[][] dp = new int[s.length + 1][t.length + 1];

        for (int i = 0; i <= s.length; i++) {
            for (int j = 0; j <= t.length; j++) {
                if (i == 0)
                    dp[0][j] = j;
                else if (j == 0)
                    dp[i][0] = i;

                else if (s[i - 1] == t[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        return dp[s.length][t.length];
    }

    private static int min(int m, int n, int o) {
        return Math.min(m, Math.min(n, o));
    }
}