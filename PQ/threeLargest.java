
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class Main {

    public static long topThree(PriorityQueue<Long> pq) {
        long product = 1;
        Iterator<Long> it = pq.iterator();
        while (it.hasNext()) {
            product = product * it.next();
        }
        return product;
    }

    public static void main(String[] args) {

        FastReader s = new FastReader();

        int length = s.nextInt();

        // long arr[] = new long[s.nextInt()];

        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = s.nextLong();
        // }

        PriorityQueue<Long> pq = new PriorityQueue<>(3);

       

        for (int i = 0; i < length; i++) {
       
            long currentLong = s.nextLong();
            
            if (i < 3) {
                pq.add(currentLong);
                if (i < 2) {

                    System.out.println("-1");
                } else {
                    System.out.println(topThree(pq));

                }

            }

            else {
                if (pq.peek() < currentLong) {
                    pq.remove();
                    pq.add(currentLong);
                }
                System.out.println(topThree(pq));
            }

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
