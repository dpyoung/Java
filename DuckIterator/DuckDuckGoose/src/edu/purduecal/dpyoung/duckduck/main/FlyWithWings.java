package edu.purduecal.dpyoung.duckduck.main;

public class FlyWithWings implements FlyBehavior {

	private static volatile FlyWithWings instance = null;
	/*NOTE: synchronized methods are costly! Use better techniques to ensure concurrency.*/
	
	private FlyWithWings(){
		
	}
	
	public synchronized static FlyWithWings getInstance(){
		if(instance == null){
			instance = new FlyWithWings();
		}
		return instance;
	}
	
	@Override
	public void fly() {
		System.out.println("I'm flying!");
	}

}
