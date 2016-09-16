package edu.purduecal.dpyoung.duckduck.main;

public class RubberDuck extends Duck{
	
	public RubberDuck(){
		this.setFlyBehavior(FlyNoWay.getInstance());
		this.setQuackBehavior(QuackViaSqueek.getInstance());
	}
	
	public void display(){
		System.out.println("Hi, I'm a Rubber Duck...");
	}

}
