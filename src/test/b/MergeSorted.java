package test.b;

import java.util.Arrays;

public class MergeSorted {
	
	public static void main(String[] args) {
		test(
				new long[]{1,1,1,2,2,3,6,7,8,9}, 
				new long[]{1,2,3},
				new long[]{1,6,7,9},
				new long[]{1,2,8}
				);
	}

	private static void test(long[] expected, long[]... input) {
		long[] result = new MergeSorted().solution(expected, input);
		System.out.println(Arrays.equals(result, expected));
	}

	public long[] solution(long[] expected, long[]... input) {
		long max = 100000000000000L;
		int[] counters = new int[input.length];
		int total  = 0;
		for(long[] i : input) total += i.length;
		long[] result = new long[total];
		
		for(int i = 0; i < total; i++) {
			
			int minIndex = -1;
			long minVal = max;
			for(int j = 0; j<input.length; j++) {
				if(counters[j] == input[j].length) 
					continue;
				long current = input[j][counters[j]];
				if(current < minVal) {
					minVal = current;
					minIndex = j;
				}
			}
			result[i] = minVal;
			counters[minIndex]++;
		}
		return result;
	}

}
