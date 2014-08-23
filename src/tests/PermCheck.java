package tests;
//https://codility.com/demo/results/demo6PZK3G-4KX/
public class PermCheck {
	public int solution(int[] A) {
        
		int size = A.length;
		int max = 0;
		int[] countedRepo = new int[size];

		for (int i = 0; i < size; i++) {
			if (A[i] < 1 || A[i] > size) {
				return 0;
			}
			if (A[i] > max) {
				max = A[i];
			}
			if(countedRepo[A[i]-1] >= 0) {
				countedRepo[A[i]-1] = -A[i];
			} else {
				return 0;
			}
		}
		if (max != size) {
			return 0;
		}
		return 1;
    }
}
