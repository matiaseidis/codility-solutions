package tests.stacksAndQueues;
// https://codility.com/demo/results/demoBY2HWE-E6E/
public class Nesting {
	public int solution(String S) {
        // write your code in Java SE 8
                if(S == null || S.isEmpty()) return 1;
        int openCount = 0;
        for(char i : S.toCharArray()) {
            if(i == '(') openCount++;
            else if (i == ')') {
                if(openCount == 0) return 0;
                openCount--;
            }
            else return 0;
        }

        return openCount == 0 ? 1 : 0;
    }
}
