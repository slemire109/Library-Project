package com.claim;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		

		
		Scanner input=new Scanner(System.in);
		
		// Customer c=new Customer(); not sure if I am going to use this in here
		
		String[] customerArray=new String[0];
		
		System.out.println("Please make a selection below: \n 1 - Add new Record \n 2 - Delete Record \n 3 - Find Record by Telephone Number \n 4 - Find Record by Full Name \n 5 - Find Record by First Name \n 6 - Find Record by Last Name \n 7 - Update a Record \n 8 - Display Records \n 9 - EXIT");
		int selection;
		try {
		 selection=input.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid selection! Program aborting");
			selection=9;
		}
		
		while (selection !=9) {
			
			
			
			switch (selection) {
			case 1: 
				
				// this selection allows the user to ADD an entry to the array
				String addArray[]=(Customer.addRecord(customerArray));
				
				customerArray=addArray;
				System.out.println("Record added");
				break;
			
			case 2: 
				
				// this selection allows the user to REMOVE a record from the array
			String deleteArray[]=(Customer.deleteRecord(customerArray));
			
			customerArray=deleteArray;
			System.out.println("Record removed");
			break;
			
			case 3: 
				// this selection allows the user to SEARCH the array by telephone number. it does not use an array, as I feel telephone number should be unique
				String result=(Customer.findTelephone(customerArray));
				
				System.out.println("the record found is: "+result);
				
			break;
			
			case 4: 
				// this selection allows the user to SEARCH the array by FULL Name. it does not modify the array
				String result0[]=(Customer.findFullName(customerArray));
				System.out.println("record(s) found: ");
				for (int i=0;i<result0.length;i++) {
					if (result0[i]!=null) {
					System.out.println(result0[i].toString());
					}
				}
			
					break;
				
				
			
			case 5: 
				// this selection allows the user to SEARCH the array by First Name. it does not modify the array
				String result2[]=(Customer.findFirstName(customerArray));
				System.out.println("record(s) found: ");
				for (int i=0;i<result2.length;i++) {
					if (result2[i]!=null) {
					System.out.println(result2[i].toString());
					}
				}
			
					break;
				
			
			case 6: 
				// this selection allows the user to SEARCH the array by Last Name. it does not modify the array
				String result3[]=(Customer.findLastName(customerArray));
				System.out.println("record(s) found: ");
				for (int i=0;i<result3.length;i++) {
					if (result3[i]!=null) {
					System.out.println(result3[i].toString());
					}
				}
			
					break;
				
			
			
			case 7:	
				
				// this selection allows the user to UPDATE an existing record by entering the original info and then the modified info
				String updateArray[]=(Customer.updateRecord(customerArray));
				
				System.out.println("Record updated");
				customerArray=updateArray;
				
					break;
				
			
			case 8: 
				// this selection allows the user to DISPLAY the array in ascending order. it does not modify the array
				System.out.println("List of entries sorted alphabetically: ");
				System.out.println(""); // blank line to make the display more readable
				
					Customer.displayRecords(customerArray);
				
					break;
				
				
				
			case 9:
				
				// this selection sets the selection variable to 9 which will exit the user from the while loop and terminate the program
					selection=9;
					break;
			
			}
			
			
			System.out.println("Please make a selection below: \n 1 - Add new Record \n 2 - Delete Record \n 3 - Find Record by Telephone Number \n 4 - Find Record by Full Name \n 5 - Find Record by First Name \n 6 - Find Record by Last Name \n 7 - Update a Record \n 8 - Display Records \n 9 - EXIT");
			
			try {
			selection=input.nextInt();
			} catch (Exception e) {
				System.out.println("Input Error! Exiting program");
				selection=9;
			}
			
		
			
		}
				
		     input.close();
		     System.out.println("goodbye!");

	}

}

			