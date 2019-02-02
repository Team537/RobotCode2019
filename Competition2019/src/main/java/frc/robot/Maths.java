package frc.robot;

/**
 * A class that holds many various math functions.
 */
public class Maths {
	public static double PI = 3.14159265358979323846D;
	public static double DEGREES_IN_CIRCLE = 360.0D;
	public static double DEGREES_IN_HALF_CIRCLE = 180.0D;
	public static double ANG2RAD = PI / DEGREES_IN_HALF_CIRCLE;
	public static double LOG_HALF = Math.log(0.5D);

	/**
	 * Gets the maximum value.
	 *
	 * @param fs The values to sort though.
	 * @return The maximum value.
	 */
	public static double maxValue(double... fs) {
		double max = Double.MIN_VALUE;

		for (double v : fs)
			if (v > max)
				max = v;

		return max;
	}

	/**
	 * Gets the minimum value.
	 *
	 * @param fs The values to sort though.
	 * @return The minimum value.
	 */
	public static double minValue(double... fs) {
		double min = Double.MAX_VALUE;

		for (double v : fs)
			if (v < min)
				min = v;

		return min;
	}

	/**
	 * Gets if a value is near to the target.
	 *
	 * @param value	The current value reading.
	 * @param target The target to get to.
	 * @param tolerance The allowed tolerance.
	 * @return If the value is acceptable under the tolerance.
	 */
	public static boolean nearTarget(double value, double target, double tolerance) {
		return Math.abs(value - target) < tolerance;
	}

	/**
	 * Normalizes a angle into the range of 0-360.
	 *
	 * @param angle The source angle.
	 * @return The normalized angle.
	 */
	public static double wrapDegrees(double angle) {
		double result = angle % 360.0F;
		
		if (result < 0.0f)
			result += 360.0F;

		return result;
	}
	
	/**
	 * Rounds a value to a amount of places after the decimal point.
	 *
	 * @param value The value to round.
	 * @param place How many places after the decimal to round to.
	 * @return The rounded value.
	 */
	public static float roundToPlace(float value, int place) {
		float placeMul = (float) (Math.pow(10.0F, place));
		return (float) Math.round((value) * placeMul) / placeMul;
	}

	/**
	 * Rounds a value to a amount of places after the decimal point.
	 *
	 * @param value The value to round.
	 * @param place How many places after the decimal to round to.
	 * @return The rounded value.
	 */
	public static double roundToPlace(double value, int place) {
		double placeMul = 1D;
		for (int i = 0; i < place; i++)
			placeMul *= 10D;
		for (int i = 0; i > place; i++)
			placeMul /= 10D;
		return Math.round((value) * placeMul) / placeMul;
	}

	/**
	 * Used to floor the value if less than the min.
	 *
	 * @param min The minimum value.
	 * @param value The value.
	 * @return Returns a value with deadband applied.
	 */
	public static double deadband(double min, double value) {
		return Math.abs(value) >= Math.abs(min) ? value : 0.0D;
	}

	/**
	 * Ensures {@code value} is in the range of {@code min} to {@code max}. If {@code value} is greater than {@code max}, this will return {@code max}. If {@code value} is less than {@code min}, this will return {@code min}. Otherwise, {@code value} is returned unchanged.
	 *
	 * @param value The value to clamp.
	 * @param min The smallest value of the result.
	 * @param max The largest value of the result.
	 * @return {@code value}, clamped between {@code min} and {@code max}.
	 */
	public static double clamp(double value, double min, double max) {
		return value < min ? min : value > max ? max : value;
	}

	/**
	 * Limits the value.
	 *
	 * @param value The value.
	 * @param limit The limit.
	 * @return A limited value.
	 */
	public static double limit(double value, double limit) {
		return value > limit ? limit : value;
	}

	/**
	 * Interpolates two values by a blendFactor using cos interpolation.
	 *
	 * @param a	The first value.
	 * @param b	The second value.
	 * @param blend The blend value.
	 * @return Returns a interpolated value.
	 */
	public static double cosInterpolate(double a, double b, double blend) {
		double ft = blend * Math.PI;
		double f = (1D - Math.cos(ft)) * 0.5D;
		return a * (1.0D - f) + b * f;
	}
}