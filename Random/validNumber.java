/* Problem

input x and range y to z
multiply x with every number in range y to z
if product of x and range number contains any digit of range number then its invalid
return count of valid numbers
x,y,z are int

example x = 2 and y = 10 z = 15
2*10 = 20 (invalid as it contains 0 from 10)
output 4

*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import java.lang.Math;
import java.math.BigInteger;

class Valid {

    public int validator(int x, int rangeStart, int rangeEnd) {

        int validCount = 0;
        if (x == 1 || rangeEnd < rangeStart)
            return 0;

        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (checkIfValid(Integer.toString(i * x), Integer.toString(i)))
                validCount++;
        }
        return validCount;

    }

    public boolean checkIfValid(String a, String b) {

        HashSet<Character> checker = new HashSet<>();

        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();

        for (int i = 0; i < aCharArray.length; i++) {

            checker.add(aCharArray[i]);
        }

        for (int j = 0; j < bCharArray.length; j++) {
            if (checker.contains(bCharArray[j]))
                return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Valid v = new Valid();
        System.out.println(v.validator(2, 10, 15));
    }
}
