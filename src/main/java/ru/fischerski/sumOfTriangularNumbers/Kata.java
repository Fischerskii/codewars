package ru.fischerski.sumOfTriangularNumbers;

public class Kata {
    public static int sumTriangularNumbers(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return counterTriangularNumbers(n);
    }

    private static int counterTriangularNumbers(int inputVariable) {
            int count = 1;
            int triangularNumber = 1;
            for (int i = 2; i <= inputVariable; i++) {
                count = count + i;
                triangularNumber = triangularNumber + count;
            }
        return triangularNumber;
    }
}