import java.util.Scanner;

public class Name {
	private static Scanner scan = new Scanner(System.in);
	
	private String first;
	private char middle;
	private String last;
	
	//constructors
	public Name() {
		makeName();
	}

	public Name(String first, char middle, String last) {
		setFirst(first);
		setMiddle(middle);
		setLast(last);
	}
	//end constructors


	//setters and getters
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		first = first.substring(0, 1).toUpperCase() + first.substring(1);
		this.first = first;
	}

	public char getMiddle() {
		return middle;
	}

	public void setMiddle(char middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		last = last.substring(0, 1).toUpperCase() + last.substring(1);
		this.last = last;
	}
	//end setters and getters
	
	
	public String toString() {
		String result = "Name: " + first + " ";
		if(middle == '.') {
			result += last;
		} else {
			result += middle + ". " + last;
		}
		
		return result;
	}//end toString
	
	public void makeName() {
		//first name
		System.out.println("Enter your first name: ");
		first = scan.next();
		setFirst(first);
		
		//middle name
		System.out.println("Enter your middle initial: (enter'.' (period) if you don't have a middle name): ");
		middle = scan.next().toUpperCase().charAt(0);
		setMiddle(middle);
		
		//last name
		System.out.println("Enter your last name: ");
		last = scan.next();
		setLast(last);
	}//end makeName
	
}//end Name Class

