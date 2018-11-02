
import java.io.*;
import java.util.*;

class Mixtures {

    public static int[][] dp;

    public static void print() throws IOException {

        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {

            int arrSize = s.nextInt();
            dp = new int[arrSize][arrSize];

            int[] mixtureArray = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                mixtureArray[i] = s.nextInt();
            }

            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < arrSize; j++) {
                    dp[i][j] = -1;
                }
            }

            System.out.println(getMinSmoke(mixtureArray, 0, mixtureArray.length - 1));
        }

        s.close();

    }

    static int getMinSmoke(int arr[], int start, int end) {

        if (start == end)
            return 0;

        if (dp[start][end] != -1)
            return dp[start][end];

        int k;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (k = start; k < end; k++) {

            int x = 0, y = 0;

            for (int i = start; i <= k; i++) {
                x = (x + arr[i]) % 100;
            }
            for (int j = k + 1; j <= end; j++) {
                y = (y + arr[j]) % 100;
            }
            count = (getMinSmoke(arr, start, k) + getMinSmoke(arr, k + 1, end) + x * y);

            if (count < min) {

                min = count;
                dp[start][end] = min;

            }

        }

        return dp[start][end];

    }

    public static void main(String[] args) {

        try {
            print();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

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
