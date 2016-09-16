package edu.purduecal.dpyoung.duckduck.main;

public class WoodenDuck extends Duck {
	
	public WoodenDuck(){
		this.setFlyBehavior(FlyNoWay.getInstance());
		this.setQuackBehavior(QuackViaMute.getInstance());
	}
	
	public void display(){
		System.out.println("Hi, I'm a Wooden Duck...");
	}
	
}
