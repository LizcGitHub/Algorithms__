package �㷨.����.util;

public class SortUtil {
	/**
	 * �õ�һ������(�Ӵ�С������)
	 * @return
	 */
	public static int[] getInitDisorderArr() {
		int[] arr = {
				9, 8, 7, 6, 5, 4, 3, 2, 1	
			};
		return arr;
	}
	public static void traverse(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int ele = arr[i];
			System.out.println(ele);
		}
	}
	public static void traverse(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			System.out.println(c);
		}
	}
}
