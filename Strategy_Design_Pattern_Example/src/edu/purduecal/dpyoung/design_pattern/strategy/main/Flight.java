package edu.purduecal.dpyoung.design_pattern.strategy.main;

/*
 * Name: Daniel Young
 * Date: 9/13/15
 * Assignment: HW3
 * Course: CS590-01 Software Development
 */

public class Flight {
	
	private static int flight_cost = 50000;
	private static int ticket_cost = 300;
	private PricingBehavior pricingBehavior;
	private int numberOfPassengers;
	private int time;
	private String airlineCode, airplaneType, flightNumber, departingAirport, arrivingAirport;
	
	public Flight(){
		this.airlineCode="???";
		this.airplaneType="";
		this.flightNumber="";
		this.departingAirport="";
		this.arrivingAirport="";
		this.time=0;
		this.numberOfPassengers=0;
		this.pricingBehavior=null;
	}
	
	public Flight(String airlineCode, String airplaneType, String flightNumber, 
			String departingAirport, String arrivingAirport, int time, int numberOfPassengers){
		this.airlineCode=airlineCode;
		this.airplaneType=airplaneType;
		this.flightNumber=flightNumber;
		this.departingAirport=departingAirport;
		this.arrivingAirport=arrivingAirport;
		this.time=time;
		this.numberOfPassengers=numberOfPassengers;
		this.pricingBehavior=null;
	}
	
	
	public int getRevenue(){
		return pricingBehavior.calculateRevenue(ticket_cost, numberOfPassengers, flight_cost);
	}
	
	public PricingBehavior getPricingBehavior() {
		return pricingBehavior;
	}
	public void setPricingBehavior(PricingBehavior pricingBehavior) {
		this.pricingBehavior = pricingBehavior;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartingAirport() {
		return departingAirport;
	}

	public void setDepartingAirport(String departingAirport) {
		this.departingAirport = departingAirport;
	}

	public String getArrivingAirport() {
		return arrivingAirport;
	}

	public void setArrivingAirport(String arrivingAirport) {
		this.arrivingAirport = arrivingAirport;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public static int getTicket_cost() {
		return ticket_cost;
	}

	public static void setTicket_cost(int ticket_cost) {
		Flight.ticket_cost = ticket_cost;
	}

	public static int getFlight_cost() {
		return flight_cost;
	}

	public static void setFlight_cost(int flight_cost) {
		Flight.flight_cost = flight_cost;
	}

	public String toString(){
		if(airlineCode.equalsIgnoreCase("???")){
			return "Invalid Flight";
		}
		else return airlineCode+":"+airplaneType+":"+flightNumber+":"+departingAirport+":"
				+arrivingAirport+":"+time+":"+numberOfPassengers;
	}
}
