
//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/tablets/ 
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class LSCS {

    public static void main(String[] args) {

        // int arr[] =  {-2, -3, 4, -1, -2, 1, 5, -3};

        int arr[] =  {-2, -3, -4, -1, -2, -1, -5, -3};


        int max_ending_here = 0;
        int max_so_far = 0;

        for(int i = 0; i < arr.length; i++){
            max_ending_here += arr[i];

            if(max_ending_here < 0) max_ending_here = 0;

            else if(max_so_far < max_ending_here) max_so_far  = max_ending_here;
        }

        System.out.println(max_so_far);

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
