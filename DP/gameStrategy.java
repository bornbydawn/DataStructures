
class Main {

    static class Pair {
        int first, second;
        int pick = 0;

        @Override
        public String toString() {
            return first + " " + second + " " + pick;
        }
    }

    static Pair[][] getMaximumValue(int[] arr) {

        int n = arr.length;

        Pair[][] dp = new Pair[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair();
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i].first = arr[i];
            dp[i][i].second = 0;

            dp[i][i].pick = i;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

                if (arr[i] + dp[i + 1][j].second >= arr[j] + dp[i][j - 1].second) {
                    dp[i][j].first = arr[i] + dp[i + 1][j].second;
                    dp[i][j].second = dp[i + 1][j].first;

                    dp[i][j].pick = i;
                } else {
                    dp[i][j].first = arr[j] + dp[i][j - 1].second;
                    dp[i][j].second = dp[i][j - 1].first;
                    dp[i][j].pick = j;
                }

            }
        }

        for(int i = n - 1; i >=0 ; i++){

        }

        return dp;

    }
    static void printChoices(Pair[][] dp, int[] arr){

        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int step;

        for(int k = 0; k < n; k++){
            step = dp[i][j].pick;
            System.out.println("pick: " + step + " value: " + arr[step]);

            if(step <= i){
                i++;
            }
            else{
                j = j - 1;
            }
        }   

    }

    public static void main(String[] args) {
        //int pots[] = { 3, 1, 5, 6, 2, 9, 3 };

        int pots[] = { 3, 9, 1, 2};

        Pair[][] result = getMaximumValue(pots);

        printChoices(result, pots);

    }

}