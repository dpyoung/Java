package com.wordpress.danielpyoung.bappyflird.main;

import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JLabel;

public class DriverClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7808610077180962061L;
	/*Holds Main method. Contains place-holders for other class instances.*/
	
	public static DriverClass this_Window = null;
	private static GameMain this_Game = null;
	
	private JLabel statusbar;
	private static int stateOfGame = 0;
	private static int gameInstance = 1;
	private static double playerScore = 0;

	public static DriverClass getThis_Window() {
		return this_Window;
	}

	public static void setThis_Window(DriverClass this_Window) {
		DriverClass.this_Window = this_Window;
	}
	
	public DriverClass() {
        this_Game = new GameMain(gameInstance);
        this_Window = this;
    }
	
	public void startNewGame(){
		this_Game.dispose();
		this_Game = new GameMain(gameInstance);
		this_Window = this;
	}
	
	public static GameMain getThis_Game() {
		return this_Game;
	}

	public static void setThis_Game(GameMain this_Game) {
		DriverClass.this_Game = this_Game;
	}
	
	public static int getStateOfGame() {
		return stateOfGame;
	}

	public static void setStateOfGame(int stateOGame) {
		stateOfGame = stateOGame;
	}

	public static int getGameInstance() {
		return gameInstance;
	}

	public static void setGameInstance(int gameInstanc) {
		gameInstance = gameInstanc;
	}

	public JLabel getStatusbar() {
		return statusbar;
	}

	public void setStatusbar(JLabel statusbar) {
		this.statusbar = statusbar;
	}
	
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                this_Window = new DriverClass();
                //gameRunning = true;
            }
        });
    }
	
	public static double getPlayerScore() {
		return playerScore;
	}

	public static void setPlayerScore(double playerScore2) {
		playerScore = playerScore2;
	}
		
	
}
