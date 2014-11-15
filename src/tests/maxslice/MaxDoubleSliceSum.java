package tests.maxslice;

public class MaxDoubleSliceSum {

	public static void main(String[] args) {
		test(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }, 17);
	}

	private static void test(int[] is, int i) {
		int result = new MaxDoubleSliceSum().solution(is);
		System.out.println(String.format("ok: %s result: %s expected: %s",
				(result == i), result, i));
	}

	public int solution(int[] A) {

		if (A == null | A.length < 4)
			return 0;

		int x = 0;
		int y = 1;
		int z = 2;
		int maxSum = Integer.MIN_VALUE;

		int left = 0;
		int right = 0;

		while (++z < A.length) {
			right += A[z - 1];
			while (++y < z) {
				left += A[y - 1];
				if (y != z - 1)
					right -= A[y];
				int sum = left + right;
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		left = 0;
		right= 0;
		x = A.length-3;
		while (--x >= 0) {
			left += A[x+1];
			while (--y > x) {
				right += A[y+1];
				if (y != x - 1)
					left -= A[y];
				int sum = left + right;
				if (sum > maxSum)
					maxSum = sum;
			}
		}


		return maxSum;
	}

}
