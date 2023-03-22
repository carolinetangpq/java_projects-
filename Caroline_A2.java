//Name: Caroline
//File name: Caroline_Lab3.java 
//Declaration: This is my work

import java.util.Scanner; 
import java.io.IOException;
import java.io.File; 

 enum Month {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct,
 Nov, Dec}
 
 class Date 
 {
	 //declare the variables 
	 private int day;
	 private Month month;
	 private int year;
	 
	 //Default constructors 
	 public Date(int day, Month month, int year)
	 {
		 this.day = day; 
		 this.month = month;
		 this.year = year;
	 }
	 
	 public Date() 
	 {
		 this.day = 1; 
		 this.month = Month.Jan; 
		 this.year = 2019; 
	 } 
	 
	 public Date(Date date)
	 {
		 this.day = date.day; 
		 this.month = date.month; 
		 this.year = date.year; 

	 }

	 //accessor methods
	 public int getDay() 
	 {
		 return day; 
	 }
	 
	 public Month getMonth()
	 {
		 return month; 
	 }
	 
	 public int getYear() 
	 {
		 return year;
	 } 
	 
	 public void setDate(int day, Month month, int year)
	 {
		 this.day = day; 
		 this.month = month; 
		 this.year = year; 
	 }
 }
 

class HeartRates 
{
	//declare variables 
	private String firstName; 
	private String lastName; 
	private Date DOB; 
	private int currentYear; 
	private int maximumHeartRate;
	private double minimumTargetHeartRate;
	private double maximumTargetHeartRate; 
	
	//default constructor
	public HeartRates(String firstName, String lastName, Date DOB, int currentYear)
	{
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.DOB = DOB; 
		this.currentYear = currentYear;
	}
	
	//accessor methods 
	public String getFirstName()
	{
		return firstName; 
	} 
	
	public String getLastName()
	{
		return lastName; 
	} 
	
	public Date getDOB()
	{
		return DOB;
	}
	
	public int getCurrentYear()
	{
		return currentYear; 
	}
	
	//mutator methods 
	public void setFirstName(String firstName)
	{
		this.firstName = firstName; 
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName; 
	} 
	
	public void setDOB(Date DOB)
	{
		this.DOB = DOB;
	}
	
	public void setCurrentYear(int currentYear)
	{
		this.currentYear = currentYear;
	}
	
	private int calAge()
	{
		int age = currentYear - DOB.getYear();
		return age; 
	}
	
	public int getAge()
	{
		return calAge();
	}
	
	public int getMaximumHeartRate()
	{
		int age = getAge(); 
		int maximumHeartRate = 220 - getAge(); 
		
		return maximumHeartRate;
	}
	
	public double getMinimumTargetHeartRate()
	{
		int maximumHeartRate = getMaximumHeartRate(); 
		double minimumTargetHeartRate = 0.5 * maximumHeartRate; 
		
		return minimumTargetHeartRate;
	}
	
	
	public double getMaximumTargetHeartRate()
	{
		double maximumHeartRate = getMaximumHeartRate();
		double maximumTargetHeartRate = 0.85 * maximumHeartRate;
		
		return maximumTargetHeartRate;

	} 
	
	public void displayPrintInfo()
	{
		System.out.printf("Name: %s, %s\n", firstName, lastName);
		System.out.printf("Date of birth: %d %s %d\n", DOB.getDay(),DOB.getMonth(),DOB.getYear()); 
		System.out.printf("Current year: %d\n", currentYear); 
		System.out.printf("Your age: %d years old\n", getAge()); 
		System.out.printf("Clinic analysis, base on your age: \n\t\t"); 
		System.out.printf("1. Your maximum heart rate is %d\n\t\t", getMaximumHeartRate()); 
		System.out.printf("2. Your minimum target heart rate is %.2f\n\t\t", getMinimumTargetHeartRate()); 
		System.out.printf("3. Your maximum target heart rate is %.2f\n", getMaximumTargetHeartRate()); 
		
		

	}

}	


class Caroline_A2 
{
	private static Scanner input;
	
	public static void main(String[]args) throws IOException
	{
		//scanner object
		input = new Scanner (new File ("inputfile.txt"));
		
		//declare variables 
		String firstName;
		String lastName;
		int currentYear; 
        int age; 
		String dateString;
        String[]dateStrings;
		int day;
        Month month;
      	int year;
		Date DOB; 
		HeartRates hr; 
		
		//Read input
		
		firstName = input.nextLine();
		
		lastName = input.nextLine(); 
		
		dateString = input.nextLine();
		
		//splitting the string 
		dateStrings = dateString.split(" ");
      	
		day = Integer.valueOf(dateStrings[0]);
		month = Month.valueOf(dateStrings[1]);
      	year = Integer.valueOf(dateStrings[2]);
		
		currentYear = Integer.valueOf(input.nextLine());
		
		//construct a date object 
		DOB = new Date(day, month, year); 
		
		//construct a student object 
		hr = new HeartRates(firstName, lastName, DOB, currentYear); 
		
		hr.displayPrintInfo();
	
	
		//read the second user		
		firstName = input.nextLine();
		
		lastName = input.nextLine(); 
		
		dateString = input.nextLine();
		
		//splitting the string 
		dateStrings = dateString.split(" ");
      	
		day = Integer.valueOf(dateStrings[0]);
		month = Month.valueOf(dateStrings[1]);
      	year = Integer.valueOf(dateStrings[2]);
		

		currentYear = input.nextInt();
		

		//construct a date object 
		DOB = new Date(day, month, year); 
		
		//construct a student object 
		hr = new HeartRates(firstName, lastName, DOB, currentYear); 
		
		hr.displayPrintInfo();
		
		
	                                   
		
		
		
		
		


		
		
		
	}

} 

		
	
	
	 
	 
	 

	 
	 