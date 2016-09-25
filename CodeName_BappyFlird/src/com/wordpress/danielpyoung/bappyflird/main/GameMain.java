package com.wordpress.danielpyoung.bappyflird.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GameMain extends JFrame implements Serializable{

	 /**
	  *		This creates a new instance of the GameMain window.
	  *		 Keeps track of the current window/options available.
	  *
	  */

	private static final long serialVersionUID = 5686148006021749016L;

	//public GameMain this_Window = null;
	private JLabel statusbar;
	private JPanel panel = null;
	//private static int stateOfGame = 0;
	//private static int gameInstance = 1;
	//private static boolean gameRunning = false;
	
		public GameMain(int level) {
	        initUI(level);
	        this.setVisible(true);
	    }
		
		/*public void reInit(){
			this_Window.removeAll();
			initUI();
		}*/
		
	    private void initUI(int level) {
	    	createMenuBar();
	    	statusbar = new JLabel("Get the highest score! ... Find the next button!");
	        statusbar.setBorder(BorderFactory.createEtchedBorder());
	        add(statusbar, BorderLayout.SOUTH);
	        
	        this.setPanel(new Game(level));/*JPanel();*/
	        ((Game)this.getPanel()).setPlayerCurrentInt(0);
	        add(panel, BorderLayout.CENTER);
	        
	        setTitle("Bappy Flird Prototype v0.2");
	        setSize(350, 350);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
	    
	    
	    private void createMenuBar() {
	        JMenuBar menubar = new JMenuBar();
	        /*Image Load*/
	        ImageIcon iconNew = new ImageIcon("./media/new.png");
	        ImageIcon iconOpen = new ImageIcon("./media/open.png");
	        ImageIcon iconSave = new ImageIcon("./media/save.png");
	        ImageIcon iconExit = new ImageIcon("./media/exit.png");
	        ImageIcon iconHint = new ImageIcon("./media/hint.png");
	        /*File Menu*/
	        JMenu fileMenu = new JMenu("File");
	        fileMenu.setMnemonic(KeyEvent.VK_F);
	        JMenuItem newMi = new JMenuItem("New", iconNew);
	        JMenuItem openMi = new JMenuItem("Open", iconOpen);
	        JMenuItem saveMi = new JMenuItem("Save", iconSave);
	        JMenuItem exitMi = new JMenuItem("Exit", iconExit);
	        JMenuItem hintMi = new JMenuItem("Hint", iconHint);
	        
	        /*Exit Menu Option, and keyboard shortcut*/
	        exitMi.setMnemonic(KeyEvent.VK_E);
	        exitMi.setToolTipText("Exit application");
	        /*exitMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
	            ActionEvent.CTRL_MASK));*/
	        /*Exit Menu Option Action*/
	        exitMi.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                System.exit(0);
	            }
	        });
	        
	        /*Open Functionality*/
	        openMi.setMnemonic(KeyEvent.VK_O);
	        openMi.setToolTipText("Open Saved Game");
	        openMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
	            ActionEvent.CTRL_MASK));
	        /*Exit Menu Option Action*/
	        openMi.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
//	            	try {
//						ImportExport.openFromFile();
//					} catch (IOException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
	                //System.out.println("Sorry, this functionality is not yet available.");
	            }
	        });	   
	        
	        /*New Functionality*/
	        newMi.setMnemonic(KeyEvent.VK_N);
	        newMi.setToolTipText("Exit application");
	        newMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
	            ActionEvent.CTRL_MASK));
	        /*Exit Menu Option Action*/
	        newMi.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	DriverClass.setGameInstance(1);
	                DriverClass.this_Window.startNewGame();
	            }
	        });
	        
	        /*Save Functionality*/
	        saveMi.setMnemonic(KeyEvent.VK_S);
	        saveMi.setToolTipText("Exit application");
	        saveMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
	            ActionEvent.CTRL_MASK));
	        /*Exit Menu Option Action*/
	        saveMi.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            /*    System.out.println("Progress Saving is Not Yet Implemented.");
	            }*/
	    	    //Handle open button action.
