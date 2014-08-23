package tests;
//https://codility.com/demo/results/demo9292TJ-HFZ/
public class FrogJmp {
	public int solution(int X, int Y, int D) {
   		int diff = Y-X;
	int ini = (diff / D);
	int extra = (diff % D) > 0 ? 1 : 0;
	return ini + extra;
}
}
