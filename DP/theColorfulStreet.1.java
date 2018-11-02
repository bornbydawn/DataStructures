
//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/the-colorful-street-1/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class TheColorfulStreet {

    public static int[][] costArray;
    public static int[][] allowedIndex;
    public static int[][] dp;

    public static void print() throws IOException {

        

        FastReader s = new FastReader();
        
        int t = s.nextInt();
        
        while(t-- > 0){

            
            int arrSize = s.nextInt();
            dp = new int[arrSize][3];

        costArray = new int[arrSize][3];
        for (int i = 0; i < arrSize; i++) {
            for(int j = 0; j < 3 ; j++){
                costArray[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < arrSize; i++) {
            for(int j = 0; j < 3 ; j++){
                dp[i][j] = -1;
            }
        }

        allowedIndex = new int[3][2];
        allowedIndex[0][0] = 1;
        allowedIndex[0][1] = 2;

        allowedIndex[1][0] = 0;
        allowedIndex[1][1] = 2;

        allowedIndex[2][0] = 0;
        allowedIndex[2][1] = 1;

  

    //start with color 0 in house 1 or color 1 or color 2
    int minCost = Math.min(getMinCost(0,0,arrSize), getMinCost(0,1,arrSize), getMinCost(0,2,arrSize));

    }

    int getMinCost(int row, int column, int arrSize){

        if(row == arrSize) return 0;


        if(dp[row][column] != -1) return dp[row][column];

        else
        return dp[row][column] =  costArray[row][column] + Math.min(getMinCost(row + 1, column, arrSize, allowedIndex[column][0]), getMinCost(row + 1, column, arrSize, allowedIndex[column][1]));

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
