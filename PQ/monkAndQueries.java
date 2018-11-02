
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class Main {

    public static void main(String[] args) {

        FastReader s = new FastReader();

        int length = s.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(length);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(length, Collections.reverseOrder());

        for (int i = 0; i < length; i++) {

            int nextInt = s.nextInt();

            if (nextInt == 1) {
                nextInt = s.nextInt();
                minHeap.add(nextInt);
                maxHeap.add(nextInt);
            }

            else if (nextInt == 2) {
                nextInt = s.nextInt();
                if (minHeap.contains(nextInt)) {
                    minHeap.remove(nextInt);
                    maxHeap.remove(nextInt);
                } else {
                    System.out.println("-1");
                }
            }

            else if (nextInt == 4) {
                if (!minHeap.isEmpty()) {
                    System.out.println(minHeap.peek());
                } else {

                    System.out.println("-1");

                }
            }

            else if (nextInt == 3) {
                if (!maxHeap.isEmpty()) {
                    System.out.println(maxHeap.peek());
                } else {
                    System.out.println("-1");

                }
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
