package com.claim;

import java.util.Arrays;
import java.util.Scanner;

public class Customer {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String telephone;
	
	
	
	
	public Customer() {}
	
	
	
	
	
	// ADD a NEW record to the array
	public static String[] addRecord(String[]customerArray) {
		Scanner customerInput=new Scanner(System.in);
		System.out.println("Please enter the record you want to add: ");
		int originalSize=customerArray.length;
		int newSize=originalSize+1;
		int indexCount=0;
		String newArray[]=new String[newSize];
		String newRecord=customerInput.nextLine();
		
			for (int i=0;i<customerArray.length;i++) {
			newArray[i]=customerArray[i];
			if (newArray[i]!=null) {
				indexCount+=1;
				
				}
			
				
			}
		    
			newArray[indexCount]=newRecord;
			
			return newArray;
			
		}
		
		
		
		
		

	
	// REMOVE a record from the array
	public static String[] deleteRecord(String[]customerArray) {
		
		Scanner customerInput=new Scanner(System.in);
		System.out.println("Please enter the record you want to delete: ");
		
		int originalSize=customerArray.length;
		/*
		 * if (originalSize<1) { originalSize=1; }
		 */
		String newArray[]=new String[originalSize-1];
		
		String newRecord=customerInput.nextLine();
		
		for (int i=0,j=0;i<customerArray.length;i++) {
			
			if (customerArray[i].compareTo(newRecord)==0)  {
				continue;
			}
			
				try {
				newArray[j++]=customerArray[i];
				} catch (Exception e) {
					System.out.println("data input issue. please restart application and try again");
				}
				
			
			
		}
			
		
			return newArray;
		
		
	}
		
		
	// FIND a record in the array by using the telephone number
	public static String findTelephone(String[]customerArray) {
		Customer c1=new Customer();
		Scanner customerInput=new Scanner(System.in);
		System.out.println("Please enter the Telephone number you want to search for: ");
		String result="";
		String[] phoneSearchArray=new String[5];
		String[] parseFirstName=new String[5];
		String newRecord=customerInput.nextLine();
		
		
		for (int i=0;i<customerArray.length;i++) {
			phoneSearchArray=customerArray[i].split(",");
			for (int j=0;j<phoneSearchArray.length;j++) {
				
				String strippedEnteredNumber=newRecord.replaceAll(" ","");
				String strippedStoredNumber=phoneSearchArray[j].replaceAll(" ", "");
				if (strippedStoredNumber.compareTo(strippedEnteredNumber)==0) {
					c1.street=phoneSearchArray[1];
					c1.city=phoneSearchArray[2];
					c1.state=phoneSearchArray[3];
					c1.zipCode=phoneSearchArray[4];
					c1.telephone=phoneSearchArray[5].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
					parseFirstName=phoneSearchArray[0].split(" ");
					c1.firstName=parseFirstName[0].replaceAll(",", " ");
					
					if (parseFirstName.length==3) {
						c1.middleName=parseFirstName[1].replaceAll(",$", " ");
						c1.lastName=parseFirstName[2];
					} else if (parseFirstName.length==2){ 
						
						
						c1.lastName=parseFirstName[1];
					} else {
						c1.middleName=parseFirstName[1].replaceAll(",$", " ")+" "+parseFirstName[2].replaceAll(",$", " ");
						c1.lastName=parseFirstName[3];
					}
					
					result=c1.formatData();
					break;
					}
				
				}
			}
		
		
		
		
		return result;
	}
	
	
	
	
	// FIND a record in the array by using the FULL Name
		public static String[] findFullName(String[]customerArray) {
			Scanner customerInput=new Scanner(System.in);
			System.out.println("Please enter the FULL Name you want to search for: ");
			
			String newRecord=customerInput.nextLine();
			
			String[] result=new String[customerArray.length];
			String[] fullNameSearchArray=new String[5];
			
			
			
			
			for (int i=0;i<customerArray.length;i++) {
				fullNameSearchArray=customerArray[i].split(",");
				
						 
					
					if (fullNameSearchArray[0].compareTo(newRecord)==0) {
						result[i]=customerArray[i];
						
						}
			
			
				
			}
			
			return result;
		}
	
	
	
	
	// FIND a record in the array by using the First Name
	public static String[] findFirstName(String[]customerArray) {
		Scanner customerInput=new Scanner(System.in);
		System.out.println("Please enter the First Name you want to search for: ");
		String[] result=new String[customerArray.length];
		String[] firstNameSearchArray=new String[5];
		String[] parseFirstName=new String [4];
		String newRecord=customerInput.nextLine();
		
		
		for (int i=0;i<customerArray.length;i++) {
			firstNameSearchArray=customerArray[i].split(",");
			parseFirstName=firstNameSearchArray[0].split(" ");
					 
				
				if (parseFirstName[0].compareTo(newRecord)==0) {
					result[i]=customerArray[i];
					
					}
		
		
			
		}
		
		return result;
	}
	
	
	// FIND a record in the array by using the Last Name
	public static String[] findLastName(String[]customerArray) {
		Scanner customerInput=new Scanner(System.in);
		System.out.println("Please enter the Last Name you want to search for: ");
		String[] result=new String[customerArray.length];
		String[] lastNameSearchArray=new String[5];
		String[] parseLastName=new String [4];
		String newRecord=customerInput.nextLine();
		
		
		for (int i=0;i<customerArray.length;i++) {
			lastNameSearchArray=customerArray[i].split(",");
			parseLastName=lastNameSearchArray[0].split(" ");
			int lastNamePosition=parseLastName.length-1;
					 
				
				if (parseLastName[lastNamePosition].compareTo(newRecord)==0) {
					result[i]=customerArray[i];
					
					}
		
		
			
		}
		
		return result;
	}
	
	
	// UPDATE the record in the array by finding the existing record then writing out that index with the new values
	public static String[] updateRecord(String[]customerArray) {
		
		Scanner customerInput=new Scanner(System.in);
		System.out.println("Please enter the record you want to Update as a full copy/paste from sheet: ");
		String newRecord=customerInput.nextLine();
		
		System.out.println("Please enter the NEW record in full format of name, address, zip, phone number");
		
		String updatedRecord=customerInput.nextLine();
		for (int i=0;i<customerArray.length;i++) {
			
			if (customerArray[i].compareTo(newRecord)==0) {
				customerArray[i]=updatedRecord;
				
			}
			
				
			}
		   
		
			return customerArray;
			
		}
	
	
	
