package tests.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by meidis on 28/11/14.
 */
public class EquiLeader {

    public static void main(String[] args) {
        test(new int[]{4,3,4,4,4,2},2);
    }

    static void test(int[] in, int expected){
        int result = new EquiLeader().solution(in);
        System.out.println(String.format("%s, result %s expected: %s", (result == expected), result, expected));

    }


    int solution(int A[]) {

        Map<Integer, Integer> counters = new HashMap<Integer, Integer>();
        for(int i : A) {
            Integer count = counters.get(i);
            counters.put(i, count == null ? 1 : ++count);
        }

        int leader = Integer.MIN_VALUE;
        int leaderTimes = 0;
        for(Map.Entry<Integer, Integer> e : counters.entrySet())
            if(leaderTimes < e.getValue()) {
                leader = e.getKey();
                leaderTimes = e.getValue();
            }

        int count = 0;
        double left = 0;
        double right = leaderTimes;
        for(int i = 0; i<A.length; i++) {
            if(A[i] == leader) {
                left++;
                right--;
            }
            double halfRightLength = (A.length-i-1)/2.0;
            double halfLeftLength = (i + 1)/2.0;
            if(left > halfLeftLength && right > halfRightLength)
                count++;
        }
        return count;
    }
}
