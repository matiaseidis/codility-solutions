package tests.countingElements;
//https://codility.com/demo/results/demo77N3UJ-YFR/
public class MaxCounters {
	public int[] solution(int N, int[] A) {
        		int[] target = new int[N];
		int max = 0;
		int maxUpdatesFromLastMaxCounterCall = 0;
		boolean flushNeeded = false;
		
		for(int i = 0; i < A.length; i++) {
			int x = A[i];
			if(x>=1 && x<=N) {
				//increase
				flushNeeded = true;
				int maxCandidate = ++target[x-1] + (max - maxUpdatesFromLastMaxCounterCall);
				if(maxCandidate > max) {
					max = maxCandidate; 
					maxUpdatesFromLastMaxCounterCall++;
				}
			} else if (x == N+1) {
				//maxCounter
				if(flushNeeded) {
					maxUpdatesFromLastMaxCounterCall = 0;
					target = new int[N];
					flushNeeded = false;
				}
			}
			
		}
		
		for(int i = 0; i< target.length; i++) {
			
			int floor = max - maxUpdatesFromLastMaxCounterCall; 
			target[i] += floor;
		}
		return target;
    }
}
