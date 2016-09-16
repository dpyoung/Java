package edu.purduecal.dpyoung.design_pattern.strategy.main;

/*
 * Name: Daniel Young
 * Date: 9/13/15
 * Assignment: HW3
 * Course: CS590-01 Software Development
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Strategy Pattern Assignment
 *	Main class runs UI, gathers Flight data from file.
 *  
 *  
 */

public class Main {
 
 public static void main(String[] args) {
  
	//Test Data
	//flightList.add(new Flight("ASA","B73Q","144","ORD","SFA",13,230));
	@SuppressWarnings("resource")
	Scanner consoleInput = new Scanner(System.in);
	Scanner fileInput = null;
	boolean keepGoing = true;
	System.out.println("Welcome to the Flight Revenue Calculator.");
	while(keepGoing)
	{
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		/*Get User's File for Flight Record Input*/
		System.out.println("Enter the absolute file path of the flight record file:"); 
		String filepath = consoleInput.nextLine();
		/*Verify File has Data; continue to scan file, or quit.*/
		File currentFile = new File(filepath);
		if (currentFile.isFile()){
			try {
				/*Try to read file*/
				fileInput = new Scanner(currentFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
					continue;
			}
			/*Add all flights from file to list*/
			while(fileInput.hasNextLine()){
				flightList.add(getFlight(fileInput));
			} 
			//Remove Invalid Flights from List (doesn't work due to concurrency issue)
			/*for(Flight flier: flightList){
				if(flier.getFlightNumber().equalsIgnoreCase("???")){
				}
			}*/
			/*If there was an empty file, or it was in the invalid format*/
			if(flightList.isEmpty()){
				System.out.println("No Flights in file.");
					continue;
			}
			System.out.println("Choose the following pricing model:\n 1) Single Price\n 2) "+
					"Two Classes\n 3) Multi Class\n");
			PricingBehavior pricingBehavior;
			switch((int)Integer.parseInt(consoleInput.nextLine())){
				case 1: pricingBehavior = new SingleClassModel();
					break;
				case 2: pricingBehavior = new TwoClassModel();
					break;
				case 3: pricingBehavior = new ThreeClassModel();
					break;
				default: 
					System.out.println("Not a valid response. Defaulting to Single Class Model.");
						pricingBehavior = new SingleClassModel();
			}
			if(!flightList.isEmpty()){
				for(Flight flight: flightList)
				{
					if(flight.toString().equalsIgnoreCase("Invalid Flight")){
						System.out.println("\n  Ignoring invalid entry.\n");
					}
					else{
						flight.setPricingBehavior(pricingBehavior);
						System.out.println(flight + "\n  The revenue of this flight is: ");
	     				System.out.println("\t"+flight.getRevenue());	
					}
				}
			}
			else System.out.println("The Flight List was Empty.");
		}
		System.out.println("Enter 'Y' to try again, or anything else to exit.");
		String userChoice = consoleInput.nextLine();
		if(!userChoice.equalsIgnoreCase("Y")){
			keepGoing=false;
		}
	}
	System.out.println("Have a nice day!");
}
 
 /**
  * Utility Method for Flight Construction
  *   Gather Flights for input from "Scanner".
  * 
  * */
 public static Flight getFlight(Scanner input){
	if(input.hasNextLine())
	{
		String data = input.nextLine();
		String delims = ":";
		String[] tokens = data.split(delims);
		if(tokens.length==7 && isInteger(tokens[5]) && isInteger(tokens[6])){
			return new Flight(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],
					(int)Integer.parseInt(tokens[5]),(int)Integer.parseInt(tokens[6])); 
		}
		else{
			System.out.println("Error Reading Flight from File. Record in incorrect format.");
			return new Flight();
		}
    }
	else 
		return new Flight();
 }
 
 /**
  * Utility Method
  * 
  * Checks if input is indeed an integer.
  * 
  * */
 public static boolean isInteger(String s) {
     try { 
         Integer.parseInt(s); 
         /*hahaha*/
     } catch(NumberFormatException e) { 
         return false; 
     } catch(NullPointerException e) {
         return false;
     }
     // only true if not failure
     return true;
 }
}

