package tests.maxslice;

import java.util.Arrays;

public class MaxProfit {

	public static void main(String[] args) {
		test(new int[] { 23171, 21011, 21123, 21366, 21013, 21367 }, 356);
		test(new int[] { 5, 4, 3, 2, 1 }, 0);
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

//		https://codility.com/demo/results/demo2SV3P9-5TY/

		if (A == null || A.length < 2)
			return 0;

		int q = -1;
		int p = 0;
		int maxProfit = 0;
		while (++q < A.length && p != A.length - 1) {
			if (p == q) {
//				while (p != A.length - 1) {
//					int currentBest = ++p;
//					while (++currentBest < A.length)
//						if (A[currentBest] >= A[p])
//							p = currentBest;
//				}
				
//				if (p == A.length - 1)
//					break;
//				else {
					int currentBest = ++p;
					while (++currentBest < A.length)
						if (A[currentBest] >= A[p])
							p = currentBest;
//				}
			}

			int profit = A[p] - A[q];
			if (profit > maxProfit)
				maxProfit = profit;
		}

		return maxProfit;
	}

}
