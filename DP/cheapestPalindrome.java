
import java.io.*;
import java.util.*;

class CheapestPalindrome {

    public static void print() throws IOException {

        FastReader s = new FastReader();
        int size = s.nextInt();
        int aCost;
        int bCost;
        while(size != 0){

            String string = s.next();
            aCost = s.nextInt();
            bCost = s.nextInt();
            
            System.out.println(getMinCost(string, aCost, bCost));

            size--;
        }
    }

    static int getMinCost(String s, int aCost, int bCost)
    {   
        int cost = 0;
        int length = s.length();
        for(int i = 0;  i < length/2; i ++){

            if(s.charAt(i) == '/'){
                if(s.charAt(length - i -1) == '/' ){

                    cost += Math.min(aCost, bCost) * 2;
                }
                

                else if(s.charAt(length - i -1) == 'a'){
                    cost += aCost;
                }

                else if( s.charAt(length - i -1) == 'b'){
                    cost+= bCost;
                }
                else{
                    return -1;
                }
            }
            else if(s.charAt(i) == 'a'){
                if(s.charAt(length - i -1) == '/' ){
                    cost += aCost;
                }
                else if(s.charAt(length - i -1) == 'a'){
                    continue;
                }
                else{
                    return -1;
                }
            }

            else if(s.charAt(i) == 'b'){
                if(s.charAt(length - i -1) == '/' ){
                    cost += bCost;
                }
                else if(s.charAt(length - i -1) == 'b'){
                    continue;
                }
                else{
                    return -1;
                }
            }

            else{
                return -1;
            }


        }

        return cost;
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
