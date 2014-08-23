package tests;
//https://codility.com/demo/results/demoEYUJ8V-FVP/
public class MaxProductOfThree {
	public int solution(int[] A) {
        if(A.length == 0) return 0;
		if(A.length == 1) return A[0];
		if(A.length == 2) return A[0]*A[1];

		java.util.Arrays.sort(A);
		
		int first = A[0]*A[1]*A[A.length-1];
		int second = A[A.length-1]*A[A.length-2]*A[A.length-3];
		return (first>second) ? first : second;
    }
}
