package �㷨.����.ֱ�Ӳ�������;

public class ֱ�Ӳ������� {
	public static void main(String[] args) {
		char[] arr = {
			'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'	
		};
		
		int N = arr.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j>0&&arr[j]<arr[j-1]; j--) {
				swap(arr, j, j-1);
			}
		}
		traverse(arr);
	}
	
	private static void swap(char[] arr, int swapAIndex, int swapBIndex) {
		char t;
		t = arr[swapAIndex];
		arr[swapAIndex] = arr[swapBIndex];
		arr[swapBIndex] = t;
	}
	
	private static void traverse(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			System.out.println(c);
		}
	}
	
}
