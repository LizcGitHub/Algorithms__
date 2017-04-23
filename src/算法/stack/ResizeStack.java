package �㷨.stack;

import java.awt.event.ItemEvent;

/**
 * �ɱ䳤�ȵ�stack
 * ��pushʱ��
 * 	���stack����������stack�� ����Ϊԭ��������
 * ��popʱ
 * 	���Ԫ������<=�ܴ�С��1/4 ����stack��СΪԭ����1/2
 * @author Administrator
 *
 */
public class ResizeStack {
	//stack Ĭ�ϳ���Ϊ1
	private int[] stack = new int[1];
	//stack�ĳ���
	private int N = 0;
	public int getSize() { return N; }
	public boolean isEmpty() { return N == 0; }
	private void resizeStack(int max) {
		int[] newStack = new int[max];
		for (int i = 0; i < N; i++)
			newStack[i] = stack[i];
		stack = newStack;
	}
	public void push(int item) {
		stack[N++] = item;
		if(N == stack.length) resizeStack(2*stack.length);
	}
	public int pop() {
		int value = stack[--N];
		stack[N] = -1;                   //��������Ԫ��:�������Ƕ���Ļ�����null
		if (N>0 && N==stack.length/4) resizeStack(stack.length / 2);
		return value;
	}
	public void print() {
		for (int i = 0; i < stack.length; i++) {
			if(stack[i]!=-1) System.out.println("������Ԫ��index:"+i+".."+stack[i]+"..���鳤��:"+stack.length);
		}
	}
	public static void main(String[] args) {
		ResizeStack stack = new ResizeStack();
		stack.push(1);			stack.print();
		stack.push(2);			stack.print();
		stack.push(3);			stack.print();
		stack.push(4);			stack.print();
		stack.pop();			stack.print();
		stack.pop();			stack.print();
	}
}
