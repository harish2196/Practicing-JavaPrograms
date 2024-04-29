package com.chainsys.practicingtask;

import java.util.Scanner;

public class WordOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a String: ");
		String inputWord=sc.nextLine();
		System.out.print("Enter a Word to be Searched: ");
		String wordFind=sc.nextLine();
		int occurences=countOccurences(inputWord,wordFind);
		System.out.println("CountOccurences: "+ occurences);
		sc.close();
	}
	 
	public static int countOccurences(String inputWord,String wordFind) {
		String[] words=inputWord.split("\\s+");
		int count=0;
		for(int i=0;i<words.length;i++) {
			if(wordFind.equals(words[i])) {
				count+=1;
			}
		}
		return count;
	}
}
