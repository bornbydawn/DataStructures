import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) {
        

        FastReader s = new FastReader();

        int students = s.nextInt();

        //@SuppressWarnings("unchecked")
        //List<String> hashTable[] = new LinkedList[students];

        
        // for(int i = 0 ; i < students; i++){
        //     hashTable[i] = new LinkedList<>();
        // }
        int hashFunc = students;

        while(true){
            if(isPrime(hashFunc))
            break;

            hashFunc++;
        }

        String hashTable[] = new String[hashFunc];

        long rollNumber;
        String name;

        for(int i = 0; i < students; i++){
            rollNumber = s.nextLong();
            name = s.next();
            //hashTable[(int)(rollNumber % hashFunc)].add(name);
            hashTable[(int)(rollNumber % hashFunc)] = name;
        }

        int queries = s.nextInt();
        long query;
        for(int i = 0; i < queries; i++){
            query = s.nextLong();
            //System.out.println(hashTable[(int)(query % hashFunc)].get(0));
            System.out.println(hashTable[(int)(query % hashFunc)]);
        }
        // smallest prime number >=100000
        //largest prime number below 10^5 would waste the ending space in the array (the indexes after that prime number since those will again start from one)
        
        

    }

    static boolean isPrime(int n){

        if(n <= 1) return false;
        if(n <= 3) return true;


        if(n % 2 == 0 || n % 3 == 0) return false;

        for(int i = 5; i*i <= n; i = i + 6){
            if(n % i == 0 || n%(i + 2) == 0) return false; 
        }

        return true;
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