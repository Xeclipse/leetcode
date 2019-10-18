package general;

/**
 * @Author: Alex.Z
 * @DATE: 2018/8/7
 * @Description:
 */
public class Utils {
	public static <T> void print2d(T[][] a) {
		for (T[] ai : a) {
			print1d(ai);
		}
	}

	public static <T> void print1d(T[] a) {
		for (T i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void print1d(int[] a) {
		if (null == a) {
			System.out.println("null");
			return;
		}
		for (int i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void print2d(boolean[][] a) {
		for (boolean[] ai : a) {
			print1d(ai);
		}
	}

	public static void print1d(boolean[] a) {
		for (boolean i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
}
