package edu.purduecal.dpyoung.duckduck.main;

public class RedheadDuck extends Duck {
	
	public RedheadDuck(){
		this.setFlyBehavior(FlyWithWings.getInstance());
		this.setQuackBehavior(QuackViaQuack.getInstance());
	}
	
	public void display(){
		System.out.println("Hi, I'm a Redhead duck...");
	}

}
