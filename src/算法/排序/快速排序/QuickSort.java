package 算法.排序.快速排序;

import 算法.排序.util.SortUtil;

/**
 * 快速排序: 二向切分
 * 	通过partition() 将某个数j放到数组中的正确位置,并且返回该j	
 * 		j在数组正确位置: j的索引左边的数都比j小, j的索引右边的数都比j大
 *	然后递归，依照上面的逻辑, 对j索引左边的数组 和 右边的数组排序
 */
public class QuickSort {
	
	public void sort(int[] arr, int lo, int hi) {
		int j = partition(arr);
		sort(arr, lo, j - 1);
		sort(arr, j + 1, hi);
	}
	
	public int partition(int[] arr) {
		return 0;
	}
	
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] arr = SortUtil.getInitDisorderArr();
		quickSort.sort(arr, 0, arr.length - 1);
	}
}
