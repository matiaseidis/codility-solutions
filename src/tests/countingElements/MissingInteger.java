package tests.countingElements;
//https://codility.com/demo/results/demoNQ4BN5-4Q2/
public class MissingInteger {
	public int solution(int[] A) {
        		boolean[] positives = new boolean[A.length];
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] > 0 && A[i] <= A.length) {
				positives[A[i]-1] = true;
			}
		}
		for (int i = 0; i < positives.length; i++) {
			if(!positives[i]) {
				return i+1;
			}
		}
		return A.length+1;
    }
}
