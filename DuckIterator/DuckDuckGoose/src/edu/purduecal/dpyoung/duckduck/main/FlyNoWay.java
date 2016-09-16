package edu.purduecal.dpyoung.duckduck.main;

public class FlyNoWay implements FlyBehavior {

	private static volatile FlyNoWay instance = null;
	/*NOTE: synchronized methods are costly! Use better techniques to ensure concurrency.*/
	
	private FlyNoWay(){
		
	}
	
	public synchronized static FlyNoWay getInstance(){
		if(instance == null){
			instance = new FlyNoWay();
		}
		return instance;
	}
	
	@Override
	public void fly() {
		System.out.println("I'm grounded....");
	}

}
