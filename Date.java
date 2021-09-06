import java.util.*;

public class Date {
	static Scanner scan = new Scanner(System.in);
	private int month;
	private int day;
	private int year;
	
	public Date() {
		makeDate();
	}
	public Date(int month, int day, int year) {
		setMonth(month);
		setDay(day);
		setYear(year);
	}

	//setters and getters
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		boolean badInput = false;
		while(month > 12 || month < 1) {
			do {
				try {
					badInput = false;
					System.out.println("You can only type 1-12, try again: ");
					month = scan.nextInt();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);

		}
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		boolean badInput = false;
		boolean leapYear;
		do {
			
			switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				while(day > 31 || day < 1) {
					try {
						badInput = false;
						System.out.println("There's only 1-31 on this month, try again:");
						day = scan.nextInt();
					}catch(InputMismatchException e) {
						badInput = true;
						System.out.println("You entered an invalid value.");
						scan.next();
					}

				}
				break;
				
			case 4:
			case 6:
			case 9:
			case 11:
				while(day > 30 || day < 1) {
					try {
						badInput = false;
						System.out.println("There's only 1-30 on this month, try again: ");
						day = scan.nextInt();
					}catch(InputMismatchException e) {
						badInput = true;
						System.out.println("You entered an invalid value.");
						scan.next();
					}

				}
				break;
				
			case 2:
				leapYear = isLeapYear(year);
				if(leapYear) {
					while(day > 29 || day < 1) {
						try {
							badInput = false;
							System.out.println("There's only 1-29 on this month, try again: ");
							day = scan.nextInt();
						}catch(InputMismatchException e) {
							badInput = true;
							System.out.println("You entered an invalid value.");
							scan.next();
						}

					}
				} else {
					while(day > 28 || day < 1) {
						try {
							badInput = false;
							System.out.println("There's only 1-28 on this month, try again: ");
							day = scan.nextInt();
						}catch(InputMismatchException e) {
							badInput = true;
							System.out.println("You entered an invalid value.");
							scan.next();
						}

					}
			
				}
				break;
			}
			
		}while(badInput);
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		boolean badInput = false;
		while(year > 2021 || year < 1900) {
			do {
				try {
					badInput = false;
					System.out.println("The year shouldn't be " + year + ", try again: ");
					year = scan.nextInt();
				}catch(InputMismatchException e) {
					badInput = true;
					System.out.println("You entered an invalid value.");
					scan.next();
				}
			}while(badInput);
		}
		this.year = year;
	}
	//end setters and getters

	public String toString() {
		String result = month + "/" + day + "/" + year;
		return result;
	}//end toString
	
	public void makeDate() {
		boolean badInput = false;
		
		//year
		do {
			try {
				badInput = false;
				System.out.println("Enter year: ");
				year = scan.nextInt();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
			
		}while(badInput);
		setYear(year);
		
		//month
		do {
			try {
				badInput = false;
				System.out.println("Enter month: ");
				month = scan.nextInt();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
			
		}while(badInput);
		setMonth(month);
		
		//day
		do {
			try {
				badInput = false;
				System.out.println("Enter day: ");
				day = scan.nextInt();
			}catch(InputMismatchException e) {
				badInput = true;
				System.out.println("You entered an invalid value.");
				scan.next();
			}
			
		}while(badInput);
		setDay(day);
		
	}//end makeDate
	
	public boolean isLeapYear(int year) {
		boolean result = false;
		
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = true;
			}
		} else {
			result = false;
		}
		
		return result;
		
	}//end isLeapYear

}//end Date Class
