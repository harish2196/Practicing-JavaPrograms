package com.chainsys.practicingtask;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a String1: ");
		String str1=sc.nextLine();
		System.out.print("Enter a String2: ");
		String str2=sc.nextLine();
		boolean flag=true;
		flag=anagram(str1,str2);
		if(flag) { 
			System.out.println(str1 + " and " + str2 +  " are Anagrams");
		}else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}
		
			sc.close();
	}
	public static boolean anagram(String str1,String str2) {
		str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        if (str1.length() != str2.length()) {
            return false;
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
       return  Arrays.equals(s1,s2);
        
        
	}

}
