package 算法.排序.堆排序;

import java.util.Random;

/**
 * 堆排序Demo1：
 * 	
 */
public class HeapDemo1 {
	public static void main(String[] args) {
		Random random = new Random();
		//数组第一个元素不用
		int[] arr = {-1, 8, 7, 6, 5, 4};
		//将索引为5(4)进行swim
		sink(arr, 1, 5);
		print(arr);
	}
	
	/**
	 * 上浮:
	 * 	将其/2
	 */
	public static void swim(int[] arr, int target, int N) {
		while(target > 1) {
			int k = target / 2;
			if(arr[k] < arr[target]) {
				swap(arr, k, target);
			}
			target = k;
			
		}
	}
	//和上面一样的  （书上标准）
	public static void swim(int[] arr, int target) {
		while (target > 1 
					&& arr[target/2]<arr[target]) {
			swap(arr, target, target/2);
			target = target / 2;
		}
	}
	
	
	/**	目标：小顶堆       k*2 或 k*2+1
	 * @param arr
	 * @param k		需要sink的元素索引
	 * @param N		数组总长度 
	 */
	public static void  sink(int[] arr, int k, int N) {
		while(k*2 <= N) {					//在这里数组从1开始 
			int j = k * 2;
			if (j<N && arr[j]<arr[j+1]) j++;
			if (arr[j]>arr[k]) break;  		//如果当前节点已经比子节点小了，就不用交换了
			swap(arr, j, k);
			k = j;
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
	public static void print(int[] arr) {
		for (int value : arr) {
			System.out.print(value+"..");
		}
	}
}
