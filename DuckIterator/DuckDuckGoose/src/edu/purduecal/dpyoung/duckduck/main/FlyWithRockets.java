package edu.purduecal.dpyoung.duckduck.main;

public class FlyWithRockets implements FlyBehavior {

	private static volatile FlyWithRockets instance = null;
	/*NOTE: synchronized methods are costly! Use better techniques to ensure concurrency.*/
	
	private FlyWithRockets(){
		
	}
	
	public synchronized static FlyWithRockets getInstance(){
		if(instance == null){
			instance = new FlyWithRockets();
		}
		return instance;
	}
	
	@Override
	public void fly() {
		System.out.println("WOOOOOSH!");
	}

}
