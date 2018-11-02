
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int size = fr.nextInt();
        while (size-- > 0) {
            String c = fr.nextLine();

            //System.out.println(c);
            if (c.length() < 9) {
                System.out.println("unlucky");
            } else {
                char[] answer = "".toCharArray();
                int cost = 0;
                int minCost = Integer.MAX_VALUE;

                // last 4 characters can be k c u l
                for (int i = 0; i < c.length() - 4; i++) {

                    char[] s = c.toCharArray();
                    cost = 0;
                    if (s[i] != 'l') {
                        s[i] = 'l';
                        cost++;
                    }
                    if (s[i + 1] != 'u') {
                        s[i + 1] = 'u';
                        cost++;
                    }
                    if (s[i + 2] != 'c') {
                        s[i + 2] = 'c';
                        cost++;
                    }
                    if (s[i + 3] != 'k') {
                        s[i + 3] = 'k';
                        cost++;
                    }
                    if (s[i + 4] != 'y') {
                        s[i + 4] = 'y';
                        cost++;
                    }

                    for (int j = 0, k = c.length() - 1; j <= k; j++, k--) {
                        if (s[j] != s[k]) {
                            if (j >= i && j <= i + 4) {
                                if (k >= i && k <= i + 4) {
                                    cost = Integer.MAX_VALUE;
                                    break;
                                } else {
                                    s[k] = s[j];
                                    cost++;
                                }
                            }

                            else if (k >= i && k <= i + 4) {
                                if (j >= i && j <= i + 4) {
                                    cost = Integer.MAX_VALUE;
                                    break;
                                } else {
                                    s[j] = s[k];
                                    cost++;
                                }
                            } else {
                                if (s[k] < s[j])
                                    s[j] = s[k];
                                else
                                    s[k] = s[j];

                                cost++;
                            }
                        }
                    }

                    if (cost < minCost) {
                        minCost = cost;
                        answer = s;
                    } else if (cost == minCost) {

                        if(answer == "".toCharArray()) answer = s;
                        
                        else if(String.valueOf(answer).compareTo(String.valueOf(s)) > 0) {
                            answer = s;
                        }
                    }
                }
                if(answer == "".toCharArray()) System.out.println("unlucky");

                else{
                    System.out.print(answer); System.out.print(" " + cost);
                System.out.println();
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