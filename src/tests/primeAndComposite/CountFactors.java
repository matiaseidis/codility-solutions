package tests.primeAndComposite;

/**
 * Created by meidis on 20/11/14.
 */
//A positive integer D is a factor of a positive integer N if there exists an integer M such that N=D*M.
//        For example,6is a factor of 24,because M=4satisfies the above condition(24=6*4).
//        Write a function:
//
//class Solution {
//    public int solution(int N);
//}
//        that,given a positive integer N,returns the number of its factors.
//        For example,given N=24,the function should return 8,because 24has 8factors,
//        namely 1,2,3,4,6,8,12,24.There are no other factors of 24.
//        Assume that:
//        N is an integer within the range[1..2,147,483,647].
//        Complexity:
//        expected worst-case time complexity is O(sqrt(N));
//        expected worst-case space complexity is O(1).

public class CountFactors {

    public static void main(String[] args) {
        test(24, 8);
    }

    private static void test(int i, int expected) {
        int result = new CountFactors().solution(i);
        System.out.println(result + " " + (result == expected));
    }

    public int solution(int N) {
        int result = 0;
        int i = 0;
        while(++i * i < N)
            if (N % i == 0)
                result += 2;
        if (i * i == N)
            result += 1;

        return result;
    }
}
