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
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		text = scan.next();
		scan.close();
		
		System.out.println(text);
	}
	
	private Token getToken(String text) {
		String currentChar = "";
		currentChar = Character.toString(text.charAt(pos));
		
		if(currentChar.isDigit()) {
			Token token = new Token(TokenType.INTEGER, currentChar);
			return token;
		}
		
		if(currentChar.isSymbol()) {
			Token token = new Token(TokenType.PLUS, currentChar);
			return token;
		}
		
		return null;
	}

}
