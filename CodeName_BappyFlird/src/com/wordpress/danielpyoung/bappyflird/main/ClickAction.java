package com.wordpress.danielpyoung.bappyflird.main;

import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

public class ClickAction extends AbstractAction implements Serializable{

	/**
	 *   This class takes actions upon button clicks; calls functions to start new games,
	 *    calls functions to open old games (in theory), relabels MyButton objects, etc.
	 */
	private static final long serialVersionUID = 1454119890965984753L;
	
	private static int streak = 1;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
        checkButton(e);
        /*checkSolution();*/
    }
	

    private void checkButton(ActionEvent e) {
    	
    	JButton button = (MyButton) e.getSource();
    	int buttonInt = ((MyButton) button).getButtonNumber();
    	int nextInt = ((Game) DriverClass.getThis_Game().getPanel()).getPlayerCurrentInt()+1;
    	if((nextInt == ((Game) DriverClass.getThis_Game().getPanel()).getMaxInt())&&(nextInt == buttonInt)){
    		DriverClass.setGameInstance((DriverClass.getGameInstance()+1));
    		System.out.println("Congratulations! You've reached stage "
    				+ DriverClass.getGameInstance());
    		DriverClass.this_Window.startNewGame();
    		nextInt=1;
    		DriverClass.setPlayerScore(DriverClass.getPlayerScore()+5);
    		DriverClass.getThis_Game().getStatusbar().setText("Player Score: " + DriverClass.getPlayerScore() 
    			+ " ... Find "+(1)+"!");
    	}
    	else if((buttonInt < nextInt)){
    		//Do nothing, user clicked same button twice like a dingbat.
    	}
    	else if((nextInt)==buttonInt){
    		button.setText(""+buttonInt+"");
    		/*Set Multiple Here*/
    		((Game)DriverClass.getThis_Game().getPanel()).setPlayerCurrentInt(nextInt);
    		updateButtons();
    		DriverClass.setPlayerScore(DriverClass.getPlayerScore()+1*streak);
    		streak++;
    		DriverClass.getThis_Game().getStatusbar().setText("Player Score: " + (DriverClass.getPlayerScore())
    			+ " ... Find "+ (nextInt) + "!");
    	}
    	else{
    		/*Reset Multiple Here*/
    		streak = 1;
    		System.out.println(""+(nextInt)+" != "+buttonInt);
    		DriverClass.setPlayerScore(DriverClass.getPlayerScore()-1.0);
    		DriverClass.getThis_Game().getStatusbar().setText("Player Score: " + (DriverClass.getPlayerScore())
			+ " ... Find "+ (nextInt) + "!");
    	}
    }

	private void updateButtons() {
    	
    	((Game)DriverClass.getThis_Game().getPanel()).removeAll();
        for (JComponent btn : ((Game)DriverClass.getThis_Game().getPanel()).getButtons()) {
        	((Game)DriverClass.getThis_Game().getPanel()).add(btn);
        }
        ((Game)DriverClass.getThis_Game().getPanel()).validate();
    }
	
	public static void setStreak(int streak){
		ClickAction.streak = streak;
	}
    
}
