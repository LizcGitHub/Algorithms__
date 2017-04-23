package �㷨.����;


/**
 * ��������ղ���˳��	������	��ĸ˳��
 * ģ��Map��put��get �㷨3.1 ˳����� ��������ʵ��������ͨ��������� ��K����V �ҵ��͸���V �Ҳ����Ͳ���һ���µ�Node
 * 
 * @author Administrator
 */
public class SequenceSearchST<K, V> {
	// �����׽ڵ� 
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
		mCuurentFirst = newNode;                           //ͷ�巨
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
		myMap.traverse("��δ���Ԫ�ص����");
		myMap.put("A", "A");    			myMap.traverse("Put \"A\"�����");
		myMap.put("B", "B");    			myMap.traverse("Put \"B\"�����");
		myMap.put("B", "C");    			myMap.traverse("Update \"B\"�����");
		myMap.traverse("Get \"B\"�����");	System.out.println(myMap.get("B")); 
		myMap.put("A", "D");    			myMap.traverse("Update \"A\"�����");
	}
}
