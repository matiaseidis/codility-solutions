package tests.binarySearch;

import java.util.*;

/**
 * Created by meidis on 27/11/14.
 */
/*
        You are given two non-empty zero-indexed arrays A and B consisting of N integers. These arrays represent N planks.
                More precisely, A[K] is the start and B[K] the end of the K−th plank.
        Next, you are given a non-empty zero-indexed array C consisting of M integers.
                This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.
        We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].
        The goal is to find the minimum number of nails that must be used until all the planks are nailed.
                In other words, you should find a value J such that all planks will be nailed after using only the first J nails.
                More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].
        For example, given arrays A, B such that:
        A[0] = 1    B[0] = 4
        A[1] = 4    B[1] = 5
        A[2] = 5    B[2] = 9
        A[3] = 8    B[3] = 10
        four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].
        Given array C such that:
        C[0] = 4
        C[1] = 6
        C[2] = 7
        C[3] = 10
        C[4] = 2
        if we use the following nails:
        0, then planks [1, 4] and [4, 5] will both be nailed.
        0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
        0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
        0, 1, 2, 3, then all the planks will be nailed.
        Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.
        Write a function:
        class Solution { public int solution(int[] A, int[] B, int[] C); }
        that, given two non-empty zero-indexed arrays A and B consisting of N integers and a non-empty zero-indexed array C consisting of M integers,
        returns the minimum number of nails that, used sequentially, allow all the planks to be nailed.
        If it is not possible to nail all the planks, the function should return −1.
        For example, given arrays A, B, C such that:
        A[0] = 1    B[0] = 4
        A[1] = 4    B[1] = 5
        A[2] = 5    B[2] = 9
        A[3] = 8    B[3] = 10

        C[0] = 4
        C[1] = 6
        C[2] = 7
        C[3] = 10
        C[4] = 2
        the function should return 4, as explained above.
        Assume that:
        N and M are integers within the range [1..30,000];
        each element of arrays A, B, C is an integer within the range [1..2*M];
        A[K] ≤ B[K].
        Complexity:
        expected worst-case time complexity is O((N+M)*log(M));
        expected worst-case space complexity is O(M), beyond input storage (not counting the storage required for input arguments).
        Elements of input arrays can be modified.
*/

public class NailingPlanks {

    public static void main(String[] args) {
//        test(
//                new int[]{1, 4, 5, 8},
//                new int[]{4, 5, 9, 10},
//                new int[]{4, 6, 7, 10, 2},
//                4);

//                test(
//                new int[]{1, 4, 5, 8},
//                new int[]{4, 5, 9, 10},
//                new int[]{4, 6, 7, 10, 2},
//                4);

//        test(
//                new int[]{1},
//                new int[]{3},
//                new int[]{2},
//                1);

        test(
                new int[]{1},
                new int[]{3},
                new int[]{5},
                -1);
    }

    private static void test(int[] A, int[] B, int[] C, int expected) {
        int result = new NailingPlanks().solution(A, B, C);
        System.out.println(String.format("%s: result: %s expected: %s", (result == expected), result, expected));
    }

    // time  O((N+M)*log(M))
    // space O(M)
    public int solution(int[] A, int[] B, int[] C) {

        int[] c = Arrays.copyOf(C, C.length);
        Arrays.sort(c);

//        int[][] nailsByPlank = new int[C.length][];
//        Map<Integer, Set<Integer>> planksByNail = new HashMap<>();
//        for(int i : C)
//            planksByNail.put(i, new HashSet<Integer>());

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < A.length; i++) {
            // log(M)
            int from = bb(c, A[i], false);
            // log(M)
            int to = bb(c, B[i], true);
            System.out.println(from);
            System.out.println(to);

            if(to == from) return -1;

        }

        return min;
    }

    private int bb(int[] in, int elem, boolean right) {

        int lo = 0;
        int hi = in.length - 1;
        int middle = 0;
        while(lo <= hi) {
            middle = (lo + hi) / 2;
            int midVal = in[middle];
            if(midVal < elem) lo = middle + 1;
            else if (midVal > elem) hi = middle -1;
            else return middle;
        }
        return right ? Math.max(0, --lo) : Math.min(++hi, in.length-1);
    }

    // time  O((N+M)*log(M))
    // space O(M)
    private int solution2(int[] A, int[] B, int[] C) {

        int[] fullPlankSpace = new int[2 * C.length];
        for (int i = 1; i <= 2 * C.length; i++)
            fullPlankSpace[i - 1] = i;

        int remaining = A.length;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[j] > 0) {
                    int toFind = C[i];
                    int from = fullPlankSpace[A[j] - 1];
                    int to = fullPlankSpace[B[j] - 1];
                    if (toFind >= from && toFind <= to) {
                        if (--remaining == 0)
                            return ++i;
                        A[j] *= -1;
                    }
                }
            }
        }

        return -1;
    }

}
