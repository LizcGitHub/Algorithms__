package �㷨.����.�鲢����;

import �㷨.����.util.SortUtil;


/**
 * �鲢����
 */
public class MergeSortTest1 {
	/**
	 * ԭ�ع鲢����
	 * 	ȡ��������������(���ȸ�Ϊ�����鳤�ȵ�һ��)�����ϵ�ȡ��С��Ԫ��
	 * 		���С���ұ�   ȡ���
	 * 		��ߴ����ұ�   ȡ�ұ�  
	 * 	ǰ�᣺
	 * 		���������� ���뱾�� ����
	 */
	public void merge(int[] arr, int lo, int mid, int hi) {
		//��Ҫһ����������
		int[] aux = new int[arr.length];
		for (int i = 0; i < arr.length; i++) 
			aux[i] = arr[i];
		//
		int l = lo, r = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if 	   (l > mid) 			arr[k] = aux[r++];			//�����ȡ�꣬�Ǿ�ȡ�ұ߰� 
			else if(r > hi) 			arr[k] = aux[l++];
			else if(aux[l] < aux[r])	arr[k] = aux[l++];
			else 						arr[k] = aux[r++]; 
		}
	}
	/**
	 * �Զ����¹鲢����
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
	 * �Ե׶��ϵĹ鲢����
	 * 	�Ƚ�����С����(���鳤��sz=1)�鲢Ϊһ�����鳤��Ϊ2������
	 * 		�ٽ���������(����sz=2)�鲢Ϊһ�����鳤��Ϊ4������
	 * 			��....8
	 * 				��....16
	 * 					��.....
	 * sz : �����鲢��ÿ��С���鳤��
	 * 62��ע��
	 * 		�����һ�ι鲢ʱ �ڶ������鳤�Ȼ�С�ڵ�һ������,����hiֱ��ȡN-1
	 */
	public void sort(int[] arr) {
		int N = arr.length;               				//N:���鳤��
		for(int sz = 1; sz < N; sz *= 2)				//ÿ�ι鲢���鳤������Ϊԭ��������
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
