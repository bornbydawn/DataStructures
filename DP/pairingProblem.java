
import java.io.*;
import java.util.*;

class Main {

    static int f[];

    static int getWaysRecur(int n) {

        if (n == 0 || n == 1 || n == 2)
            return n;

        if (f[n] != -1)
            return f[n];

        else
            return f[n] = getWaysRecur(n - 1) + (n - 1) * getWaysRecur(n - 2);

    }

    static int getWays(int n) {

        for (int i = 0; i <= n; i++) {

            if (i == 0 || i == 1 || i == 2)
                f[i] = i;

            else
                f[i] = f[i - 1] + (i - 1) * f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        f = new int[a + 1];
        Arrays.fill(f, -1);
        System.out.println(getWaysRecur(a));
    }
}
