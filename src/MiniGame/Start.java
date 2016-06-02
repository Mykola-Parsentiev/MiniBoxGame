package MiniGame;

import java.util.Random;

public class Start {

	public static void main(String[] args) {
		
		Reader buffer = new Reader();
		int answer1, answer2;
		
		do {
			System.out.println("1. Play game \n"
					+ "2. Calculation of average value rewarded by simulation. \n"
					+ "3. Exit");
			answer1 = buffer.scan();
			if (answer1 < 1 || answer1 > 3) {
				System.out.println("Select one of the available options.");
				}
			if (answer1 == 1) {
				Play();
				}
			if (answer1 == 2) {
				do {
					System.out.println("1. Start calculation with 10 000 000 iteration. \n"
							+ "2. Change amount of iteration. \n"
							+ "3. Previous menu");
					answer2 = buffer.scan();
					if (answer1 < 1 || answer1 > 3) {
						System.out.println("Select one of the available options.");
						}
					if (answer2 == 1) {
						Simulation(10000000);
						answer2 = 3;
						}
					if (answer2 == 2) {
						System.out.println("Specify the number of iterations.");
						answer2 = buffer.scan();
						Simulation(answer2);
						answer2 = 3;
						}	
					} while (answer2 !=3);
				}
			} while(answer1 != 3);
	}
	
	public static void Play() {
		Game newGame = new Game();
		newGame.typicalGame();
		Reader buffer = new Reader();
		int answer;
		
		while (newGame.getGameOver() == false) {
			while (newGame.getLife() > 0) {
				System.out.println();
				if (newGame.getNumActiveRound() == 0)
					System.out.println("Main round!");
				if (newGame.getNumActiveRound() == 1)
					System.out.println("Bonus round!");
				System.out.println("Life =  " + newGame.getLife() + "; Rewards = " + newGame.getReward() + "$;");

				for (int i = 0; i < newGame.amountBoxActRound(); i++) {
					if (newGame.checkForCloseBox(i) != false) {
						System.out.print("[ ?? " + (i+1) + " ?? ] ");
						}
					else {
						System.out.print("[] ");
						}				
					}
				System.out.println();
				System.out.println("Which box do you want to open?");
				
				boolean correctBox = false;
				while(correctBox == false) {
					
					answer = buffer.scan() - 1;
					if (answer >= 0 && answer < newGame.amountBoxActRound()) {
						if (newGame.checkForCloseBox(answer) != false) {
							newGame.checkBox(answer);
							newGame.getBox(answer).openBox();
							correctBox = true;
							}
						else {
							System.out.println("This box has been opened before.");
							}
					}
					else {
						System.out.println("We do not have box with this number.");
						}
					}
				}
				
			newGame.checkGameOver();
			}
		System.out.println();
		System.out.println("!!! Your total rewars = " + newGame.getReward() + "$ !!!");
		System.out.println();
		}
	
	public static void Simulation(int amountIteration) {
		
		System.out.println();
		System.out.println("In process...");
		
		int sum = 0;
		float avg = 0;
		
		for (int i = 0; i < amountIteration; i++) {
			Game newGame = new Game();
			newGame.typicalGame();
			Random rnd = new Random();
						
			while (newGame.getGameOver() == false) {
				while (newGame.getLife() > 0) {
					int randomBox = rnd.nextInt(newGame.amountBoxActRound());
					newGame.takeBox(randomBox);
					}
				newGame.checkGameOver();
				}
			
			sum+= newGame.getReward();
			}
		avg = sum;
		System.out.println(" AmountIteration = " + amountIteration 
				+ "\n Summ = " + sum
				+ "\n Avg = " + avg/amountIteration + "\n");
		}
	}
