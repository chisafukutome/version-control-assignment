/*
 * Created By: Chisa Fukutome
 * Date Created: 10/13/2020
 * Purpose: Exam 2
 */
public class TestClass {

	public static void main(String[] args) {
		char choice = ' ';
		int eSizeP = 1, eSizeS = 3, playerChoice = 0, slotMachineChoice = 0, playCount = 0;
		boolean canPlay, continueChoice;
		
		Player[] playerArray = new Player[50];
		SlotMachine[] slotMachineArray = new SlotMachine[50];

		//set default player and slot machines
		Methods.setADefaultPlayer(playerArray);
		Methods.setDefaultMachines(slotMachineArray);
		
		//main menu
		do {		
			System.out.println();
			choice = Methods.getAChoice();
			switch(choice) {
			//Add A Player
			case 'P':
				eSizeP = Methods.loadPlayer(playerArray, eSizeP);
				break;
			
			//Add A Slot Machine
			case 'S':
				eSizeS = Methods.loadSlotMachine(slotMachineArray, eSizeS);
				break;
				
			//Gamble
			case 'G':	
				//ask user the choice of player
				playerChoice = Methods.getPlayerChoice(playerArray, eSizeP);
				
				//determine if the player have enough money (more than $1) to play slot machines
				System.out.println();
				canPlay = Methods.canPlay(playerArray, eSizeP, playerChoice);
				
				//reset 
				playCount = 0;
				continueChoice = true;
				
				while(continueChoice) {
					playCount++;

					if(canPlay) {
						
						if(playCount == 1) {
							//choose a slot machine
							slotMachineChoice = Methods.getSlotMachineChoice(slotMachineArray, eSizeS);
						}
	
						//play the slot machine
						Methods.playSlotMachine(slotMachineArray, slotMachineChoice, playerArray, playerChoice);
						
						//reset continueChoice to avoid infinitive while loop
						continueChoice = false;
				
						//ask user if he continues
						continueChoice = Methods.askContinuePlay(slotMachineArray, slotMachineChoice, playerArray, playerChoice);
					} 
				}//end while loop

				break;
			
			//Quit
			case 'Q':
				System.out.println("Thank you for using our program, bye!");
				break;
				
			default:
				System.out.println("You entered an invalid value, try again.");
				break;
			}
			
		}while(choice != 'Q');
	}//end main

}//end TestClass
