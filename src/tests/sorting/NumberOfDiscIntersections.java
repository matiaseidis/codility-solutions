package tests.sorting;
//https://codility.com/demo/results/demo3Y2NXD-A38/

public class NumberOfDiscIntersections {
	public int solution(int[] A) {
        
        if (A.length == 0) return 0;

		long[] openIndexes = new long[A.length];
		long[] closeIndexes = new long[A.length];
		boolean[] timeLine = new boolean[A.length * 2];

		for (int i = 0; i < A.length; i++) {
			openIndexes[i] = i - (long) A[i];
			closeIndexes[i] = i + (long) A[i];
		}
		
		java.util.Arrays.sort(openIndexes);
		java.util.Arrays.sort(closeIndexes);
		
		for (int i = 0, openIndex = 0, closeIndex = 0; i < timeLine.length; i++) {

			timeLine[i] = (openIndex == A.length) 
							? false
							: (closeIndex == A.length) 
								? true
								: openIndexes[openIndex] <= closeIndexes[closeIndex];
			
			if (timeLine[i])
				openIndex++;
			else
				closeIndex++;
		}

		int open = 0;
		int intersections = 0;
		
		for (int i = 0; i < timeLine.length; i++)
			if (timeLine[i])
				intersections += open++;
			else
				open--;

		return intersections > 10000000 ? -1 : intersections;
    }
}
