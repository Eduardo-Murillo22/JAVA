package com.techelevator;
import java.util.Scanner;
public class DecimalToBinary {

	public static void main(String[] args) {

		System.out.println("Entere the number you want in binary: ");
		Scanner input = new Scanner(System.in);
		int numberTOconvert = input.nextInt();
		String result = "";
		boolean go = true;
		while(go == true) {
			if(numberTOconvert == 0){
				go = false;
			}
			else if(numberTOconvert % 2 == 1){
				result = "1" + result;
				numberTOconvert = numberTOconvert/2;
			}
			else{
				result = "0" + result;
				numberTOconvert = numberTOconvert/2;
			}

		}
		System.out.println("This is your number in binary = " + result);


	}

}