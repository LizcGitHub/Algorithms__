package �㷨.����.������;

import java.util.Random;

/**
 * ������Demo1��
 * 	
 */
public class HeapDemo1 {
	public static void main(String[] args) {
		Random random = new Random();
		//�����һ��Ԫ�ز���
		int[] arr = {-1, 8, 7, 6, 5, 4};
		//������Ϊ5(4)����swim
		sink(arr, 1, 5);
		print(arr);
	}
	
	/**
	 * �ϸ�:
	 * 	����/2
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
	//������һ����  �����ϱ�׼��
	public static void swim(int[] arr, int target) {
		while (target > 1 
					&& arr[target/2]<arr[target]) {
			swap(arr, target, target/2);
			target = target / 2;
		}
	}
	
	
	/**	Ŀ�꣺С����       k*2 �� k*2+1
	 * @param arr
	 * @param k		��Ҫsink��Ԫ������
	 * @param N		�����ܳ��� 
	 */
	public static void  sink(int[] arr, int k, int N) {
		while(k*2 <= N) {					//�����������1��ʼ 
			int j = k * 2;
			if (j<N && arr[j]<arr[j+1]) j++;
			if (arr[j]>arr[k]) break;  		//�����ǰ�ڵ��Ѿ����ӽڵ�С�ˣ��Ͳ��ý�����
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
