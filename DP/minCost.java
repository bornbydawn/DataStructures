class Main {

    public static void main(String[] args) {

        int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

        // System.out.println(findMinCost(cost, 2, 2));
        // int m = cost.length -1;
        // int n = cost[0].length -1;

        // System.out.println("m: " + m + "n: " + n);

        // int[][] dp = new int[m + 1][n + 1];
        // for (int i = 0; i <= m; i++) {
        // for (int j = 0; j <= n; j++) {

        // dp[i][j] = Integer.MAX_VALUE;
        // }
        // }

         System.out.println(findMinCostRecursive(cost, 2, 2));
         System.out.println(findMinCostRecursiveMemoized(cost, 2, 2));
        // System.out.println(findMinCost(cost, 2, 2));
        //System.out.println(findMinCostRecursiveMemoized(cost, 2, 2));
    }

    public static int findMinCost(int[][] cost, int m, int n) {

        int length = cost.length;
        int breadth = cost[0].length;

        if (m > length || n > breadth)
            return -1;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 && j == 0)
                    dp[i][j] = cost[0][0];

                else if (i == 0) {
                    dp[0][j] = cost[0][j] + dp[0][j - 1];
                } else if (j == 0) {
                    dp[i][0] = cost[i][0] + dp[i - 1][0];
                }

                else
                    dp[i][j] = cost[i][j] + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);

            }
        }

        return dp[m][n];
    }

    public static int findMinCostRecursive(int[][] cost, int m, int n) {

        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return cost[m][n];

        else
            return cost[m][n]
                    + min(findMinCostRecursive(cost, m, n - 1), findMinCostRecursive(cost, m - 1, n), findMinCostRecursive(cost, m - 1, n - 1));
    }

    public static int findMinCostRecursiveMemoized(int[][] cost, int m, int n) {

        if(m < 0 || n < 0) return Integer.MAX_VALUE;

        
        if (m == 0 && n == 0)
            return cost[m][n];

        else
            return cost[m][n]
                    + min(findMinCostRecursiveMemoized(cost, m, n - 1), findMinCostRecursiveMemoized(cost, m - 1, n), findMinCostRecursiveMemoized(cost, m - 1, n - 1));

        // if (m == 0 || n == 0)
        //     return cost[m][n];

        // else
        //     return cost[m][n] + min(findMinCostRecursiveMemoized(cost, m, n - 1),
        //             findMinCostRecursiveMemoized(cost, m - 1, n), findMinCostRecursiveMemoized(cost, m - 1, n - 1));
    }

    private static int min(int m, int n, int o) {
        return Math.min(m, Math.min(n, o));
    }
}