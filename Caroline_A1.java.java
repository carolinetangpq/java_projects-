//Name: Caroline tang 
//File name: Caroline_A1.java
// Declaration: This is my work 

import java.util.Scanner; 

class Caroline_A1
{

	private static String LINE = "----------" + "----------" + "-------------" +
	                                   "----------" + "----------" ;
	private static String HASH = "######################################################";
	
	private static String EQUAL = "=====================================================";
	
	public static void main (String[] args)
	{
		System.out.println("Welcome to Caroline Tang book store!"); 
		System.out.println("\tABC's book information\n");
		
		Scanner input = new Scanner(System.in); 
		
		int quantity4, quantity5, quantity6; // no. of books 	
		int left4, left5, left6; //balance of the books 
		int sold4, sold5, sold6; //no. of books sold 
		double price4, price5, price6; //price of the book 
		double cost4, cost5, cost6; 
		double gst4, gst5, gst6, totalgst; 
		double subtotalcost, totalcost; 
		 
		//Read the quantity and price	
		System.out.print("4th Edition and unit price: "); 
		quantity4 = input.nextInt();
		price4 = input.nextDouble();
		
		//line buffer 
		input.nextLine();
		
		System.out.print("5th Edition and unit price: "); 
		quantity5 = input.nextInt();
		price5 = input.nextDouble();
		
		//line buffer 
		input.nextLine();
		
		System.out.print("6th Edition and unit price: "); 
		quantity6 = input.nextInt();
		price6 = input.nextDouble();
		
		System.out.println();
		System.out.println(HASH);
		System.out.println();
		
		//Declaring the no. of books sold 
		sold4 = 0; 
		sold5 = 0; 
		sold6 = 0; 
		
		System.out.println("Caroline Tang book store online order"); 
		System.out.println();
        System.out.printf( "%-15s%-10s%-10s%-10s%-10s\n", "Items","Quantity", "Unit($)","Sold","Balance");
		
		System.out.println(LINE); 
		
		System.out.printf( "%-15s%-10s%-10.2f%-10s%-10s%n", "4th Edition",quantity4,price4,sold4,quantity4);
		System.out.printf( "%-15s%-10s%-10.2f%-10s%-10s%n", "5th Edition",quantity5,price5,sold5,quantity5);
		System.out.printf( "%-15s%-10s%-10.2f%-10s%-10s%n", "6th Edition",quantity6,price6,sold6,quantity6);
		System.out.println();
		
		System.out.println(HASH);
		System.out.println();
		
		//Declaring variables for the no. of books bought 
		int bought4, bought5, bought6;
		System.out.println("Please place your order\n");
		
		System.out.print("No of 4th Edition: ");
		bought4 = input.nextInt(); 
		System.out.print("No of 4th Edition: ");
		bought5 = input.nextInt(); 
		System.out.print("No of 4th Edition: ");
		bought6 = input.nextInt(); 
		System.out.println();
		
		System.out.println("Summary of your order\n");
		System.out.printf( "%-15s%-10s%-10s%-10s\n", "Items","Quantity", "Cost($)","GST($)");
		System.out.println(LINE); 
		
		//compute the total cost
		cost4 = bought4 * price4;
		cost5 = bought5 * price5;
		cost6 = bought6 * price6;
		
		//compute the gst 
		gst4 = 0.07 * cost4;
		gst5 = 0.07 * cost5;
		gst6 = 0.07 * cost6; 
		
		System.out.printf( "%-15s%-10s%-10.2f%-10.2f%n", "4th Edition",bought4,cost4,gst4);
		System.out.printf( "%-15s%-10s%-10.2f%-10.2f%n", "5th Edition",bought5,cost5,gst5);
		System.out.printf( "%-15s%-10s%-10.2f%-10.2f%n", "6th Edition",bought6,cost6,gst6);
		
		System.out.println(EQUAL); 
		
		//Declaring the total cost variables
		subtotalcost = cost4 + cost5 + cost6; 
		totalgst = gst4 + gst5 + gst6; 
		totalcost = subtotalcost + totalgst; 
		
		System.out.printf("%-15s%-10s%-10.2f%-10.2f%n" , "Subtotal cost" , "****", subtotalcost, totalgst);
		System.out.printf("%-15s%-10s%-10.2f%n" , "Total cost" , "****", totalcost);
		
		System.out.println(EQUAL); 
		
		System.out.println("Updated orders\n");
		
		//Declaring a temporary variable 
		int temp = bought4;
		bought4 = bought6;
		bought6 = temp; 
		
		System.out.printf( "%-15s%-10s%-10s%-10s\n", "Items","Quantity", "Cost($)","GST($)");
		System.out.println(LINE);
		
		//Recompute the total sum
		cost4 = bought4 * price4; 
		cost5 = bought5 * price5;
		cost6 = bought6 * price6; 
		
		gst4 = 0.07 * cost4; 
		gst5 = 0.07 * cost5;
		gst6 = 0.07 * cost6; 
		
		System.out.printf( "%-15s%-10s%-10.2f%-10.2f%n", "4th Edition",bought4,cost4,gst4);
		System.out.printf( "%-15s%-10s%-10.2f%-10.2f%n", "5th Edition",bought5,cost5,gst5);
		System.out.printf( "%-15s%-10s%-10.2f%-10.2f%n", "6th Edition",bought6,cost6,gst6);
		
		System.out.println(EQUAL); 
		
		//update the subtotal and total cost 
		subtotalcost = cost4 + cost5 + cost6; 
		totalgst = gst4 + gst5 + gst6; 
		totalcost = subtotalcost + totalgst; 
		
		System.out.printf("%-15s%-10s%-10.2f%-10.2f%n" , "Subtotal cost" , "****", subtotalcost, totalgst);
		System.out.printf("%-15s%-10s%-10.2f%n" , "Total cost" , "****", totalcost);
		
		System.out.println(); 
		System.out.println(HASH);
		
		//compute the updated summary table 
		System.out.println();
		System.out.println("Summary of available stock\n");
		System.out.printf( "%-15s%-10s%-10s%-10s%-10s\n", "Items","Quantity", "Unit($)","Sold","Balance");
		System.out.println(LINE); 
		
		
		//calculate the no. of books left 
		left4 = quantity4 - bought4; 
		left5 = quantity5 - bought5; 
		left6 = quantity6 - bought6; 
		
		System.out.printf( "%-15s%-10s%-10s%-10s%-10s\n", "4th Edition",quantity4, price4,bought4,left4);
		System.out.printf( "%-15s%-10s%-10s%-10s%-10s\n", "5th Edition",quantity5, price5,bought5,left5);
		System.out.printf( "%-15s%-10s%-10s%-10s%-10s\n", "6th Edition",quantity6, price6,bought6,left6);
		
		
		
		
		
		
		



		
		
		
		
		
		

		
		
		
	}

}
		
