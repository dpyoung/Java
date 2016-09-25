package com.wordpress.danielpyoung.bappyflird.main;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Game extends JPanel implements Serializable{

	/**
	 * 	This class keeps track of button ArrayList, as well as the player's
	 *   current integer increment. 
	 */
	private static final long serialVersionUID = -839152199542693798L;
	
	private ArrayList<MyButton> buttons;
	private int playerCurrentInt = 0;
	private int maxInt;
	
	
	public Game(){
		this(1);
	}
	
	public Game(int gameLevel){
		super();
		
		/*game = this;*/
		playerCurrentInt = 0;
		maxInt = (gameLevel+2)*(gameLevel+2);
		buttons = new ArrayList<MyButton>();
		for(int i = 0; i<maxInt;i++){
			MyButton button = new MyButton(i+1);
			buttons.add(button);
		}
		
		/*TODO: Change shuffle to be seed-dependent.*/
		Collections.shuffle(buttons);
		
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
        this.setLayout(new GridLayout(gameLevel+2, gameLevel+2, 0, 0));
        for (int i = 0; i < maxInt; i++) {
            MyButton btn = buttons.get(i);
            this.add(btn);
            btn.setBorder(BorderFactory.createLineBorder(Color.gray));
            btn.addActionListener(new ClickAction());
        }
        
	}

	public int getPlayerCurrentInt() {
		return playerCurrentInt;
	}

	public void setPlayerCurrentInt(int playerCurrentInt) {
		this.playerCurrentInt = playerCurrentInt;
	}

	public int getMaxInt() {
		return maxInt;
	}

	public void setMaxInt(int maxInt) {
		this.maxInt = maxInt;
	}

	public ArrayList<MyButton> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<MyButton> buttons) {
		this.buttons = buttons;
	}

}
