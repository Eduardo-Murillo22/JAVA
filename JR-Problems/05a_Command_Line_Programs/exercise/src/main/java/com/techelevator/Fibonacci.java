package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
//		Fn = F n-1 + F n-2


		System.out.println("Fibinachi : ");
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();

		int firstTerm = 0, secondTerm = 1;
		System.out.println("Fibonacci Series till " + count + " terms:");

		for (int i = 1; i <= count; ++i) {
			System.out.print(firstTerm + " ");

			// compute the next term
			int nextTerm = firstTerm + secondTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
			i = firstTerm;
		}



	}

}
