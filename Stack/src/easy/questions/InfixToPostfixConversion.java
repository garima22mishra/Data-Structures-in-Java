package easy.questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfixConversion {

	static int precedenceCheck(char ch) {

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

	static String infixToPostfix(String expression) {
		if(expression.isEmpty()) {
			return "Expression is empty";
		}
		
		String result = "";
		Deque<Character> stack = new ArrayDeque<>();
		int length = expression.length();

		for(int i=0;i<length;i++) {
			char ch = expression.charAt(i);
			
			if(ch == '(') {
				stack.push(ch);
			}else if(Character.isLetterOrDigit(ch)) {
				result+=ch;
			}else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result+= stack.peek();
					stack.pop();
				}
				stack.pop();
			}else {
				while(!stack.isEmpty() && InfixToPostfixConversion.precedenceCheck(ch) <= InfixToPostfixConversion.precedenceCheck(stack.peek())) {
					result+=stack.peek();
					stack.pop();
				}
				stack.push(ch);
			}
			
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() == '(') {
				continue;
			}
			result+=stack.peek();
			stack.pop();
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println("Infix to postfix conversion program");

		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Result of infix to postfix for expression "+exp+" is "+InfixToPostfixConversion.infixToPostfix(exp));
	}

}
