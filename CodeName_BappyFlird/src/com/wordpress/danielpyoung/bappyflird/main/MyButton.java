package com.wordpress.danielpyoung.bappyflird.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3852161527588398021L;
		private int buttonNumber;
		/*private boolean wasIdentified = false;*/
		
	    public MyButton() {

	        super();
	        
	        initUI();
	    }

	    public MyButton(Image image) {

	        super(new ImageIcon(image));

	        initUI();
	    }
	    
	    public MyButton(int buttonNumber) {
	    	/*super();*/
	        super(""/*+buttonNumber+""*/);/*NOTE: This must be Removed*/
	        this.setButtonNumber(buttonNumber);
	        initUI();
	    }

	    private void initUI() {
	        BorderFactory.createLineBorder(Color.gray);

	        addMouseListener(new MouseAdapter() {

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                setBorder(BorderFactory.createLineBorder(Color.blue));
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                setBorder(BorderFactory.createLineBorder(Color.gray));
	            }
	        });
	    }

		public int getButtonNumber() {
			return buttonNumber;
		}

		public void setButtonNumber(int buttonNumber) {
			this.buttonNumber = buttonNumber;
		}

		/*public boolean isWasIdentified() {
			return wasIdentified;
		}

		public void setWasIdentified(boolean wasIdentified) {
			this.wasIdentified = wasIdentified;
		}*/
}
