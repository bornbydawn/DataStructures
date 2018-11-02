
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class Main {


    public static void main(String[] args) {

        FastReader s = new FastReader();

        int sets = s.nextInt();

        long k = s.nextLong();

        long sum = 0;

        long arr[][] = new long[sets][3];

        for(int i = 0; i < sets; i ++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = s.nextLong();
            }
        }

        //PriorityQueue<Long> pq = new PriorityQueue<>();

        long minimum = Long.MAX_VALUE;
       for(long i = 0 ; i < k ; i++){
        sum = 0;   
        for(int j = 0 ; j < sets; j++){

            sum = Math.max(sum, ((arr[j][0] + i)%k + (arr[j][1] + i)%k + (arr[j][2] + i)%k));
            if(sum > minimum) break;
           }
        if(sum < minimum) minimum = sum;
       }

       System.out.println(minimum);

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
