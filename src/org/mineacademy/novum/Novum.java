package org.mineacademy.novum;

import java.util.Scanner;

public class Novum {

	private static final int LEFT_NUMBER = 0;
	private static final int RIGHT_NUMBER = 1;
	private static final int OPERATOR = 2;

	public static void main(String[] args) {
		Novum novum = new Novum();

		try { //error stuff bellow
			novum.loop();
		} catch (Throwable t) {
			System.out.println("There is an error somewhere, you fucked up!" + t.getMessage());
			t.printStackTrace();
		}
	}

	private void loop() { //main calculator loop

		Scanner scanner = new Scanner(System.in); //"We have detected no contraband in your suitcase sir."
		String message = "";


		int mode = LEFT_NUMBER; // left number, 1 right number, 2 = operator (+ - / *)
		double leftNumber = 0, rightNumber = 0; //makin' them double

		while (!message.equals("exit")) { //loop-killer + calculator

			switch (mode) {
				case LEFT_NUMBER:
					System.out.println("First number please");
					break;
				case RIGHT_NUMBER:
					System.out.println("Second one please");
					break;
				case OPERATOR:
					System.out.println("Now the operator, please!");
					break;
				default:
					mode = LEFT_NUMBER;
					continue;
			}

			message = scanner.nextLine();
			System.out.println("You typed: " + message);

			if (mode == LEFT_NUMBER)
				try {
					leftNumber = Double.parseDouble(message);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid left number: " + message);
					continue;
				}

			else if (mode == RIGHT_NUMBER)
				try {
					rightNumber = Double.parseDouble(message);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid right number: " + message);
					continue;
				}

//				RESULT = rightNumber message Leftnumber
			if (mode == OPERATOR) {
				double RESULT;
				switch (message) {
					case "+":
						RESULT = (leftNumber + rightNumber);
						break;
					//Do something
					case "-":
						RESULT = (leftNumber - rightNumber);
						break;
					//DO something
					case "/":
						RESULT = (leftNumber / rightNumber);
						break;
					//Do something
					case "*":
						RESULT = (leftNumber * rightNumber);
						break;
					//Do something
					case "%":
						RESULT = (leftNumber % rightNumber);
						break;
					//Do something
					default:
						System.out.println(message + " ...You think that this is an operator? Use proper operators, you filthy ram-downloader!");
						System.out.println("I used break on purpose, since continue wasn't available for some reason");
						continue;
				}
				if (Double.isNaN(RESULT)) {
					System.out.println("something went wrong");
				} else {
					System.out.println(leftNumber + " " + message + " " + rightNumber + " = " + RESULT);
				}
			}
			mode++;
		}

		System.out.println("Self-destruct complete");
	}
}
