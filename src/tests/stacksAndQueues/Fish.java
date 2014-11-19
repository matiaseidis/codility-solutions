package tests.stacksAndQueues;

public class Fish {
	
	public int solution(int[] A, int[] B) {
		int count = 0;

		int left = 0;
		int right = 1;
		
		while(right < A.length){
			
			int P = A[left];
			while(A[right] < 0) right++;
				
			int Q = A[right];
			
			System.out.println("P: " + P + " Q: " + Q);
			
			if(B[left] == 1 && B[right] == 0) {
				if (P > Q) {
					System.out.println("aca");
					A[right] = -1 * A[right]; // then P eats Q, and P will still be flowing downstream,
					right++;
				}
				else if (Q > P) {
					System.out.println("alla");
//					A[left] = -1 * A[left]; // then Q eats P, and Q will still be flowing upstream.
					left = right;
					right++;
				} 
				else System.out.println("nono");
			} else {
				right++;
			}
		}
		
		for(int i : A) {
			if(i>0) count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		test(new int[]{4,3,2,1,5},new int[]{0,1,0,0,0}, 2);
	}

	private static void test(int[] is, int[] is2, int expected) {
		int result = new Fish().solution(is, is2);
		System.out.println(String.format("result: %S - expected: %s", result, expected));
	}
}

