package tests.prefixSums;
//https://codility.com/demo/results/demo4WVDGQ-5VJ/
public class PassingCars {
	public int solution(int[] A) {
        		long results = 0;
		long zeroCount = 0;
		long partial = 0;
		long current = -1;
		long max = 1000000000;

		for (long i = 0; i < A.length; i++) {

			current = A[(int)i];
			if(zeroCount != 0) {
				if (current == 0) {
					results += (zeroCount * partial);
					if(results > max) {
						return -1;
					}
					partial = 0;
				} else {
					partial++;
				}
			}
			if (current == 0) {
				zeroCount++;
			}
		}
		if(current != 0) {
			results += (zeroCount * partial);
		}
		if(results > max) {
			return -1;
		}
		return (int)results;
    }
}
