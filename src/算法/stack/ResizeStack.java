package 算法.stack;

import java.awt.event.ItemEvent;

/**
 * 可变长度的stack
 * 当push时：
 * 	如果stack已满，调整stack的 长度为原来的两倍
 * 当pop时
 * 	如果元素数量<=总大小的1/4 调整stack大小为原来的1/2
 * @author Administrator
 *
 */
public class ResizeStack {
	//stack 默认长度为1
	private int[] stack = new int[1];
	//stack的长度
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
		stack[N] = -1;                   //回收数组元素:假如存的是对象的话设置null
		if (N>0 && N==stack.length/4) resizeStack(stack.length / 2);
		return value;
	}
	public void print() {
		for (int i = 0; i < stack.length; i++) {
			if(stack[i]!=-1) System.out.println("数组内元素index:"+i+".."+stack[i]+"..数组长度:"+stack.length);
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
