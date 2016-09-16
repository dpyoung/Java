package edu.purduecal.dpyoung.duckduck.main;

public class MallardDuck extends Duck{	
	
	public MallardDuck(){
		this.setFlyBehavior(FlyWithWings.getInstance());
		this.setQuackBehavior(QuackViaQuack.getInstance());
	}
	
	public void display(){
		System.out.println("Hi, I'm a Mallard Duck...");
	}
	
	public void swim(){
		System.out.println("Mallard Duck is swimming.");
	}
	
}