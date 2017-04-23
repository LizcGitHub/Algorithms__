package 算法.查找;


/**
 * 无序表：按照插入顺序	而不是	字母顺序
 * 模拟Map的put和get 算法3.1 顺序查找 。。。其实就是最普通的链表遍历 用K查找V 找到就更新V 找不到就插入一个新的Node
 * 
 * @author Administrator
 */
public class SequenceSearchST<K, V> {
	// 链表首节点 
	private Node mCuurentFirst;

	private class Node {
		K k;
		V v;
		Node next;
		public Node(K k, V v, Node next) {
			super();
			this.k = k;
			this.v = v;
			this.next = next;
		}
	}

	public V get(K key) {
		for (Node p = mCuurentFirst; p != null; p = p.next)
			if (p.k.equals(key))
				return p.v;
		return null;
	}

	public void put(K key, V val) {
		for (Node p = mCuurentFirst; p != null; p = p.next) {
			if (p.k.equals(key)) {
				p.v = val;
				return;
			}
		}
		Node newNode = new Node(key, val, mCuurentFirst); 
		mCuurentFirst = newNode;                           //头插法
	}
	
	public void traverse(String comment) {
		Node p = mCuurentFirst;
		System.out.println("\n--"+comment);
		while(p!=null) {
			System.out.println("K:"+p.k+"..K:"+p.v);
			p = p.next;
		}
	}

	public static void main(String[] args) {
		SequenceSearchST<String, String> myMap =
				new SequenceSearchST<>();
		myMap.traverse("还未添加元素的情况");
		myMap.put("A", "A");    			myMap.traverse("Put \"A\"的情况");
		myMap.put("B", "B");    			myMap.traverse("Put \"B\"的情况");
		myMap.put("B", "C");    			myMap.traverse("Update \"B\"的情况");
		myMap.traverse("Get \"B\"的情况");	System.out.println(myMap.get("B")); 
		myMap.put("A", "D");    			myMap.traverse("Update \"A\"的情况");
	}
}
