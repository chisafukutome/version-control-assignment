import java.text.DecimalFormat;
import java.util.*;

public class SlotMachine {
	static Scanner scan = new Scanner(System.in);
	
	private String name;
	private double balance;
	private int numJackpot;
	private double jackpotPay;
	private int numWin;
	private double winPay;
	
	private double hopper;
	private int oddsJackpot;
	private int oddsWin;
	
	//constructors
	public SlotMachine() {
		makeSlotMachine();
	}
	
	public SlotMachine(String name, double balance, int numJackpot, double jackpotPay, int numWin, double winPay,
			double hopper, int oddsJackpot, int oddsWin) {
		setName(name);
		setBalance(balance);
		setNumJackpot(numJackpot);
		setJackpotPay(jackpotPay);
		setNumWin(numWin);
		setWinPay(winPay);
		setHopper(hopper);
		setOddsJackpot(oddsJackpot);
		setOddsWin(oddsWin);
	}
	
	public SlotMachine(String name, double hopper, int oddsJackpot, double jackpotPay, int oddsWin, double winPay) {
		setName(name);
		setHopper(hopper);
		setOddsJackpot(oddsJackpot);
		setJackpotPay(jackpotPay);
		setOddsWin(oddsWin);
		setWinPay(winPay);
	}
	//end constructors

	//setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getNumJackpot() {
		return numJackpot;
	}

	public void setNumJackpot(int numJackpot) {
		this.numJackpot = numJackpot;
	}

	public double getJackpotPay() {
		return jackpotPay;
	}

	public void setJackpotPay(double jackpotPay) {
		boolean badInput = false;
		while(jackpotPay < 1.00) {
			do {
				try {
					badInput = false;
					System.out.println("You cannot set less than $1.00 as the jackpot pay, try again: ");
					jackpotPay = scan.nextDouble();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);
	}
		this.jackpotPay = jackpotPay;
	}

	public int getNumWin() {
		return numWin;
	}

	public void setNumWin(int numWin) {
		this.numWin = numWin;
	}

	public double getWinPay() {
		return winPay;
	}

	public void setWinPay(double winPay) {
		boolean badInput = false;
		while(winPay < 0.00 || winPay >= jackpotPay) {
			do {
				try {
					badInput = false;
					System.out.println("You cannot set a negative value and more than pay of jackpot as the pay of regular win, try again: ");
					winPay = scan.nextDouble();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);
	}
		this.winPay = winPay;
	}

	public double getHopper() {
		return hopper;
	}

	public void setHopper(double hopper) {
		boolean badInput = false;
		while(hopper <= 0.00) {
			do {
				try {
					badInput = false;
					System.out.println("You cannot set a negative value as the hopper, try again: ");
					hopper = scan.nextDouble();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);
	}
		this.hopper = hopper;
	}

	public int getOddsJackpot() {
		return oddsJackpot;
	}

	public void setOddsJackpot(int oddsJackpot) {
		boolean badInput = false;
		while(oddsJackpot < 0.00) {
			do {
				try {
					badInput = false;
					System.out.println("You cannot set a negative value as the odds of jackpot, try again: ");
					oddsJackpot = scan.nextInt();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);
		}
		this.oddsJackpot = oddsJackpot;
	}

	public int getOddsWin() {
		return oddsWin;
	}

	public void setOddsWin(int oddsWin) {
		boolean badInput = false;
		while(oddsWin < 0 || oddsWin >= oddsJackpot) {
			do {
				try {
					badInput = false;
					System.out.println("You cannot set a negative value and more than odds of jackpot as the odds of regular win, try again: ");
					oddsWin = scan.nextInt();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);
		}
		this.oddsWin = oddsWin;
	}
	//end setters and getters

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("$#,###.##");
		
		String result = "Name: " + name + "\n";
		result += "Hopper: " + df.format(hopper) + "\n";
		result += "Odds of jackpot: 1 / " + oddsJackpot + "\n";
		result += "Jackpot pays: " + df.format(jackpotPay) + "\n";
		result += "Odds of regular win: 1 / " + oddsWin + "\n";
		result += "Regular win pays: " + df.format(winPay) + "\n";
		result += "Balance of the machine: " + df.format(balance) + "\n";
		result += "The number of jackpots happened: " + numJackpot + "\n";
		result += "The number of regular win happened: " + numWin + "\n";
		
		return result;
	}//end toString
	
	public void makeSlotMachine() {
		boolean badInput = false;
		
		//name
		System.out.println("Enter the name of slot machinie: ");
		name = scan.next();
		setName(name);
		
		//hopper
		do {
			try {
				badInput = false;
				System.out.println("Enter how much you want to set as a hopper: ");
				hopper = scan.nextDouble();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);
		setHopper(hopper);
		
		//oddsJackpot
		do {
			try {
				badInput = false;
				System.out.println("Enter how often jackpot happens: ");
				oddsJackpot = scan.nextInt();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);
		setOddsJackpot(oddsJackpot);
		
		//jackpotPay
		do {
			try {
				badInput = false;
				System.out.println("Enter how much jackpot pays: ");
				jackpotPay = scan.nextDouble();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);
		setJackpotPay(jackpotPay);
		
		//oddsWin
		do {
			try {
				badInput = false;
				System.out.println("Enter how often regular payout happens: ");
				oddsWin = scan.nextInt();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);
		setOddsWin(oddsWin);
		
		//winPay
		do {
			try {
				badInput = false;
				System.out.println("Enter how much regular payout pays: ");
				winPay = scan.nextDouble();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);
		setWinPay(winPay);
	}//end makeSlotMachine

}//end SlotMachine Class
