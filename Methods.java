import java.text.DecimalFormat;
import java.util.*;

public class Methods {
	static Scanner scan  = new Scanner(System.in);
	static Random rand = new Random();
	static DecimalFormat df = new DecimalFormat("$#,###.##");
	
	public static char getAChoice() {
		char result;
		System.out.println("**********MAIN MENU**********");
		System.out.println("Add A [P]layer");
		System.out.println("Add A [S]lot Machine");
		System.out.println("[G]amble");
		System.out.println("[Q]uit");
		System.out.println("******************************");
		result = scan.next().toUpperCase().charAt(0);
		return result;
	}//end getAChoice
	
	//make a default player charlie
	public static void setADefaultPlayer(Player[] myArray) {
		Name name = new Name("Charlie", '.', "Uncle");
		Date date = new Date(12, 30, 1980);
		myArray[0] = new Player(name, date, 500);

	}//end setADefaultPlayer
	
	//make three default machines
	public static void setDefaultMachines(SlotMachine[] myArray) {
		myArray[0] = new SlotMachine("Lucky 7", 5000.00, 10000, 5000.00, 10, 5.00);
		myArray[1] = new SlotMachine("Lucky Lotto", 55000.00, 100000, 75000.00, 50, 25.00);
		myArray[2] = new SlotMachine("Purple People Eater", 1000.00, 50, 40.00, 5, 2.00);
	}//end setDefaultMachines
	
	public static int loadPlayer(Player[] myArray, int eSize) {
		int result = eSize;
		System.out.println();
		System.out.println("The information for Player [" + eSize + "] :");
		myArray[eSize] = new Player();
		result++;
		return result;
	}//end loadPlayer
	
	public static void displayPlayers(Player[] myArray, int eSize) {
		System.out.println("**********Player Information**********");
		for(int i = 0; i < eSize; i++) {
			System.out.println("Player info [" + i + "]: \n " + myArray[i]);
		}
		System.out.println("**************************************");
	}//end displayPlayers
	
	public static int loadSlotMachine(SlotMachine[] myArray, int eSize) {
		int result = eSize;
		
		System.out.println();
		System.out.println("The information for Slot Machine [" + eSize + "] :");
		myArray[eSize] = new SlotMachine();
		result++;
		return result;
	}//end loadSlotMachine
	
	public static void displaySlotMachines(SlotMachine[] myArray, int eSize) {
		System.out.println("**********Slot Machine Information**********");
		for(int i = 0; i < eSize; i++) {
			System.out.println("Slot Machine info [" + i + "]: \n " + myArray[i]);
		}
		System.out.println("*******************************************");
	}//end displaySlotMachines
	
