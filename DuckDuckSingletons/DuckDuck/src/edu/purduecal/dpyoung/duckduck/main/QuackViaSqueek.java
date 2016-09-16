package edu.purduecal.dpyoung.duckduck.main;

public class QuackViaSqueek implements QuackBehavior {

	private static volatile QuackViaSqueek instance = null;
	/*NOTE: synchronized methods are costly! Use better techniques to ensure concurrency.*/
	
	private QuackViaSqueek(){
		
	}
	
	public synchronized static QuackViaSqueek getInstance(){
		if(instance == null){
			instance = new QuackViaSqueek();
		}
		return instance;
	}
	
	
	@Override
	public void quack() {
		System.out.println("Squeak Squeak...");
	}

}
