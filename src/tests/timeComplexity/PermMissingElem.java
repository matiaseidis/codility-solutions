package tests.timeComplexity;

// https://codility.com/demo/results/demoH5RK93-GYW/
public class PermMissingElem {
	
	public int solution(int[] A) {
		int sum = 0;
		int fact = 0;

		for (int i : A) {
			sum += i;
		}

		for (int i = 1; i <= A.length + 1; i++) {
			fact += i;
		}

		return fact - sum;
	}
}
