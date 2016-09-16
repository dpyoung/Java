package edu.purduecal.dpyoung.duckduck.main;

public class QuackViaMute implements QuackBehavior {

	private static volatile QuackViaMute instance = null;
	/*NOTE: synchronized methods are costly! Use better techniques to ensure concurrency.*/
	
	private QuackViaMute(){
		
	}
	
	public synchronized static QuackViaMute getInstance(){
		if(instance == null){
			instance = new QuackViaMute();
		}
		return instance;
	}
	
	@Override
	public void quack() {
		System.out.println("...");
	}

}
