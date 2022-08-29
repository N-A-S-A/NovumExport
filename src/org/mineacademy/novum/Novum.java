package org.mineacademy.novum;

import org.mineacademy.novum.house.House;
import org.mineacademy.novum.person.Employee;
import org.mineacademy.novum.person.Person;

import java.util.Scanner;

public class Novum {

	private static final int LEFT_NUMBER = 0;
	private static final int RIGHT_NUMBER = 1;
	private static final int OPERATOR = 2;

	public static void main(String[] args) {
		Novum novum = new Novum();

		try{ //error stuff bellow
			novum.loop();
		}catch (Throwable t){
			System.out.println("There is an error somewhere, you fucked up!" + t.getMessage());
			t.printStackTrace();
		}
	}
	private void loop(){ //main calculator loop

		Scanner scanner = new Scanner(System.in); //"We have detected no contraband in your suitcase sir."
		String message = "0";
		int mode = LEFT_NUMBER; // left number, 1 right number, 2 = operator (+ - / *)

		double leftNumber = 0, rightNumber = 0; //makin' them double

		while(!message.equals("exit")) { //loop-killer + calculator

			if (mode > OPERATOR)
				mode = 0;

			 if (mode == LEFT_NUMBER)
				 System.out.println("First number please");
			 else if (mode == RIGHT_NUMBER)
				 System.out.println("Second one please");
			 else
				 System.out.println("Now the operator, please!");

			System.out.println("You typed: " + message);

			if (mode == LEFT_NUMBER)
				leftNumber = Double.parseDouble(message);

			else if (mode == RIGHT_NUMBER)
				rightNumber = Double.parseDouble(message);

			else if ("+".equals(message))
				System.out.println(leftNumber + " + " +  rightNumber + " = " + (leftNumber + rightNumber));

			else if ("-".equals(message))
				System.out.println(leftNumber + " - " +  rightNumber + " = " + (leftNumber - rightNumber));

			else if ("/".equals(message))
				System.out.println(leftNumber + " / " +  rightNumber + " = " + (leftNumber / rightNumber));

			else if ("*".equals(message))
				System.out.println(leftNumber + " * " +  rightNumber + " = " + (leftNumber * rightNumber));

			else if ("%".equals(message))
				System.out.println("I refuse to modulo!");

			else {
				System.out.println(message + " ...You think that this is an operator? Use proper operators, you filthy ram-downloader!");
				System.out.println("I used break on purpose, since continue wasn't available for some reason");
				break;
			}


			message = scanner.nextLine();
			mode++;
		}

		System.out.println("Self-destruct complete");
	}
}
