package tests;

//https://codility.com/demo/results/demoVHPHYA-XRY/
public class FrogRiverOne {
	
	public int oldSolution(int[] A) {
        // write your code in Java SE 7
        		int[] target = new int[A.length];
		for(int i = 0; i< A.length; i++) {
			target[i] = 0;
		}
		
		for(int i : A) {
			if(i-1 < 0) return 0;
			if(i > A.length) return 0;
			if(target[i-1] > 0) return 0;
			target[i-1] = 1; 
		}
		
		for(int i : target) {
			if (i == 0) return 0;
		}
		return 1;
    }
	
	public int solution(int X, int[] A) {
		int[] positionsToCover = new int[X];
		for (int i = 0; i < positionsToCover.length; i++) {
			positionsToCover[i] = -1;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= X && positionsToCover[A[i] - 1] == -1) {
				positionsToCover[A[i] - 1] = i;
			}
		}
		int answer = 0;
		for (int i = 0; i < positionsToCover.length; i++) {
			if (positionsToCover[i] < 0) {
				return -1;
			}

			if (answer < positionsToCover[i]) {
				answer = positionsToCover[i];
			}

		}
		return answer;
	}
}
