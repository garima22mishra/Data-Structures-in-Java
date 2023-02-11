package easy.questions;

import java.util.Stack;

public class ReverseWords {

	static String reverse(String exp) {
		int l = exp.length();
		Stack<Character> stack =new Stack<>();
		char[] result = new char[l];
		int j=0;
		
		for(int i=0;i<l;i++) {
			char ch = exp.charAt(i);
			if(ch == ' ') {
				while(!stack.isEmpty()) {
					result[j++] = stack.pop();
				}
				result[j++] = ' ';
			}else {
				stack.push(ch);
			}
		}
		
		while(!stack.isEmpty()) {
			result[j++] = stack.pop();
		}
		
		String result1 = String.valueOf(result);
		return result1;
	}
	
	public static void main(String[] args) {

		String str = "Geeks for Geeks";
		System.out.println("Original String is : "+str);
		String result = ReverseWords.reverse(str);
		System.out.println("Reversed String is : "+result);
	}

}
