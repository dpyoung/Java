package edu.purduecal.dpyoung.duckduck.main;

public class QuackViaQuack implements QuackBehavior {

	private static volatile QuackViaQuack instance = null;
	/*NOTE: synchronized methods are costly! Use better techniques to ensure concurrency.*/
	
	private QuackViaQuack(){
		
	}
	
	public synchronized static QuackViaQuack getInstance(){
		if(instance == null){
			instance = new QuackViaQuack();
		}
		return instance;
	}
	
	
	@Override
	public void quack() {
		System.out.println("Quack quack...");
	}

}
