package tests.maxslice;

import java.util.Arrays;

public class MaxProfit {

    public static void main(String[] args) {
        test(new int[]{8, 9, 3, 6, 1, 2}, 3);
        test(new int[]{23171, 21011, 21123, 21366, 21013, 21367}, 356);
        test(new int[]{5, 4, 3, 2, 1}, 0);
        test(new int[]{8, 8, 8, 1, 5, 4, 3, 2, 1}, 4);
        test(new int[]{5, 4, 3, 2, 1, 0}, 0);
        test(new int[]{0, 1, 2, 3, 4, 5}, 5);
        test(new int[]{77, 100, 2, 1, 88, 0, 1, 89}, 89);
        int[] in = new int[100];
        for (int i = 0; i < 100; i++)
            in[i] = 100 - i;
        test(in, 0);
        int[] in2 = new int[1000];
        for (int i = 0; i < 1000; i++)
            in2[i] = 1000 - i;
        test(in2, 0);
    }

    private static void test(int[] is, int i) {
        int result = new MaxProfit().solution(is);
        System.out.println(String.format("ok: %s result: %s expected: %s",
                (result == i), result, i));
    }

    // n = A.lenght
    // t O(n)
    // s O(1)
//    https://codility.com/c/run/demoYF7MTH-KND
    public int solution(int[] A) {

        int currentMin = 0;
        int maxProfit = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= A[currentMin]) currentMin = i;
            else maxProfit = Math.max(maxProfit, A[i] - A[currentMin]);
        }

        return maxProfit;
    }
}
