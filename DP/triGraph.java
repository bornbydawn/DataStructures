//https://www.spoj.com/problems/ACPC10D/
import java.util.*;
import java.lang.*;
import java.io.*;

//import java.awt.print.Printable;

class TriGraph {

    public static void main(String[] args) throws FileNotFoundException {

        // PrintStream o = new PrintStream(new File("a.txt"));
        // System.setOut(o);

        FastReader s = new FastReader();

        int arrSize = s.nextInt();
        int num = 1;
        while (arrSize != 0) {
            int[][] matrix = new int[arrSize][3];

            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = s.nextInt();
                }
            }

            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < 3; j++) {

                    if (j == 0) {
                        if (i == 0)
                            continue;
                        if (i == 1)
                            matrix[i][j] = matrix[i][j] + matrix[i - 1][j + 1];
                        else {
                            matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j + 1], matrix[i - 1][j]);

                        }
                    }
                    if (j == 1) {

                        if (i == 0) {
                            continue;
                        } 
                        if( i == 1){
                            matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j + 1]));
                        }
                        else {
                            matrix[i][j] = matrix[i][j] + Math.min(Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]),
                                    Math.min(matrix[i][j - 1], matrix[i - 1][j + 1]));
                        }

                    }
                    if (j == 2) {
                        if (i == 0) {
                            matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
                        } else {
                            matrix[i][j] = matrix[i][j] + Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j-1]);
                        }

                    }
                }
            }

            System.out.println(num + ". " + matrix[arrSize - 1][1]);
            num++;
            arrSize = s.nextInt();
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
