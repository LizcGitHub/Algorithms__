package 算法.排序.归并排序;

import 算法.排序.util.SortUtil;


/**
 * 归并排序
 */
public class MergeSortTest1 {
	/**
	 * 原地归并排序
	 * 	取左右两个子数组(长度各为总数组长度的一半)，不断地取较小的元素
	 * 		左边小于右边   取左边
	 * 		左边大于右边   取右边  
	 * 	前提：
	 * 		两个子数组 必须本身 有序
	 */
	public void merge(int[] arr, int lo, int mid, int hi) {
		//需要一个副本数组
		int[] aux = new int[arr.length];
		for (int i = 0; i < arr.length; i++) 
			aux[i] = arr[i];
		//
		int l = lo, r = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if 	   (l > mid) 			arr[k] = aux[r++];			//左边已取完，那就取右边吧 
			else if(r > hi) 			arr[k] = aux[l++];
			else if(aux[l] < aux[r])	arr[k] = aux[l++];
			else 						arr[k] = aux[r++]; 
		}
	}
	/**
	 * 自顶而下归并排序
	 * @param arr
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public void sort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int l = lo, mid = lo + (hi - lo) / 2;
		sort (arr, l, 		mid);
		sort (arr, mid + 1, hi);
		merge(arr, lo, mid, hi);
	}
	
	/**
	 * 自底而上的归并排序
	 * 	先将两个小数组(数组长度sz=1)归并为一个数组长度为2的数组
	 * 		再将两个数组(长度sz=2)归并为一个数组长度为4的数组
	 * 			再....8
	 * 				再....16
	 * 					再.....
	 * sz : 两两归并的每个小数组长度
	 * 62行注：
	 * 		当最后一次归并时 第二个数组长度会小于第一个数组,所以hi直接取N-1
	 */
	public void sort(int[] arr) {
		int N = arr.length;               				//N:数组长度
		for(int sz = 1; sz < N; sz *= 2)				//每次归并数组长度扩大为原来的两倍
			for(int lo = 0; lo + sz < N; lo += sz*2) 						
				merge(arr, lo, lo+sz-1, Math.min(lo+2*sz-1, N-1));
	}
	
	public static void main(String[] args) {
		MergeSortTest1 mergeSort = new MergeSortTest1();
		int[] arr = {
			9, 8, 7, 6, 5, 4, 3, 2, 1	
		};
//		mergeSort.sort(arr, 0, arr.length - 1);
		mergeSort.sort(arr);
		SortUtil.traverse(arr);
	}
}
