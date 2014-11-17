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
    public int solution(int[] A) {

        int min = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[max])
                max = i;
            if (A[i] < A[min])
                min = i;
        }

        int minBeforeMax = max;

        for (int i = 0; i < max; i++)
            if (A[i] < A[minBeforeMax]) minBeforeMax = i;

        int maxAfterMin = min;

        for (int i = min; i < A.length; i++)
            if (A[i] > A[maxAfterMin]) maxAfterMin = i;

        return Math.max(
                Math.max(
                        maxProfit(A, min, maxAfterMin),
                        maxProfit(A, minBeforeMax, max)
                ),
                Math.max(
                        0,
                        maxProfit(A, Math.min(min, max), Math.max(min, max) - 1)
                )
        );
    }

    int maxProfit(int[] in, int from, int to) {
        int max = 0;
        for (int i = from; i <= to; i++)
            max = Math.max(max, in[to] - in[i]);
        return max;
    }
}
