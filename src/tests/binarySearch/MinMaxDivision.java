package tests.binarySearch;

/**
 * Created by meidis on 27/11/14.
 */
public class MinMaxDivision {


    public static void main(String[] args) {
        test(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2}, 6);
    }

    private static void test(int k, int m, int[] in, int expected) {
        int result = new MinMaxDivision().solution(k, m, in);
        System.out.println(String.format("%s: result: %s expected: %s", (result == expected), result, expected));
    }

    // time O(N*log(N+M))
    // space O(1)
    public int solution(int K, int M, int[] A) {

        if(M == 0) return 0;
        if(K == A.length) return M;

        int total = 0;
        for(int i : A) total += i;

        int minStep = Math.min(M, total / K);
        System.out.println(minStep);

        int minMax = 0;
        int currentMax = 0;
        for(int i : A) {
            if(i == M)
                currentMax = 0;

            currentMax += i;
            if(currentMax > minStep) {
                minMax = Math.max(minMax, currentMax);
                currentMax = 0;
            }
        }

        return minMax;
    }
}
