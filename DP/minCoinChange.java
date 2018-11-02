class Main{
    public static void main(String[] args) {
        // int[] arr = {1,2,3};
        // int n = 4;


        int[] arr = {1, 5, 6, 9};
        int n = 11;


        // int[] arr = {25, 10, 5};
        // int n = 30;

        System.out.println(getWaysOfChangeDynamic(arr,n));
    }

    private static int getWaysOfChangeDynamic(int[] arr, int n){

        int m = arr.length;
        int[][] dp = new int[m + 1][n + 1];

         // you cannot make a sum of anything (apart from 0) by using a hypothetical zero ruppee coin, so infinite coins are required
         for(int j = 0; j <= n; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }

        //you can alwyas make a sum of 0 by not including any coin i.e. one way 
        for(int i = 0 ; i <= m; i++){
            dp[i][0] = 0;
        }

       

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j<= n; j++){
               
               if(j < arr[i - 1]) dp[i][j] = dp[i - 1][j];

                //else dp[i][j] = Math.min(dp[i - 1][j], j/arr[i - 1] + dp[i][j % arr[i - 1]]);

                else{
                    int y;
                    int x = dp[i - 1][j];
                    if(dp[i][j - arr[i - 1]] != Integer.MAX_VALUE){
                        y = 1 + dp[i][j - arr[i - 1]];
                    }
                    else y = Integer.MAX_VALUE;

                    dp[i][j] = Math.min(x, y);
                }
                 
            }
        }

        // for(int i = 0; i <= m; i ++){
        //     for(int j = 0; j<= n; j++){
               
        //        System.out.print(dp[i][j] + "  ");
        //     }
        //     System.out.println();
        // }

        return dp[m][n];

    }
}