	public static void displayRecords(String[]customerArray) {
		
		
		Customer c=new Customer();
		String[] displayArray=new String[5];
		String[] parseFirstName=new String[5];
		Arrays.sort(customerArray);
		int recordsFound=0;
		
		for (int i=0;i<customerArray.length;i++) {
			displayArray=customerArray[i].split(",");
			recordsFound+=1;
			c.street=displayArray[1];
			c.city=displayArray[2];
			c.state=displayArray[3];
			c.zipCode=displayArray[4];
			c.telephone=displayArray[5].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
			parseFirstName=displayArray[0].split(" ");
			c.firstName=parseFirstName[0].replaceAll(",", " ");
			
			if (parseFirstName.length==3) {
				c.middleName=parseFirstName[1].replaceAll(",$", " ");
				c.lastName=parseFirstName[2];
			} else if (parseFirstName.length==2){ 
				
				
				c.lastName=parseFirstName[1];
			} else {
				c.middleName=parseFirstName[1].replaceAll(",$", " ")+" "+parseFirstName[2].replaceAll(",$", " ");
				c.lastName=parseFirstName[3];
			}
				
			
		System.out.println(c.formatData());
			}
		System.out.println(recordsFound+" Records displayed");
		System.out.println(""); // adding an extra blank line to separate the menu from the results
		}
		
		
	
	
	
	
	// getters and setter section
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName=firstName;
		}
		
		public String getMiddleName() {
			return middleName;
		}
		
		public void setMiddleName(String middleName) {
			this.middleName=middleName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName=lastName;
		}
		
		public String getStreet() {
			return street;
		}
		
		public void setStreet(String street) {
			this.street=street;
		}
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city=city;
		}
		
		public String getState() {
			return state;
		}
		
		public void setState(String state) {
			this.state=state;
		}
		
		public String getZipCode() {
			return zipCode;
		}
		
		public void setZipCode(String zipCode) {
			this.zipCode=zipCode;
		}
		
		public String getTelephone() {
			return telephone;
		}
		
		public void setTelephone(String telephone) {
			this.telephone=telephone;
		}
		
		
			
		public String formatData() {
			if (this.middleName!=null) { return this.firstName+" "+this.middleName+" "+this.lastName+","+this.street+","+this.city+","+this.state+","+this.zipCode+","+this.telephone;
		} else {
			return this.firstName+" "+this.lastName+","+this.street+","+this.city+","+this.state+","+this.zipCode+","+this.telephone;
		}
		
		}
}
