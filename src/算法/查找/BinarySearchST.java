package �㷨.����;


/**
 * �����������ĸ˳�� ������ ����˳�򣨶��ַ�Ҫ��Ԫ�ر�������
 * ���ַ���ʵ��Map
 * @author Administrator
 * @param <K>
 * @param <V>
 */
public class BinarySearchST<K extends Comparable<K>, V>{
	private K[] mKeys;
	private V[] mVals;
	private int N;               	//���ڼ�¼��Map��Ԫ�صĸ���
	public BinarySearchST(int capacity) {
		mKeys = (K[]) new Comparable[capacity];
		mVals = (V[]) new Object[capacity];
	}
	public int size() {return N;}
	/*
	 * ���ֲ��ң��ǵݹ�ʵ��
	 * ע��rank	
	 * 		1.���ز��ҵ���Ԫ�ص�����
	 * 		2.(��Ϊ����������0��ʼ���ÿ���ʵ��)���ظ�Kǰ������K�ĸ���
	 */
	public int rank(K targetK) {
		int lo = 0, hi = N - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int comResult = compareWith(mid, targetK);
			if(comResult < 0) lo = mid + 1;
			else if (comResult > 0) hi = mid - 1;
			else return mid;                     		//�ҵ�
		}
		/*
		 * ����û���ҵ���	
		 * 	���ҷ��������ҵ����������������������put()����Ȼ���Ա�������
		 */
		return lo;
	}
	
	
	public void put(K targetK, V val) {
		int index = rank(targetK);
		//�ҵ��������update
		if (index < N
				&& compareWith(index, targetK) == 0) 
			mVals[index] = val;
		else {
			/*
			 *��������������N������ �ͱ�ɰ��� ����˳��������(�����λ����Զ���������һλ)
			 * 	���ַ�Ҫ�����鰴����ĸ(Ԫ��)˳��
			 * 	���ԣ����ǵ�put����ҲҪ��֤put��������Ȼ��ĸ��(Ԫ��)����comparable����
			 */
//			mKeys[N] = targetK;
//			mVals[N] = val;
//			N++;
			/*
			 * Ҫʵ�ֲ���� ��Ȼ�������Ҫ���ʵ�(���һ�β���)��λ�ò���
			 * 		rand�������������һ�β��ҵ�λ��index
			 * 	�������������  ����ʱ ���������������Ԫ�ض�����ƶ�һ��
			 */
			for(int j = N; j > index; j--) {
				mKeys[j] = mKeys[j - 1];
				mVals[j] = mVals[j - 1];
			}
			//����
			mKeys[index] = targetK;
			mVals[index] = val;
			N++;
		}
	}
	
	public V get(K targetK) {
		int index = rank(targetK);
		if (N == 0) 
			return null;
		if (index < N && 
				compareWith(index, targetK) == 0) 
			return mVals[index];
		return null;
	}
	
	public void traverse(String comment) {
		System.out.println("\n--"+comment);
		for (int i = 0; i < mKeys.length 
				&& mKeys[i] != null; i++) {
			K k = mKeys[i];
			V v = mVals[i];
			System.out.println("K:"+k+"..K:"+v);
		}
	}
	
	private int compareWith(int index, K targetK) {
		return mKeys[index].compareTo(targetK);
	}
	
	public static void main(String[] args) {
		BinarySearchST<String, String> myMap =
					new BinarySearchST<>(10);
		myMap.traverse("δ���Ԫ�ص�����£�"); 
		myMap.put("A", "A");	          myMap.traverse("Put A������£�");
		myMap.put("B", "B");	          myMap.traverse("Put B������£�");
		myMap.put("E", "E");	          myMap.traverse("Put E������£�");
		myMap.put("F", "F");	          myMap.traverse("Put F������£�");
		
		myMap.put("B", "X");	          myMap.traverse("Update B�������(�ص�)��");
		
		myMap.put("C", "C");              myMap.traverse("Put C�������(�ص�)��");
		
		myMap.traverse("GET B������£�");  System.out.println("\n--Get B������£�\n"+myMap.get("B"));	         
	}
}
