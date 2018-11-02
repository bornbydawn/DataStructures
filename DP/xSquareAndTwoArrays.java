//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/xsquare-and-two-arrays/description/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;   
import java.util.StringTokenizer;   

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;



class XSquareAndTwoArrays {

    public static void print() throws IOException {

        FastReader s=new FastReader();

        //Scanner s = new Scanner(System.in);
        int arrSize = s.nextInt();
        int qSize = s.nextInt();

        long[] arrA = new long[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arrA[i] = s.nextLong();
        }

        long[] arrB = new long[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arrB[i] = s.nextLong();
        }

        int[][] matrix = new int[qSize][3];

        for (int i = 0; i < qSize; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        long[] dpAStart = new long[arrSize];
        long[] dpBStart = new long[arrSize];

        for (int i = 0; i < arrSize; i++) {
            if (i % 2 == 0) {
                dpAStart[i] = arrA[i];
                dpBStart[i] = arrB[i];
            }

            else {
                dpBStart[i] = arrA[i];
                dpAStart[i] = arrB[i];
            }

            if (i != 0) {
                dpAStart[i] = dpAStart[i - 1] + dpAStart[i];
                dpBStart[i] = dpBStart[i - 1] + dpBStart[i];
            }
        }

        boolean aTurn = false;
        long[] answers = new long[qSize];
        for (int i = 0; i < qSize; i++) {
            if (matrix[i][0] == 1)
                aTurn = true;
            else
                aTurn = false;

            if (aTurn) {

                if (matrix[i][1] % 2 == 1)
                    answers[i] = dpAStart[matrix[i][2] - 1]
                            - ((matrix[i][1] - 2) >= 0 ? dpAStart[matrix[i][1] - 2] : 0);
                else {
                    answers[i] = dpBStart[matrix[i][2] - 1]
                            - ((matrix[i][1] - 2) >= 0 ? dpBStart[matrix[i][1] - 2] : 0);
                }
            }

            else {
                if (matrix[i][1] % 2 == 1) {
                    answers[i] = dpBStart[matrix[i][2] - 1]
                            - ((matrix[i][1] - 2) >= 0 ? dpBStart[matrix[i][1] - 2] : 0);
                } else {
                    answers[i] = dpAStart[matrix[i][2] - 1]
                            - ((matrix[i][1] - 2) >= 0 ? dpAStart[matrix[i][1] - 2] : 0);
                }
            }

        }

        for (long var : answers) {
            System.out.println(var);
        }

    }

    public static void main(String[] args) {

        try {
            print();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 

}

