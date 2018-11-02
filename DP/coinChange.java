class Main{
    public static void main(String[] args) {
        // int[] arr = {1,2,3};
        // int n = 4;


        int[] arr = {2, 5, 3, 6};
        int n = 10;
        //System.out.println(getWaysOfChange(arr, n, m));
        System.out.println(getWaysOfChangeDynamic(arr,n));
    }

    private static int getWaysOfChange(int[] arr, int n, int i){

        if(n == 0) return 1;

        if( n < 0 ) return 0;
        
        if(i <= 0 &&  n > 0) return 0;


        return getWaysOfChange(arr, n - arr[i - 1], i ) + getWaysOfChange(arr, n, i - 1);
    }


    private static int getWaysOfChangeDynamic(int[] arr, int n){

        int m = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        int x = 0, y = 0;

        //you can alwyas make a sum of 0 by not including any coin i.e. one way 
        for(int i = 0 ; i <= m; i++){
            dp[i][0] = 1;
        }

        // you cannot make a sum of anything (apart from 0) by using a hypothetical zero ruppee coin
        for(int j = 1; j <= n; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j<= n; j++){
               x =  (arr[i - 1] > j) ?  0: dp[i][j - arr[i - 1]];
                y = dp[i - 1][j];

                dp[i][j] = x + y;
            }
        }

        return dp[m][n];

    }
}