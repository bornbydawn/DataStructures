//https://www.spoj.com/problems/XMAX/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class XMax {

    public static long[][] dp;
    public static int xor = 0;

    public static void print() throws IOException {

        //FastReader s = new FastReader();

        Scanner s = new Scanner(System.in);

        int arrSize = s.nextInt();

        long[] xorArray = new long[arrSize];
        for (int i = 0; i < arrSize; i++) {
            xorArray[i] = s.nextLong();
        }

        dp = new long[arrSize][arrSize];

        for(int i = 0;  i < arrSize; i++){
            for(int j = 0; j < arrSize; j++){
                dp[i][j] = -1;
            }
        }

        long a = getMaxXor(xorArray, 0, xorArray.length - 1);
        System.out.println(a);

        s.close();

    }

    static long getMaxXor(long arr[], int i, int j) {

        if (i == j)
            return arr[i];


        if(dp[i][j] != -1) return dp[i][j];

        int k;
        //long max = Long.MIN_VALUE;
        long xor = 0;



        for (k = i; k < j; k++) {


            xor = Math.max(getMaxXor(arr, i, k), Math.max(getMaxXor(arr, k + 1, j), getMaxXor(arr, i, k) ^ getMaxXor(arr, k + 1, j))) ;

            //System.out.println(xor);
            if (xor > dp[i][j]) {
                // max = xor;
                dp[i][j]=xor;
            }
        }

        return dp[i][j];
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
