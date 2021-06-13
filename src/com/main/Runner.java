package com.main;

import java.util.Scanner;

enum TokenType{
	INTEGER, PLUS, EOF
}

class Token{
	private String value;
	private TokenType type;
	
	public Token() {}
	public Token(TokenType type, String value) {
		this.type = type;
		this.value = value;
	}
	public TokenType getType() {
		return type;
	}
	public void setType(TokenType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}

public class Runner {
	
	static String text = "";
	static int pos = 0;
	static Token currentToken = new Token();
	
	public static void main(String[] args) {
		run();
	}
	
	private static Token getToken(String text) {
		String currentChar = "";
		
		if(pos > text.length() - 1) {
			Token token = new Token(TokenType.EOF, null);
			return token;
		}
		currentChar = Character.toString(text.charAt(pos));
		
		if(isNumeric(currentChar)) {
			Token token = new Token(TokenType.INTEGER, currentChar);
			pos++;
			return token;
		}
		
		if(currentChar.equals("+")) {
			Token token = new Token(TokenType.PLUS, currentChar);
			pos++;
			return token;
		}
		
		return null;
	}
	
	private static void eat(Token token) {
		if(currentToken.getType() == token.getType()) {
			currentToken = getToken(text);
		}
		else {
			System.err.println("Wrong token!");
		}
	}
	
	private static int expr() {
		currentToken = getToken(text);
		
		Token left = new Token();
		left = currentToken;
		eat(left);
		
		Token op = new Token();
		op = currentToken;
		eat(op);
		
		Token right = new Token();
		right = currentToken;
		eat(right);
		
		int result = Integer.parseInt(left.getValue()) + Integer.parseInt(right.getValue());
		return result;
	}
	
	private static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int i = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	private static void run() {
		Scanner scan = new Scanner(System.in);
		text = scan.next();
		scan.close();
		System.out.println("This is the text:" + text);
		int result = expr();
		System.out.println("The result: " + result);
		
	}

}