	public static int getPlayerChoice(Player[] myArray, int eSize) {
		int result = 0;
		boolean badInput = false;
		do {
			try {
				badInput = false;
				System.out.println();
				System.out.println("Enter a player number that you want to play: ");
				displayPlayers(myArray, eSize);
				result = scan.nextInt();
				
				while(result < 0 || result > (eSize - 1)) {
					badInput = true;
					System.out.println("There's no Player[" + result + "], try again: ");
					result = scan.nextInt();
				}
			}catch (InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);

		return result;
	}//end getPlayerChoice
	
	public static boolean canPlay(Player[] myArray, int eSize, int choice) {
		boolean result = false;
		
		if(myArray[choice].getMoneyBalance() >= 1.00) {
			System.out.println("Player [" + choice + "]'s money balance: " + myArray[choice].getMoneyBalance());
			System.out.println("Since Player[" + choice + "] have more than $1.00, you can play.");
			result = true;
		} else {
			System.out.println("Player [" + choice + "]'s money balance: " + myArray[choice].getMoneyBalance());
			System.out.println("You don't have enough money to play slot machines...");
			scan.next();
			result = false;
		}
		return result;
	}//end canPlay
	
	public static int getSlotMachineChoice(SlotMachine[] myArray, int eSize) {
		int result = 0;
		boolean badInput = false;
		do {
			try {
				badInput = false;
				System.out.println();
				System.out.println("Enter a slot machine number that you want to play: ");
				displaySlotMachines(myArray, eSize);
				result = scan.nextInt();
				
				while(result < 0 || result > (eSize - 1)) {
					badInput = true;
					System.out.println("There's no Slot machine[" + result + "], try again: ");
					result = scan.nextInt();
				}
			}catch (InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);

		return result;
	}//end getSlotMachineChoice
	
	public static void playSlotMachine(SlotMachine[] myArrayS, int choiceS, Player[] myArrayP, int choiceP) {
		double playerBalance, slotMachineBalance;
		
		//user pay $1.00 for a play
		playerBalance = myArrayP[choiceP].getMoneyBalance() - 1.00;
		myArrayP[choiceP].setMoneyBalance(playerBalance);
		
		//slot machine's balance will increase by $1.00 because user paid
		slotMachineBalance = myArrayS[choiceS].getBalance() + 1.00;
		myArrayS[choiceS].setBalance(slotMachineBalance);
		
		System.out.println();
		System.out.println("==========SLOT MACHINE [" + choiceS + "] RESULT==========");
		//includes jackpot function and regular win function
		hitWin(myArrayS, choiceS, myArrayP, choiceP);

		System.out.println("Player[" + choiceP +"]'s current balance: " + df.format(myArrayP[choiceP].getMoneyBalance()));
		System.out.println("=============================================");

	}//end playSlotMachine
	
	//to determine if jackpot was hit
	public static boolean hitJackpot(SlotMachine[] myArrayS, int choiceS, Player[] myArrayP, int choiceP) {
		boolean result = false;
		int odds = myArrayS[choiceS].getOddsJackpot();
		int LB = 1, UB = odds;
		int randNum = rand.nextInt(UB - LB + 1) + LB;
		int countJackpot;
		double balanceS, balanceP;
		
		if(randNum == odds) {
			
			System.out.println("************************************");
			System.out.println("**Congraturation! JACK POT!!!!!!!!**");
			System.out.println("************************************");
			System.out.println("Player[" + choiceP + "] got " + df.format(myArrayS[choiceS].getJackpotPay()) + " !!!!!!!");
			
			//count the number of jackpot happened
			countJackpot = myArrayS[choiceS].getNumJackpot() + 1;
			myArrayS[choiceS].setNumJackpot(countJackpot);
			
			//pay money to the player
			balanceS = myArrayS[choiceS].getBalance() - myArrayS[choiceS].getJackpotPay();
			myArrayS[choiceS].setBalance(balanceS);
			
			balanceP = myArrayP[choiceP].getMoneyBalance() + myArrayS[choiceS].getJackpotPay();
			myArrayP[choiceP].setMoneyBalance(balanceP);
			//end pay money to the player
			result = true;
		} 

		return result;
	}//end hitJackpot
	
	public static boolean hitWin(SlotMachine[] myArrayS, int choiceS, Player[] myArrayP, int choiceP) {
		boolean winHit = false;
		boolean jackpotHit = hitJackpot(myArrayS, choiceS, myArrayP, choiceP);
		int odds = myArrayS[choiceS].getOddsWin();
		int LB = 1, UB = odds;
		int randNum = rand.nextInt(UB - LB + 1) + LB;
		int countWin;
		double balanceS, balanceP;
		
		if(randNum == odds && !(jackpotHit)) {
			System.out.println("Congraturation! Regular win!!!!!!!!");
			System.out.println("Player[" + choiceP + "] got " + df.format(myArrayS[choiceS].getWinPay()) + " !!!!!!!");
			
			//count the number of regular win happened
			countWin = myArrayS[choiceS].getNumWin() + 1;
			myArrayS[choiceS].setNumWin(countWin);
			
			//pay money to the player
			balanceS = myArrayS[choiceS].getBalance() - myArrayS[choiceS].getWinPay();
			myArrayS[choiceS].setBalance(balanceS);
			
			balanceP = myArrayP[choiceP].getMoneyBalance() + myArrayS[choiceS].getWinPay();
			myArrayP[choiceP].setMoneyBalance(balanceP);
			//end pay money to the player	
			winHit = true;
		} else if(!(winHit) && !(jackpotHit)) {
			System.out.println("Sorry, you didn't win... Better luck next time...");
		}
		
		return winHit;
	}//end hitWin
	
	public static boolean askContinuePlay(SlotMachine[] myArrayS, int choiceS, Player[] myArrayP, int choiceP) {
		boolean result = false;
		char continueChoice;
		
		System.out.println();
		System.out.println("Do you want Player[" + choiceP + "] to continue playing Slot Machine [" + choiceS + "] ? : (Y / N)");
		continueChoice = scan.next().toUpperCase().charAt(0);
		
		while(continueChoice != 'Y' && continueChoice != 'N') {
			System.out.println("You entered an invalid value, please enter Y / N: ");
			continueChoice = scan.next().toUpperCase().charAt(0);
		}
		
		if(continueChoice == 'Y') {
			if(myArrayP[choiceP].getMoneyBalance() < 1.00) {
				System.out.println("Player [" + choiceP +"] doesn't have enough money...");
				return false;
			}
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}//end askContinuePlay

}//end Methods Class
