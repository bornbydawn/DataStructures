class Main {
    public static void main(String[] args) {

        //int arr[] = { 1, 2, 3, 4};
        int arr[] = { 2, 3, 6, 4, 5};
        //System.out.println(getMinimumMultiplications(arr, 1, arr.length - 1));

        System.out.println(getMinimumMultiplicationsDynamic(arr));
    }

    private static int getMinimumMultiplications(int[] arr, int i, int j) {

        if (i == j)
            return 0;

        int count;
        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            count = getMinimumMultiplications(arr, i, k) + getMinimumMultiplications(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];

            if (count < min) {
                min = count;
            }
        }

        return min;
    }

    private static int getMinimumMultiplicationsDynamic(int[] arr) {

        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    
                    int q = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                    System.out.println("i: " + i + " j: " + j + " dp[i][j]: " + dp[i][j]);
                }
            }
        }
        System.out.println("i: " + 0 + " j: " + 1 + " dp[i][j]: " + dp[0][1]);

        return dp[1][n - 1];

    }
}