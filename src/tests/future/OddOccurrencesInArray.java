package tests.future;

import java.util.Arrays;

/**
 * Created by meidis on 08/06/15.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        return Arrays.stream(A).boxed().reduce((a, b) -> a ^ b).get();
    }

    public static void main(String[] args) {
        System.out.println(new OddOccurrencesInArray().solution(new int[]{9,3,9,3,9,7,9}));
    }


}
