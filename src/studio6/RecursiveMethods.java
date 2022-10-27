package studio6;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
		if (n == 0) {
			return 0;
		} else {
			return Math.pow(0.5, n) + geometricSum(n - 1);
		}
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		} else {
			return gcd(q, p % q);
		}
	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reversed = Arrays.copyOf(array, array.length);
//		int[] reversed = new int[array.length]; // this will create just an empty array, not the copy of the original one.
		return toReversedHelper(reversed, reversed.length - 1);
	}
	
	public static int[] toReversedHelper(int[] array, int index) {
		if (index < array.length / 2) {
			return array;
		} else {
			
			// Setting
			int lastIndex = array.length - 1;
			int mirrorIndex = lastIndex - index;
			
			// Swap
			int temp = array[index];
			array[index] = array[mirrorIndex];
			array[mirrorIndex] = temp;
			return toReversedHelper(array, index - 1);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		if (radius > radiusMinimumDrawingThreshold) {
			StdDraw.circle(xCenter, yCenter, radius);
			circlesUponCircles(xCenter, yCenter + radius, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter + radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
		}
	}
}
