
import java.io.*;
import java.util.*;

class NextPalindrome {

    public static void print() throws IOException {

        FastReader s = new FastReader();
        int size = s.nextInt();
        while(size != 0){

            int a = s.nextInt() + 1;
            while(!isPalindrome(a)){
                a++;
            }
            System.out.println(a);

            size--;
        }
    }

    static boolean isPalindrome(int n)
    {   
        // Find the appropriate divisor
        // to extract the leading digit
        int divisor = 1;
        while (n / divisor >= 10)
            divisor *= 10;
      
        while (n != 0)
        {
            int leading = n / divisor; 
            int trailing = n % 10;
      
            // If first and last digit 
            // not same return false
            if (leading != trailing)  
                return false;
      
            // Removing the leading and trailing
            // digit from number
            n = (n % divisor) / 10;
      
            // Reducing divisor by a factor 
            // of 2 as 2 digits are dropped
            divisor = divisor / 100;
        }
        return true;
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
