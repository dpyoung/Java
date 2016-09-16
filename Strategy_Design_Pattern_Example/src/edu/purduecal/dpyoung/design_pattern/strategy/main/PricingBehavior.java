package edu.purduecal.dpyoung.design_pattern.strategy.main;

public interface PricingBehavior {
	
	public int calculateRevenue(int ticketCost, int numberOfPassengers, int flightBaseCost);
	
	
}
