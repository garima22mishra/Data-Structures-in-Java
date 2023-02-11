package easy.questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPrefixConversion {

	public static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}

		return -1;
	}

	public static String reverse(String str) {
		int n = str.length();
		char[] result = new char[n];
		int j = 0;

		for (int i = n - 1; i > -1; i--) {
			result[j++] = str.charAt(i);
		}

		System.out.println("Reversed String is : "+String.valueOf(result));
		return String.valueOf(result);
	}

	public static String infixToPrefix(String exp) {
		int length = exp.length();
		Deque<Character> stack = new ArrayDeque<>();
		String result = "";

		for (int i = 0; i < length; i++) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else if (Character.isLetterOrDigit(ch)) {
				result += ch;
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.peek();
					stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty()
						&& InfixToPrefixConversion.precedence(ch) <= InfixToPrefixConversion.precedence(stack.peek())) {
					result += stack.peek();
					stack.pop();
				}
				stack.push(ch);
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				continue;
			}
			result += stack.peek();
			stack.pop();
		}
		System.out.println("Postfix expression is " + result);

		return InfixToPrefixConversion.reverse(result);
	}

	public static void main(String[] args) {
		String exp = "A * B + C / D";
		String reversedExp = InfixToPrefixConversion.reverse(exp);
		System.out.println("Reversed expression is " + reversedExp);

		int l = reversedExp.length();
		char[] temp = reversedExp.toCharArray();

		for (int i = 0; i < l; i++) {
			if (temp[i] == '(') {
				temp[i] = ')';
			} else if (temp[i] == ')') {
				temp[i] = '(';
			}
		}

		reversedExp = String.valueOf(temp);
		System.out.println("Reversed bracket expression is " + reversedExp);

		System.out.println(
				"Infix to prefix of expression " + exp + " is  " + InfixToPrefixConversion.infixToPrefix(reversedExp));

	}

}
