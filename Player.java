import java.text.DecimalFormat;
import java.util.*;

public class Player {
	static Scanner scan = new Scanner(System.in);
	private Name name;
	private Date dob;
	private double moneyBalance;
	
	//constructors
	public Player() {
		makePlayer();
	}
	
	public Player(Name name, Date dob, double moneyBalance) {
		setName(name);
		setDob(dob);
		setMoneyBalance(moneyBalance);
	}
	//end constructors

	//setter and getter
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(double moneyBalance) {
		boolean badInput = false;
		while(moneyBalance < 0.00) {
			do {
				try {
					badInput = false;
					System.out.println("You cannot set a negative value as your money balance, try again: ");
					moneyBalance = scan.nextDouble();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);
		}
		this.moneyBalance = moneyBalance;
	}
	//end setter and getter
	
	public void makePlayer() {
		boolean badInput = false;
		
		//name
		System.out.println("-----ENTER NAME-----");
		name = new Name();
		setName(name);
		
		//date of birth
		System.out.println();
		System.out.println("-----ENTER DATE OF BIRTH-----" );
		dob = new Date();
		setDob(dob);
		
		//money balance
		System.out.println();
		System.out.println("-----ENTER MONEY BALANCE-----");
		do {
			try {
				badInput = false;
				System.out.println("Enter your money balance: ");
				moneyBalance = scan.nextDouble();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
		}while(badInput);
		setMoneyBalance(moneyBalance);
		
	}//end makePlayer

	public String toString() {
		DecimalFormat df = new DecimalFormat("$#,###.##");
		
		String result = name + "\n";
		result += "Date of birth: " + dob + "\n";
		result += "Money balance: " + df.format(moneyBalance) + "\n";
 		return result;
	}//end toString

}//end Player Class
