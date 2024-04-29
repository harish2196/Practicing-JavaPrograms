package com.chainsys.practicingtask;

import java.util.Scanner;

public class PrimeNumberChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a Number to be check if it is Prime or Not: ");
		int num=sc.nextInt();
		while(num<0) {
			System.out.println("Negative Number!");
			System.out.print("Enter a Number to be check if it is Prime: ");
			num=sc.nextInt();
		}
			if(isPrime(num)) {
				System.out.println(num + " is Prime Number");
			}else {
				System.out.println(num + " is not an Prime Number");
			}
		}

	
	public static boolean isPrime(int num) {
		 if (num <= 1) {
	            return false;
	        }
		for(int i=2;i<=num/2;i+=1) {
			if(num%i==0) {
				return false;
			}
		}
	return true;
	}

}
