package tests;
//https://codility.com/demo/results/demoB7EJZT-BD7/
public class Triangle {
	public int solution(int[] A) {
        java.util.Arrays.sort(A);
		
		for(int i = 0;  i<A.length-2; i++) {
			if(((long)A[i] + (long)A[i+1]) > A[i+2]) return 1;
		}
		return 0;
    }
}
