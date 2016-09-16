package edu.purduecal.dpyoung.design_pattern.strategy.main;

public class TwoClassModel implements PricingBehavior {

	@Override
	public int calculateRevenue(int ticketCost, int numberOfPassengers, int flightBaseCost) {
		// TODO Auto-generated method stub
		return (int)((1.5/3)*ticketCost*numberOfPassengers+(2.0/3)*ticketCost*numberOfPassengers)-flightBaseCost;
	}

}
