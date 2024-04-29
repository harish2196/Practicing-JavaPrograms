package com.chainsys.practicingtask;

import java.util.Scanner;

public class WordReversal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Word to be Reverse: ");
		String word = sc.nextLine();
		String reversal = reverseWords(word);
		System.out.println("Reversed sentence: " + reversal);

		sc.close();
	}

	public static String reverseWords(String str) {
		String[] sentence = str.split("\\s+");
		StringBuilder reversedSentence = new StringBuilder();
		for (int i = sentence.length - 1; i >= 0; i--) {
			reversedSentence.append(sentence[i]).append(" ");
		}
		return reversedSentence.toString().trim();
	}
}
