package com.wordpress.danielpyoung.bappyflird.main;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class HintSystem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7786008308305968910L;

	public static void getHint(){
		Game thisPanel = (Game) DriverClass.getThis_Game().getPanel();
		ArrayList<MyButton> muhButtons = thisPanel.getButtons();
		//Screw their streak, dem cheaters
		ClickAction.setStreak(1);
		for(MyButton button: muhButtons){
			//getGameInstance() to return level ... for i to game level, do dis
			
			for(int i = 1; i <= DriverClass.getGameInstance(); i++){
				if(button.getButtonNumber() == thisPanel.getPlayerCurrentInt()+i 
						|| button.getButtonNumber() == thisPanel.getPlayerCurrentInt()+i+1){
					button.setBackground(Color.YELLOW);
			  	}
			}
			//Figure Out How To Implement Difficulty vs Hint System
			/*if((button.getButtonNumber() == thisPanel.getPlayerCurrentInt()+1) ||
				(button.getButtonNumber() == thisPanel.getPlayerCurrentInt()+2)	||
				(button.getButtonNumber() == thisPanel.getPlayerCurrentInt()+3)){
				button.setBackground(Color.YELLOW);
			}*/
		}
		DriverClass.setPlayerScore(DriverClass.getPlayerScore()-2);
		int nextInt = ((Game) DriverClass.getThis_Game().getPanel()).getPlayerCurrentInt()+1;
		DriverClass.getThis_Game().getStatusbar().setText("Player Score: " + (DriverClass.getPlayerScore())
    			+ " ... Find "+ nextInt + "!");
	}
	
	
}
