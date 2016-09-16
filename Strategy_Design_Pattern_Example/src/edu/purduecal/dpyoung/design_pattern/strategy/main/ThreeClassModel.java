package edu.purduecal.dpyoung.design_pattern.strategy.main;

public class ThreeClassModel implements PricingBehavior {

	@Override
	public int calculateRevenue(int ticketCost, int numberOfPassengers, int flightBaseCost) {
		double ticketCost2=(ticketCost*1.2);
		return (int)((4.0/10)*ticketCost2*numberOfPassengers+(1.5/5)*ticketCost2*numberOfPassengers
				+(7.0/10)*ticketCost2*numberOfPassengers)-flightBaseCost;
	}

}
