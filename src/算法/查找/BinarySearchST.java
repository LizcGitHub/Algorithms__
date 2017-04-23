package 算法.查找;


/**
 * 有序表：按照字母顺序 而不是 插入顺序（二分法要求元素本身有序）
 * 二分法：实现Map
 * @author Administrator
 * @param <K>
 * @param <V>
 */
public class BinarySearchST<K extends Comparable<K>, V>{
	private K[] mKeys;
	private V[] mVals;
	private int N;               	//用于记录本Map中元素的个数
	public BinarySearchST(int capacity) {
		mKeys = (K[]) new Comparable[capacity];
		mVals = (V[]) new Object[capacity];
	}
	public int size() {return N;}
	/*
	 * 二分查找：非递归实现
	 * 注：rank	
	 * 		1.返回查找到的元素的索引
	 * 		2.(因为数组索引从0开始正好可以实现)返回该K前的所有K的个数
	 */
	public int rank(K targetK) {
		int lo = 0, hi = N - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int comResult = compareWith(mid, targetK);
			if(comResult < 0) lo = mid + 1;
			else if (comResult > 0) hi = mid - 1;
			else return mid;                     		//找到
		}
		/*
		 * 代表没有找到。	
		 * 	并且返回最后查找的索引，这样根据这个索引put()后，依然可以保持有序
		 */
		return lo;
	}
	
	
	public void put(K targetK, V val) {
		int index = rank(targetK);
		//找到的情况：update
		if (index < N
				&& compareWith(index, targetK) == 0) 
			mVals[index] = val;
		else {
			/*
			 *下面这样在索引N处插入 就变成按照 插入顺序排列了(插入的位置永远是数组最后一位)
			 * 	二分法要求数组按照字母(元素)顺序
			 * 	所以，我们的put操作也要保证put后数组依然字母表(元素)按照comparable有序
			 */
//			mKeys[N] = targetK;
//			mVals[N] = val;
//			N++;
			/*
			 * 要实现插入后 依然有序就需要在适当(最后一次查找)的位置插入
			 * 		rand方法返回了最后一次查找的位置index
			 * 	类似于链表插入  插入时 插入索引后的所有元素都向后移动一格
			 */
			for(int j = N; j > index; j--) {
				mKeys[j] = mKeys[j - 1];
				mVals[j] = mVals[j - 1];
			}
			//插入
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
		myMap.traverse("未添加元素的情况下："); 
		myMap.put("A", "A");	          myMap.traverse("Put A的情况下：");
		myMap.put("B", "B");	          myMap.traverse("Put B的情况下：");
		myMap.put("E", "E");	          myMap.traverse("Put E的情况下：");
		myMap.put("F", "F");	          myMap.traverse("Put F的情况下：");
		
		myMap.put("B", "X");	          myMap.traverse("Update B的情况下(重点)：");
		
		myMap.put("C", "C");              myMap.traverse("Put C的情况下(重点)：");
		
		myMap.traverse("GET B的情况下：");  System.out.println("\n--Get B的情况下：\n"+myMap.get("B"));	         
	}
}
