package br.com.ftt.compiladores.desafioII.Business;

import java.util.Stack;

public class Parser {
	private static char[][] TOKENS = {{'(', ')'}, {'[', ']'}, {'{','}'}, {'<','>'}};
	
	public static boolean openTerm(char c) {
		for (char[] cs : TOKENS) {
			if(cs[0] == c) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMaches(char openTerm, char closeTerm) {
		for (char[] cs : TOKENS) {
			if(cs[0] == openTerm) {
				return cs[1] == closeTerm;
			}
		}
		return false;
	}
	
	public static boolean Balanced(String expressao) {
		Stack<Character> stack = new Stack<>();
		for (char cs : expressao.toCharArray()) {
			if (openTerm(cs)) {
				stack.push(cs);
			} else {
				if (stack.isEmpty() || !isMaches(stack.pop(), cs)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
