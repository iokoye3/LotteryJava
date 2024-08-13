import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LotteryGenerator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String answer = "Y", N;
		
		Date date = new Date();
		System.out.println("Today's date: " + date);	

		while (answer.equalsIgnoreCase("Y")) {
			
			List <Integer> myNumbers = new ArrayList<>();
		
			System.out.print("\nEnter your lottery numbers (0-70): ");
			
			for (int i = 0; i < 5; i++) {
				while (true) {
					try {
						String numbers = input.next();
						int myNumber = Integer.parseInt(numbers);
						if (myNumber >= 1 & myNumber <=69 ) {
							myNumbers.add(myNumber);
							break;
						}
						else {
							System.out.println(myNumber + " is out of range");
						}
					}
					catch (NumberFormatException nfe) {
						System.out.println("\nInvalid");
					}
				}
			}
			
			List <Integer> winningNumbers = new ArrayList<>();
			
			Random random = new Random();
			
			for (int i = 0; i < 5; i++) {
				while(true) {
					int winningNumber = random.nextInt(69) + 1;
					if (!winningNumbers.contains(winningNumber)) {
						winningNumbers.add(winningNumber);
						break;
					}
				}
			}
			
			Collections.sort(myNumbers);
			Collections.sort(winningNumbers);
			
			System.out.println("\nEntered numbers: " + myNumbers);
			System.out.println("Winning numbers: " + winningNumbers);
			
			myNumbers.retainAll(winningNumbers);
			
			if (myNumbers.size() == 5) {
				System.out.print("\nYou matched every number! You won $1,000,000!\n");
			}
			if (myNumbers.size() == 4) {
				System.out.print("\nYou matched 4 numbers! You won $10,000!\n");
			}
			if (myNumbers.size() == 3) {
				System.out.print("\nYou matched 3 numbers! You won $1,000!\n");
			}
			if (myNumbers.size() == 2) {
				System.out.print("\nYou matched 2 numbers! You won $100!\n");
			}
			if (myNumbers.size() == 1) {
				System.out.print("\nYou matched 1 number! You won $10!\n");
			}
			else
				System.out.println("\nNo matching numbers.\n");
			
			System.out.print("Retry? Y/N: ");
		    answer = input.next();
		}
		
		if (answer.equalsIgnoreCase("N")) {
			System.out.println("\nThanks for playing!");
		}
	}
}

