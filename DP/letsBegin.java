
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class LetsBegin {

    public static long count = 0;

    public static void print() throws IOException {

        FastReader s = new FastReader();
        int arrSize = s.nextInt();

        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = s.nextInt();
        }

        // HashMap<Integer, Integer> minNumbers = new HashMap<>();
        int[] minNumbers = new int[1000000];
        Arrays.fill(minNumbers, Integer.MAX_VALUE);

        int maxCalculated = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j <= arr[i]; j++) {

                if(arr[i] <= maxCalculated ) break;


                if (j == 1 || j == 3)
                    minNumbers[j] = -1;

                if(j == 0 || j == 2 || j == 3 || j == 5 || j == 7){
                    minNumbers[j] = 1;
                }

                else{

                    
                    if (j - 7 > 0 && minNumbers[j - 7] != Integer.MAX_VALUE && minNumbers[j - 7] != -1) {
                        minNumbers[j] = minNumbers[j - 7] + 1;
                    }
    
                    else if (j - 5 > 0 && minNumbers[j - 5] != Integer.MAX_VALUE && minNumbers[j - 5] != -1) {
                        minNumbers[j] = minNumbers[j - 5] + 1;
                    }
    
                    else if (j - 3 > 0 && minNumbers[j - 3] != Integer.MAX_VALUE && minNumbers[j - 3] != -1) {
                        minNumbers[j] = minNumbers[j - 3] + 1;
                    }
    
                    else if (j - 2 > 0 && minNumbers[j - 2] != Integer.MAX_VALUE && minNumbers[j - 2] != -1) {
                        minNumbers[j] = minNumbers[j - 2] + 1;
                    }
                    else{
                        minNumbers[j] = -1;
                    }
                }
            }
            maxCalculated = arr[i];

        }

        for (int var : arr) {

            System.out.println(var + ": " + minNumbers[var]);
        }
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
