
import java.io.*;
import java.util.*;

class Prime {

    public static void print() throws IOException {

        FastReader s = new FastReader();
        int a = s.nextInt();
        while(a != 0){
            long i = s.nextLong();
            long j = s.nextLong();

            for (long var : prime(i,j)) {
                System.out.println(var);
            }

            System.out.println();

            a--;
        }

    }

    public static List<Long> prime(long start, long end){

        List<Long> primes = new ArrayList<>();
        boolean divisible;
        for(long i = start; i <= end; i++){
            if(i == 1) continue;
            divisible = false;
            for(long j = 2; j <= Math.sqrt(i); j++){

                if(i%j == 0){
                    divisible = true;
                    break;
                } 


            }
            if(!divisible) primes.add(i);
        }

        return primes;
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
