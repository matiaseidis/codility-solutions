package tests.prefixSums;

import java.util.Arrays;

// A non-empty zero-indexed array A consisting of N integers is given.
// A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called
// a slice of array A (notice that the slice contains at least two elements).
// The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q]
// divided by the length of the slice. To be precise,
// the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
//        For example, array A such that:
//        A[0] = 4
//        A[1] = 2
//        A[2] = 2
//        A[3] = 5
//        A[4] = 1
//        A[5] = 5
//        A[6] = 8
//        contains the following example slices:
//        slice (1, 2), whose average is (2 + 2) / 2 = 2;
//        slice (3, 4), whose average is (5 + 1) / 2 = 3;
//        slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
//        The goal is to find the starting position of a slice whose average is minimal.
//        Write a function:
//class Solution { public int solution(int[] A); }
//that, given a non-empty zero-indexed array A consisting of N integers,
// returns the starting position of the slice with the minimal average.
// If there is more than one slice with a minimal average, you should return
// the smallest starting position of such a slice.
//        For example, given array A such that:
//        A[0] = 4
//        A[1] = 2
//        A[2] = 2
//        A[3] = 5
//        A[4] = 1
//        A[5] = 5
//        A[6] = 8
//        the function should return 1, as explained above.
//        Assume that:
//        N is an integer within the range [2..100,000];
//        each element of array A is an integer within the range [−10,000..10,000].
//        Complexity:
//        expected worst-case time complexity is O(N);
//        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//        Elements of input arrays can be modified.
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        test(new int[]{10, 10, -1, 2, 4, -1, 2, -1}, 5);
        test(new int[]{4, 2, 2, 5, 1, 5, 8}, 1);
        test(new int[]{10000, -10000, -10000, 10000}, 1);
        test(new int[]{5, 6, 3, 4, 9}, 2);
        test(new int[]{9330, -1185, -9851, 8220, 8786, 1645, 3431, -8322, 5330, -5264, -9384, 5776, -3078, 2466, 2316, -7029, -6339, -7712, -9708, -265, 9298, -8709, 822, -682, 2029, -8222, 1580, -4609, 1129, 2893, -379, -2895, -5017, 8671, -932, 603, -9614, 162, -9885, -7125, -543, -2453, -8917, 1751, -6720, 1147, -7115, 8747, 5420, 9139, -7176, -3892, -9209, -4465, 6131, -6453, -6909, 9095, -6909, 6678, -9179, -2276, -3008, -3166, 6330, -481, 5658, -583, 6347, 7632, -1208, 5622, 6295, -4087, -7523, -6288, -1279, -7611, 596, 6589, -296, 6355, 3128, 2821, -3093, 4053, 6199, -6857, 8160, -4614, -6903, 6810, 4403, 5872, -1067, -8585, -2095, -9046, -4278, -9241}, 17);
        test(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100}, 0);
        test(new int[]{-1, -1, 0, -1, 1, -1, 0, -1, 1, -1, 0, 0, -1, -1, 0, -1, 0, -1, -1, 0, 1, -1, -1, 1, -1, 1, 0, -1, 1, 1, 0, 1, -1, 0, 0, 1, -1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, -1, 1, -1, 1, 1, 0, -1, 0, 0, -1, 0, 0, 0, -1, -1, 0, -1, 0, -1, 0, 1, 1, 0, 1, 1, 0, -1, 0, -1, 1, 0, 1, -1, -1, -1, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, -1, 0, -1, 1, 0, 1, -1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, -1, -1, 1, -1, 0, 0, -1, 0, 1, 1, 0, -1, 1, 0, 0, 1, 0, -1, -1, 1, 0, 1, 1, 1, 1, -1, 1, -1, 0, 1, 0, -1, 0, 0, 0, 1, 0, -1, 0, -1, -1, 0, 1, -1, -1, -1, 1, 1, -1, 0, -1, -1, 0, 0, 1, 1, 0, 1, 0, 1, 1, -1, 1, 0, 0, 0, -1, 0, -1, 0, 1, 1, 0, 0, 1, -1, -1, 1, 0, 1, 0, 0, 1, 0, 1, 1, -1, 1, -1, 0, 0, 1, -1, 0, 0, 1, -1, -1, 1, -1, 1, -1, 0, -1, 0, 1, -1, 0, -1, 0, 0, -1, 1, 0, 1, -1, 1, -1, -1, 0, 1, 0, -1, 1, -1, 1, 1, -1, 1, 0, 1, 1, 1, -1, 0, 1, -1, 0, 1, -1, -1, -1, 0, 0, 0, 0, -1, -1, 0, 1, 1, 1, -1, 1, 0, -1, -1, 0, 0, -1, -1, 1, -1, 1, 0, 1, -1, 0, 1, 0, 0, 0, -1, -1, -1, -1, 1, -1, 1, -1, 0, 0, -1, 1, 1, 1, 0, -1, -1, -1, 1, 1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 1, 0, -1, -1, 1, 1, -1, 0, 1, 0, -1, 0, -1, -1, 1, -1, 1, 1, 0, -1, -1, 1, 1, -1, -1, 0, 1, -1, 1, -1, -1, -1, 0, 1, 0, -1, -1, 0, -1, 1, 0, 1, 1, 1, -1, 0, 1, -1, -1, -1, 0, 1, 1, -1, -1, 1, -1, -1, 1, 1, 0, 1, 1, 1, -1, 0, 1, 0, 0, 1, 1, 0, 0, 1, -1, 0, 1, 0, -1, 1, 0, 0, -1, 0, 1, -1, 0, -1, -1, 0, 1, -1, 1, 1, -1, -1, 1, 1, 1, 1, 1, 0, -1, 1, 0, -1, 1, -1, -1, -1, -1, 0, 0, 0, 0, -1, 0, 1, -1, 1, 0, 1, 0, 0, -1, -1, -1, -1, 1, 1, 1, 1, 0, 1, 1, -1, -1, -1, 1, 1, -1, 1, -1, -1, -1, 1, 1, -1, -1, 1, 0, 0, 0, 0, -1, -1, 0, 1, 0, -1, -1, -1, 1, 0, 0, 0, 1, 1, -1, 0, 0, 1, -1, 0, -1, 0, 1, 0, 0, 0, 1, 1, -1, -1, 0, -1, -1, 1, -1, 0, -1, 1, 1, 1, 1, 0, 0, -1, 0, 1, 0, -1, -1, -1, 1, -1, 1, 0, 0, 0, -1, 0, -1, 0, 0, 0, 1, 1, 1, 0, -1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 1, 0, -1, 0, 0, 0, 0, 0, -1, -1, 0, -1, 0, 1, 0, 1, 1, 0, 0, -1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, -1, 1, 1, 1, 1, -1, 1, -1, 1, -1, 1, 1, -1, 0, -1, 1, -1, 1, 0, -1, -1, 0, 1, 0, -1, 0, 1, 0, -1, 0, 1, 1, 1, 0, -1}, 0);
    }

    private static void test(int[] in, int i) {
        int result = new MinAvgTwoSlice().solution(in);
        System.out.println(String.format("ok: %s, result: %s expected: %s", i == result, result, i));
    }
//    https://codility.com/demo/results/demoFCTS4F-772/
    public int solution(int[] A) {

        int[] sum = new int[A.length];

        sum[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--)
            sum[i] = A[i] + sum[i + 1];

        float[] threeBestSlice = slice(3, sum);
        float[] twoBestSlice = slice(2, sum);

        if(threeBestSlice[0] == twoBestSlice[0]) {
            return (int) Math.min(threeBestSlice[1], twoBestSlice[1]);
        } else {
            float[] winner = threeBestSlice[0] > twoBestSlice[0] ? twoBestSlice : threeBestSlice;
            return (int) winner[1];
        }
    }

    float[] slice(int segmentSize, int[] sum) {
        float minAvg = Float.MAX_VALUE;
        int result = 0;
        for (int i = 0; i <= sum.length - segmentSize; i++) {
            int toRemove = (i + segmentSize) < sum.length ? sum[i + segmentSize] : 0;
            float avg = (float) (sum[i] - toRemove) / segmentSize;
            if (minAvg > avg) {
                minAvg = avg;
                result = i;
            }
        }
        return new float[]{minAvg, result};
    }
}
