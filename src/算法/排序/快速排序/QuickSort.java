package �㷨.����.��������;

import �㷨.����.util.SortUtil;

/**
 * ��������: �����з�
 * 	ͨ��partition() ��ĳ����j�ŵ������е���ȷλ��,���ҷ��ظ�j	
 * 		j��������ȷλ��: j��������ߵ�������jС, j�������ұߵ�������j��
 *	Ȼ��ݹ飬����������߼�, ��j������ߵ����� �� �ұߵ���������
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
