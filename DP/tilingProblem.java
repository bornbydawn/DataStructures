
import java.io.*;
import java.util.*;

class Main {

    static int f[];

    static int getWays(int rows, int columnWidth) {

        f[0] = 0;

        for (int i = 1; i <= rows; i++) {


            //means for an arrangement where rows are less than the column witdth, the tiles can only be arranged horizantally and there is only one way to lay down
            //all tiles horizontally, for example for 3x1 where m = 3, let i = 2 (n) so two rows of 3 x 1 tiles can only be fitted with horizontally laying down both the tiles
            if(i < columnWidth) f[i] = 1;


            //for example three rows of 3 x 1 tiles can be done by placing all the three tiles either vertically or horizontally, so total two ways,
            //this will always be the case when rows == columns (here rows are represented by i
            else if(i == columnWidth) f[i] = 2;

            //if there were supppose 4 rows and i was 4 here then you could vertically place three 3 x 1 (i.e. 1 x3 * 3 = 3 * 3) then the reamining one horizontally at the last row
            //so basically there are more rows here than the columns in one tile, so there will be row(s) left even after laying down one of the tiles vertically
            //so now the remaining space on the right (leaving the unoccupied rows) will always be filled with vertical tiles and there is only one way to do that
            //so the only rows which are now left empty can be filled (so now you can see that the rows remaining are i - m because m is the vertical height of one tile)
            else
                f[i] = f[i - 1] + f[i - columnWidth];
        }

        return f[rows];
    }

    public static void main(String[] args) {

        int columnWidth = Integer.parseInt(args[0]);
        int rows = Integer.parseInt(args[1]);
        f = new int[rows + 1];
        Arrays.fill(f, -1);
        System.out.println(getWays(rows, columnWidth));
    }
}
