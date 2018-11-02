
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


import java.awt.print.Printable;

class Patient {

    public static void print() throws IOException {

        Scanner s = new Scanner(System.in);
        int arrSize = s.nextInt();

        long[] patientArray = new long[arrSize];
        for (int i = 0; i < arrSize; i++) {
            patientArray[i] = s.nextLong();
        }

        s.close();

        int minTablets = 1;
        int lastTablet = 1;
        for (int i = 1; i < arrSize; i++) {
            
            if(patientArray[i] == patientArray[i-1]){
                lastTablet = 1;
                minTablets += lastTablet;
                
            }

            else if(patientArray[i] == patientArray[i-1] + 1){
                lastTablet += 1;
                minTablets += lastTablet;
            }
            else{
                int count = 0;
                int j = i;
            while((j < arrSize - 1) && (patientArray[j + 1] < patientArray[j]))
            {
                j++;
                count++;
            }
            if(j == arrSize - 1){
                count++;
                while(count > 0){
                    minTablets += count;
                    count--;
                }
                break;
            }

            else if(count > 0){
                while(count > 0){
                    count++;
                    minTablets += count;
                    count--;
                }
                lastTablet = 1;
                i = i + count - 1;
    
                if(i >= arrSize) break;
            }
            }
        }
        System.out.println(minTablets);
    }
        
       

    public static void main(String[] args) {

        try {
            print();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

    }
}
