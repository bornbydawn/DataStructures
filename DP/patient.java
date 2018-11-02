
//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/tablets/ 
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

        long[] pillArray = new long[arrSize];
        Arrays.fill(pillArray, 1);

        s.close();

        long minTablets = 0;
        for (int i = 1; i < arrSize; i++) {

            if(patientArray[i] > patientArray[i - 1]){
                pillArray[i] = pillArray[i-1] + 1;
            }

        }

        for(int j = arrSize - 2; j >= 0; j--){
            if(patientArray[j] > patientArray[j + 1]){
                    pillArray[j] = Math.max(pillArray[j], pillArray[j+1] + 1) ;
            }
        }

        for (long var : pillArray) {
            minTablets += var;
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
