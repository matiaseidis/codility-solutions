package tests;

import java.util.Arrays;

/**
 * Created by meidis on 21/11/14.
 */
public class Nuevo {

    public static void main(String[] args) {
        test(new int[]{3,4,5,6,7,8,9,1,2}, 3, new int[]{7,8,9});
        test(new int[]{}, 0, new int[]{});
    }

    private static void test(int[] in, int k, int[] expected) {
        int[] result = new Nuevo().solution(in, k);
        System.out.println(Arrays.equals(result, expected) + " " + Arrays.toString(result));
    }

    // n = in.length
    // k = k
    // t = O(n+k)
    // s = O(k)
    public int[] solution(int[] in, int k) {
        if(k < 0 || in == null || in.length<k)
            throw new RuntimeException("invalid input");

        int kSum = 0;

        for(int i = 0; i<k; i++)
            kSum += in[i];

        int maxSum = kSum;
        int maxSumStart = 0;
        int maxSumEnd = k;

        for(int i = k+1; i< in.length; i++) {
            kSum -= in[i-k-1];
            kSum += in[i];
            if(kSum > maxSum) {
                maxSum = kSum;
                maxSumStart = i-k+1;
                maxSumEnd = i+1;
            }
        }

        return Arrays.copyOfRange(in, maxSumStart, maxSumEnd);
    }
}
