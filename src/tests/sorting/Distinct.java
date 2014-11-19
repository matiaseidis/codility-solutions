package tests.sorting;
//https://codility.com/demo/results/demo5GWM3K-9B5/
public class Distinct {
	public int solution(int[] A) {
   		if(A.length == 0) return 0;
	
	java.util.Arrays.sort(A);
	
	int current = A[0];
	int distinct = 1;
	
	for(int i : A) {
		if(current != i){
			distinct++;
			current = i;
		}
	}

	return distinct;
}
}
