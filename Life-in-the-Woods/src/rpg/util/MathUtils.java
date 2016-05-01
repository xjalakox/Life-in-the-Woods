package rpg.util;

public class MathUtils {
	
	private MathUtils() {}
	
	public static int min(int value, int min) {
		return value < min ? min : value;
	}
	
	public static int max(int value, int max) {
		return value > max ? max : value;
	}
	
	public static int clamp(int val, int min, int max) {
		if(val < min) 
			return min;
		if(val > max)
			return max;
		return val;
	}
	
}
