package edu.purduecal.dpyoung.design_pattern.strategy.main;

public class SingleClassModel implements PricingBehavior {

	@Override
	public int calculateRevenue(int ticketCost, int numberOfPassengers, int flightBaseCost) {
		// TODO Auto-generated method stub
		return (ticketCost*1*numberOfPassengers-flightBaseCost);
	}

}
