
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;   
import java.util.StringTokenizer;   
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException; 
 


//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;



class TriGraph {


    public static int minPathSum(int i, int j, int sum ,int maxRow, int[][] matrix){

        

        if( j > 2 || j < 0 || i > maxRow ) return 0;
        if(i == maxRow && j == 1) return sum;
 
        if(j <= 1 && i == maxRow){
        return sum + matrix[i][j+1];
        }
        if(j == 0 && i + 1 <= maxRow){      
            return Math.min(Math.min(minPathSum(i + 1, j, sum + matrix[i+1][j], maxRow, matrix), minPathSum(i, j + 1, sum + matrix[i][j+1], maxRow, matrix)),
             minPathSum(i + 1, j + 1, sum + matrix[i+1][j+1], maxRow, matrix)); 
        }

        if(j == 1 && i + 1 <= maxRow){
            // return matrix[i][j]=Math.min(Math.min(minPathSum(i +1, j, sum + matrix[i][j], maxRow, matrix), minPathSum(i + 1, j - 1, sum + matrix[i][j], maxRow, matrix)),Math.min(minPathSum(i + 1, j + 1, sum + matrix[i][j], maxRow, matrix), minPathSum(i, j + 1, sum + matrix[i][j], maxRow, matrix)));
            int x,y,z,w;
            x=minPathSum(i + 1, j, sum + matrix[i+1][j], maxRow, matrix);
            y=minPathSum(i + 1, j - 1, sum + matrix[i+1][j-1], maxRow, matrix);
            z=minPathSum(i + 1, j + 1, sum + matrix[i+1][j+1], maxRow, matrix);
            w=minPathSum(i, j + 1, sum + matrix[i][j+1], maxRow, matrix);
            return Math.min(x,Math.min(y,Math.min(z,w)));
        }

        if(j == 2 && i + 1 <= maxRow){
            // return Math.min(minPathSum(i + 1, j, sum + matrix[i][j], maxRow, matrix), minPathSum(i , j - 1, sum + matrix[i][j], maxRow, matrix));
            int x,y;
            x=minPathSum(i + 1, j, sum + matrix[i+1][j], maxRow, matrix);
            
            y=minPathSum(i + 1 , j - 1, sum + matrix[i+1][j-1], maxRow, matrix);
            
            return Math.min(x,y);

        }

        return sum;
    }



    public static void main(String[] args) throws FileNotFoundException{

        // PrintStream o = new PrintStream(new File("a.txt"));
        //     System.setOut(o); 
            
        FastReader s=new FastReader();

        int arrSize = s.nextInt();
        int num=1;
        while(arrSize!=0){
        int[][] matrix = new int[arrSize][3];

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        int sum = minPathSum(0, 1, matrix[0][1], arrSize - 1, matrix);
        System.out.println(num+". " +sum);
        num++;
        arrSize=s.nextInt();
        }
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 

}

