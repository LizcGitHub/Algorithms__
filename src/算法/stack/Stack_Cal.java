package �㷨.stack;

import java.util.Stack;

/**
 * ջ��Ӧ�ã� �������������ʽ��ֵ
 */
public class Stack_Cal {
	Stack<String> opts = new Stack<>();
	Stack<Double> nums = new Stack<>();
	public String[] exchangeExpressStr2Arr(String expressStr) {
		String[] express = null;
		express = expressStr.split(" ");
		return express;
	}
	public void cal(String expressStr) {
		String[] express = exchangeExpressStr2Arr(expressStr);
		for (int i = 0; i < express.length; i++) {
			switch (express[i]) {
				case "(":			break;
				case "+":
					opts.add("+");	break;
				case "-":
					opts.add("-");	break;
				case "*":
					opts.add("*");	break;
				case "/":
					opts.add("/");	break;
				case ")": {
					//�����������ţ�ȡ��
					String opt = opts.pop();
					Double num1 = nums.pop();
					switch (opt) {
						case "+":
							//�ٳ�ջһ������ �����������ջ
							nums.push(num1 + nums.pop());	break;
						case "*":
							nums.push(num1 * nums.pop());	break;
						case "-":
							nums.push(num1 - nums.pop());	break;
						default:break;
					}
				} break; 
				default:
					if(express[i]!=null && !express[i].equals("")) {
						//����Ϊ����
						nums.push(Double.valueOf(express[i]));	
					} break;
			}
		}
		System.out.println("���н����"+nums.pop());
	}

	public static void main(String[] args) {
		Stack_Cal obj = new Stack_Cal();
		obj.cal(" ( 2 + ( ( 2 * 5 ) + 2 ) )");
	}
}
