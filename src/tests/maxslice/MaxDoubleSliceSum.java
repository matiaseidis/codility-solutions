package tests.maxslice;


//A non-empty zero-indexed array A consisting of N integers is given.
//        A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
//        The sum of double slice (X, Y, Z) is the
//        total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
//        For example, array A such that:
//        A[0] = 3
//        A[1] = 2
//        A[2] = 6
//        A[3] = -1
//        A[4] = 4
//        A[5] = 5
//        A[6] = -1
//        A[7] = 2
//        contains the following example double slices:
//        double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
//        double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
//        double slice (3, 4, 5), sum is 0.
//        The goal is to find the maximal sum of any double slice.
//        Write a function:
//        int solution(int A[], int N);
//        that, given a non-empty zero-indexed array A consisting of N integers, returns the maximal sum of any double slice.
//        For example, given:
//        A[0] = 3
//        A[1] = 2
//        A[2] = 6
//        A[3] = -1
//        A[4] = 4
//        A[5] = 5
//        A[6] = -1
//        A[7] = 2
//        the function should return 17, because no double slice of array A has a sum of greater than 17.
//        Assume that:
//        N is an integer within the range [3..100,000];
//        each element of array A is an integer within the range [−10,000..10,000].
//        Complexity:
//        expected worst-case time complexity is O(N);
//        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//        Elements of input arrays can be modified.

import java.util.Arrays;

public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        test(new int[]{-1, -1, -1, -1, -1, -1}, 0);
        test(new int[]{3, 2, 6, -1, 4, 5, -1, 2}, 17);
        test(new int[]{0, 10, -5, -2, 0}, 10);
        test(new int[]{-8, 10, 20, -5, -7, -4}, 30);
        test(new int[]{1,7,8,2,-3,4}, 17);
        test(new int[]{1, -9, -9, 2, 4, 5, 8, -1, -1, 4}, 19);
        test(new int[]{1, 3, 4, 2, -3, 4, -10, 1, 1, 4, -2, 4, 1}, 18);
        test(new int[]{-8953, -8257, -1855, -7846, 8024, -9237, 724, -3356, 7042, -6807, -3256, -3324, -5097, -9967, -1275, -8248, 1952, -8603, -3691, -1034, 8108, -8145, -7157, 5802, -9576, 8223, 1468, -4694, 6757, 5376, -3131, 6030, -5863, 2178, 542, 6187, -3695, -2035, 5386, 255, 3697, 2767, 3333, 7802, -277, 3370, -2510, -9364, 5084, -6371, 6404, 8273, 3162, -6598, -3262, -2176, -8535, -865, 1463, -3278, -6219, -8237, 2566, -9744, -2962, -5418, 640, 4473, 8183, 2776},57718);
        test(new int[]{-27, -25, -6, -24, 24, -28, 2, -10, 21, -21, -10, -10, -16, -30, -4, -25, 6, -26, -11, -3, 25, -25, -22, 18, -29, 25, 4, -14, 21, 16, -10, 18, -18, 7, 2, 19, -11, -6, 16, 1, 11, 8, 10, 24, -1, 10, -8, -29, 16, -19, 20, 25, 10, -20, -10, -7, -26, -3, 4, -10, -19, -25, 8, -30, -9, -17, 2, 14, 25, 8, 30, 28, 8, -16, -1, -20, 30, -3, 15, -28, -22, -19, -15, -9, -14, -4, -5, -24, -27, -9, -25, -4, -30, 2, -26, 12, -6, 30, -14, -2, 15, -10, -9, 8, 29, 23, -5, 13, 11, -8, -16, -26, 23, -27, 1, 2, -22, 10, 25, 17, -7, -23, 29, 1, 8, 18, -7, -27, -22, 10, -9, 23, 15, 29, 10, -12, 18, -29, 1, 23, 1, -22, 0, 3, -8, 24, -10, -14, 0, -18, -11, -6, 27, -26, -18, -18, 30, 24, -19, 4, -25, -11, -10, 2, 26, 19, 2, 17, -1, 14, 17, -15, 20, 5, -1, -6, -17, 0, -23, 8, 24, 18, 7, 0, 12, -23, -27, 22, -8, 10, -5, -9, 16, -10, 15, 20, -19, 29, -27, -5, 0, 20, -20, 4, -8, 26, -23, -14, 20, -11, 27, -27, -7, -24, 4, 28, -11, 9, -14, -4, 4, -15, 12, 0, 25, -14, 28, -19, -29, 10, 14, -1, -28, 30, -22, 23, 24, -17, 22, -2, 24, 24, 17, -13, 5, 29, -11, -7, 11, -27, -15, -20, -5, -5, 7, 0, -20, -28, 2, 16, 26, 21, -12, 22, -2, -13, -25, -3, 3, -13, -19, 27, -26, 27, -6, 18, -24, 4, 16, -4, -9, 0, -19, -18, -16, -28, 25, -26, 26, -30, 10, 3, -28, 27, 14, 23, -4, -13, -19, -24}, 262);
    }

    private static void test(int[] is, int i) {
        int result = new MaxDoubleSliceSum().solution(is);
        System.out.println(String.format("ok: %s result: %s expected: %s",
                (result == i), result, i));
    }

//    https://codility.com/demo/results/demoAEVPTR-VCX/
    public int solution(int[] A) {

        int[] maxSubTo = new int[A.length - 2];
        int[] maxSubFrom = new int[A.length - 2];

        for (int i = 1; i < A.length - 2; i++)
            maxSubTo[i] = Math.max(0, maxSubTo[i - 1] + A[i]);

        for (int i = maxSubFrom.length-1; i>0; i--)
            maxSubFrom[i-1] = Math.max(0, maxSubFrom[i] + A[i+1]);

        int result = 0;
        for (int i = 0; i < maxSubFrom.length; i++)
            result = Math.max(result, maxSubFrom[i] + maxSubTo[i]);

        return result;
    }
}
