package easy.questions;

import java.util.Stack;

public class PrefixToInfixConversion {

	public static boolean isOperator(char ch) {
		switch (ch) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return true;
		}
		return false;
	}

	public static String prefixToInfix(String expression) {
		int length = expression.length();
		Stack<String> stack = new Stack<>();

		for (int i = length - 1; i > -1; i--) {
			char ch = expression.charAt(i);
			if (PrefixToInfixConversion.isOperator(ch)) {
				String op1 = stack.pop();
				String op2 = stack.pop();

				String exp = "(" + op1 + ch + op2 + ")";
				stack.push(exp);
			} else {
				stack.push(ch + "");
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		String exp = "*-A/BC-/AKL";
		System.out.println("Infix : " + PrefixToInfixConversion.prefixToInfix(exp));
	}
}
