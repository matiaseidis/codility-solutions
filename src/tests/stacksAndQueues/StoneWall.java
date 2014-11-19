package tests.stacksAndQueues;

import java.util.Stack;

public class StoneWall {
	
	public int solution(int[] input) {
		
		int count = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i : input) {
			while(!stack.isEmpty() && stack.peek() > i) stack.pop();
			if(stack.isEmpty() || stack.peek() != i){
				stack.add(i);
				count++;
			}
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		test(new int[]{8,8,5,7,9,8,7,4,8}, 7);
	}

	private static void test(int[] input, int expected) {
		int result = new StoneWall().solution(input);
		System.out.println(String.format("result: %s expected: %s", result, expected));
	}
	
	
	

}
