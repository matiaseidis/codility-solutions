package tests;
//https://codility.com/demo/results/demo64HBRS-MCQ/
public class CountDiv {
	 public int solution(int A, int B, int K) {
	        if (B != 0 && B<K) {
					return 0;
				} else if (A == B) {
					return (A%K == 0) ? 1 : 0;
				} else if (A != 0 && A < K) {
					A = K;
				}
				int from = (A % K == 0) ? A : A + (K-(A % K));
				int range = (B-from);
				int diff = 0;
				if (B % K == 0) diff++;
				return (range / K) + (range % K == 0 ? 0 : 1) + diff;
	    }
}
