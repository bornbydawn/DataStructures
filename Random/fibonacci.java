import java.util.HashMap;
import java.util.Map;
import java.lang.Math;
import java.math.BigInteger;

class FibExpo {

    private long matrix[][];
    private long firstRowFirstColumn;
    private long firstRowSecondColumn;

    private long secondRowFirstColumn;
    private long secondRowSecondColumn;

    public FibExpo(){
        matrix = new long[][]{{1,1}, {1,0}};
    }

    public long getFibonacci(long n){

        if(n == 0)
        return 0;

        if(n == 1 || n == 2)
        return 1;

        power(matrix, n-1);
        return matrix[0][0];

    }

    void power(long matrix[][], long n){
        if(n == 0 || n == 1 )
        return;

        long M[][] = new long[][]{{1,1}, {1,0}};
        power(matrix, n/2);
        multiplyMatrix(matrix, matrix);

        if(n%2 != 0)
        multiplyMatrix(matrix, M);
    }

    private void multiplyMatrix(long matrix[][], long matrix2[][]){
        firstRowFirstColumn = (matrix[0][0] * matrix2[0][0] + matrix[0][1] * matrix2[1][0]);
        firstRowSecondColumn = matrix[0][0] * matrix2[0][1] + matrix[0][1] * matrix2[1][1];

        secondRowFirstColumn = matrix[1][0] * matrix2[0][0] + matrix[1][1] * matrix2[1][0];
        secondRowSecondColumn = matrix[1][0] * matrix2[0][1] + matrix[1][1] * matrix2[1][1];

        matrix[0][0] = firstRowFirstColumn % 1000000007;
        matrix[0][1] = firstRowSecondColumn % 1000000007;

        matrix[1][0] = secondRowFirstColumn % 1000000007;
        matrix[1][1] = secondRowSecondColumn % 1000000007;

    }
}

class Main {
    public static void main(String[] args) {
        FibExpo fib = new FibExpo();
        long tenPower18 = 1000000000000000000L; 
        System.out.println(fib.getFibonacci(tenPower18));
    }
}
