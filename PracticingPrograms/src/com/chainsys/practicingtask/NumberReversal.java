package com.chainsys.practicingtask;

import java.util.Scanner;

public class NumberReversal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a Number to be Reversed: ");
		int reverse=sc.nextInt();
		while(reverse<0) {
			System.out.println("Negative Number!");
			System.out.print("Enter a Number to be Reversed: ");
			reverse=sc.nextInt();
		}
		int result=numberToBeReversed(reverse);
		System.out.println("After Reverse: "+ result);
		sc.close();
	}
	public static int numberToBeReversed(int reverse) {
		int sum=0;
		while(reverse!=0) {
			int remainder = reverse%10;
			sum=sum*10+remainder;
			reverse/=10;
		}

		return sum;
	}
}
