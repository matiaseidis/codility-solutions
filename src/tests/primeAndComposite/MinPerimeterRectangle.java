package tests.primeAndComposite;

/**
 * Created by meidis on 20/11/14.
 */
//        An integer N is given, representing the area of some rectangle.
//        The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
//        The goal is to find the minimal perimeter of any rectangle whose area equals N.
//        The sides of this rectangle should be only integers.
//        For example, given integer N = 30, rectangles of area 30 are:
//        (1, 30), with a perimeter of 62,
//        (2, 15), with a perimeter of 34,
//        (3, 10), with a perimeter of 26,
//        (5, 6), with a perimeter of 22.
//        Write a function:
//        class Solution { public int solution(int N); }
//        that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly
//        equal to N.
//        For example, given an integer N = 30, the function should return 22, as explained above.
//        Assume that:
//        N is an integer within the range [1..1,000,000,000].
//        Complexity:
//        expected worst-case time complexity is O(sqrt(N));
//        expected worst-case space complexity is O(1).
public class MinPerimeterRectangle {

    public static void main(String[] args) {
        test(30,22);
        test(101, 204);
    }

    private static void test(int i, int expected) {
        int result = new MinPerimeterRectangle().solution(i);
        System.out.println(result + " " + (result == expected));
    }

//    https://codility.com/demo/results/demoFXS4Y5-P5U/
    public int solution(int area) {

        int minPerimeter = Integer.MAX_VALUE;

        for(int i = 1; i*i<=area; i++)
            if(area % i == 0)
                minPerimeter = Math.min(2 * (i + area/i), minPerimeter);

        return minPerimeter;
    }
}
