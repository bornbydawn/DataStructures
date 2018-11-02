class Main {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 5, 9, 16 };

        System.out.println(isDivisionInSubsetsPossible(arr));
    }

    public static boolean isDivisionInSubsetsPossible(int[] arr) {

        int sum = 0;
        for (int var : arr) {
            sum += var;
        }

        if (sum % 2 != 0)
            return false;

        else {

            //return getResultUsingPowerSet(arr, sum/2);
            return getResultUsingDynamicProgramming(arr, sum / 2);
        }
    }

    public static boolean getResultUsingPowerSet(int[] arr, int sum) {

        for (int i = 0; i < (1 << arr.length); i++) {
            int setSum = 0;
            for (int j = 0; j < arr.length; j++) {

                if ((i & (1 << j)) > 0) {
                    setSum += arr[j];
                }
            }
            if (setSum == sum)
                return true;
        }

        return false;

    }

    public static boolean getResultUsingDynamicProgramming(int[] arr, int sum) {

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        // for sum 0 result is always 0
        for (int i = 0; i <= arr.length; i++)
            dp[i][0] = true;


        for (int i = 1; i <= arr.length; i++) {

            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }

            }
        }

        return dp[arr.length][sum];

    }

}