//	            	try {
//						ImportExport.saveToFile();
//					} catch (IOException e) {
//						 TODO Auto-generated catch block
//						e.printStackTrace();
//					}
	            }
	        });
	        
	        /*View Menu*/
	        JMenu viewMenu = new JMenu("View");
	        viewMenu.setMnemonic(KeyEvent.VK_V);
	        /*View Menu Options*/
	        JCheckBoxMenuItem sbarMi = new JCheckBoxMenuItem("Show status bar");
	        sbarMi.setMnemonic(KeyEvent.VK_S);
	        sbarMi.setDisplayedMnemonicIndex(5);
	        sbarMi.setSelected(true);
	        /*Controls Visibility of Status Bar linked to Menu option*/
	        sbarMi.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                    statusbar.setVisible(true);
	                } else {
	                    statusbar.setVisible(false);
	                }
	                
	            }

	        });
	        
	        hintMi.setMnemonic(KeyEvent.VK_H);
	        hintMi.setToolTipText("Highlight Interesting Buttons!");
	        hintMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
	            ActionEvent.CTRL_MASK));
	        /*Exit Menu Option Action*/
	        hintMi.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                System.out.println("Showing hints...");
	                HintSystem.getHint();
	            }
	        });
	        
	        /*Add Menu Options to File Menu*/
	        fileMenu.add(newMi);
	        fileMenu.add(openMi);
	        fileMenu.add(saveMi);
	        fileMenu.addSeparator();
	        fileMenu.add(exitMi);
	        /*Add Menu Options to View Menu*/
	        viewMenu.add(sbarMi);
	        viewMenu.add(hintMi);
	        /*Add Menus to MenuBar*/
	        menubar.add(fileMenu);
	        menubar.add(viewMenu);
	        /*Set MenuBar to the one we're using*/
	        setJMenuBar(menubar);
	    }

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/*
	public void gameLoop()
	{
	   int fps=0;
	   long lastLoopTime = System.nanoTime(), lastFpsTime = 0;
	   final int TARGET_FPS = 30;
	   final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
	   
	   // keep looping round til the game ends
	   while (gameRunning)
	   {
	      long now = System.nanoTime();
	      long updateLength = now - lastLoopTime;
	      lastLoopTime = now;
	      double delta = updateLength / ((double)OPTIMAL_TIME);

	      // update the frame counter
	      lastFpsTime += updateLength;
	      fps++;
	      //Unnecessary Bits
	      if (lastFpsTime >= 10E9)
	      {
	         System.out.println("(FPS: "+fps+")");
	         lastFpsTime = 0;
	         fps = 0;
	      }
	      
	      // update the game logic
	      doGameUpdates(delta);
	      
	      // draw everything
	      //NOTE THIS MIGHT CHANGE BUTTON DRAWING?
	      //render();
	      
	      // we want each frame to take 10 milliseconds, to do this
	      // we've recorded when we started the frame. We add 10 milliseconds
	      // to this and then factor in the current time to give 
	      // us our final value to wait for
	      // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
	      try{
	    	  Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
	    	  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	}

	private void doGameUpdates(double delta)
	{
	   //for (int i = 0; i < stuff.size(); i++)
	   {
	      // all time-related values must be multiplied by delta!
	      Stuff s = stuff.get(i);
	      s.velocity += Gravity.VELOCITY * delta;
	      s.position += s.velocity * delta;
	      
	      // stuff that isn't time-related doesn't care about delta...
	      if (s.velocity >= 1000)
	      {
	         s.color = Color.RED;
	      }
	      else
	      {
	         s.color = Color.BLUE;
	      }
	   }
	}*/
	
	public JLabel getStatusbar() {
		return statusbar;
	}

	public void setStatusbar(JLabel statusbar) {
		this.statusbar = statusbar;
	}	
	
}
