package com.hackbulgaria.corejava;

public class BracketExpression {
	static boolean isCorrect(String expr) {
		char[] charExpr = expr.toCharArray();
		int countOfLeftBrackets=0;
		int countOfRightBrackets=0;
		
		for (int i = 0; i < charExpr.length; i++) {
			if (countOfRightBrackets > countOfLeftBrackets) {
				return false;
			} else {
				if (charExpr[i] == '(') {
					countOfLeftBrackets++;
				}
				if (charExpr[i] == ')') {
					countOfRightBrackets++;
				}
			}
		}
		if(countOfLeftBrackets != countOfRightBrackets){
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args){
		System.out.println(BracketExpression.isCorrect("(())"));
		System.out.println(BracketExpression.isCorrect("(()))"));
		System.out.println(BracketExpression.isCorrect("(()))"));
		System.out.println(BracketExpression.isCorrect("((())"));
		System.out.println(BracketExpression.isCorrect("((()))(())"));
		System.out.println(BracketExpression.isCorrect(")("));
	}

}
