package 算法.stack;

import java.util.Stack;

/**
 * 栈的应用： 带括号算数表达式求值
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
					//当遇到右括号，取出
					String opt = opts.pop();
					Double num1 = nums.pop();
					switch (opt) {
						case "+":
							//再出栈一个数字 运算后结果再入栈
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
						//其他为数字
						nums.push(Double.valueOf(express[i]));	
					} break;
			}
		}
		System.out.println("运行结果："+nums.pop());
	}

	public static void main(String[] args) {
		Stack_Cal obj = new Stack_Cal();
		obj.cal(" ( 2 + ( ( 2 * 5 ) + 2 ) )");
	}
}
