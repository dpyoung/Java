package edu.purduecal.dpyoung.duckduck.main;

import java.util.ArrayList;
import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		
		ArrayList<Duck> ducks = new ArrayList<Duck>();
		//ArrayList structures are a type of "Collection"
		
		/*Constructing Duck objects; note that they can share behavior instances!*/
		ducks.add(new MallardDuck());
		ducks.add(new RedheadDuck());
		ducks.add(new RubberDuck());
		ducks.add(new WoodenDuck());

		//For loops "iterate" through lists using a generic index syntax....
		for(int i = 0; i < ducks.size(); i++)
		{
			ducks.get(i).display();
			ducks.get(i).swim();
			ducks.get(i).quack();
			ducks.get(i).fly();
			System.out.println("");
		}
		
		//Iterator objects iterate through Collection structures using methods unique to them.
//		Iterator<Duck> it = ducks.iterator();	// This creates the iterator for the list object
//		while(it.hasNext())						// This determines if more items exist in the list
//		{										
//			Duck currentDuck = it.next();		// This sets the current object of interest to the next in the list
//			currentDuck.display();				// Loop actions to apply to objects
//			currentDuck.swim();
//			currentDuck.quack();
//			currentDuck.fly();
//			System.out.println("");
//		}

		//Enhanced for-loop syntax simplifies the syntax of iterators by joining them with the for loop syntax.
//		for(Duck duck : ducks)					//	Java's "enhanced for-loop syntax"
//		{										
//			duck.display();						//	Loop actions to apply to objects
//			duck.swim();						
//			duck.quack();
//			duck.fly();
//			System.out.println("");
//		}
		
		
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
