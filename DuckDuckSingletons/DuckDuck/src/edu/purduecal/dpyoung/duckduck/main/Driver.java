package edu.purduecal.dpyoung.duckduck.main;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		ArrayList<Duck> ducks = new ArrayList<Duck>();
		
		/*Constructing Duck objects; note that they can share behavior instances!*/
		ducks.add(new MallardDuck());
		ducks.add(new RedheadDuck());
		ducks.add(new RubberDuck());
		ducks.add(new WoodenDuck());
		
		for(Duck duck : ducks){
			duck.display();
			duck.swim();
			duck.quack();
			duck.fly();
			System.out.println("");
		}
		
		
//		Duck shotDownDuck = ducks.get(0);
//		
//		shotDownDuck.quack();
//		shotDownDuck.fly();
//		/*Change Duck Behavior Dynamically, don't create new Behavior Objects*/
//		shotDownDuck.setFlyBehavior(FlyNoWay.getInstance());
//		shotDownDuck.setQuackBehavior(QuackViaMute.getInstance());
//		/*Demonstration*/
//		shotDownDuck.quack();
//		shotDownDuck.fly();
		
		/*In theory, this should speed up object creation and reduce memory usage.
		 * So, creating long lists of ducks objects of the same type should be easier.*/		
		
//		for(int i = 0; i < 30; i++){
//		ducks.add(new MallardDuck());
//		ducks.add(new RubberDuck());
//		}
//		
//		for(Duck duck : ducks){
//			duck.display();
//			duck.swim();
//			duck.quack();
//			duck.fly();
//			System.out.println("");
//		}
		
	}

}
