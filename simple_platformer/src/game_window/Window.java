package game_window;

import input.Keyboard_input;

import java.awt.Dimension;

import javax.swing.JFrame;

//This class will create a window for the game to run in
//the window class handles all the drawing
public class Window extends JFrame{
	Game_panel game_view;
	
	public Window(){
		super();
		
		//set up the window attributes
		setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
	
		setPreferredSize(new Dimension(Game_panel.width*Game_panel.scale,Game_panel.height*Game_panel.scale));
		
		//give the frame time to add everthing before we make it go
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		pack();
	}
	
	public void start_game(){
		game_view = new Game_panel();
		
		//add the default game panel to the window
		add(game_view);
	}
	
	public void start_menu(){
		Menu_panel menu_view = new Menu_panel();
		
		//start the game menu
		add(menu_view);
	}
	
	//causes the current panel to be refreshed
	public void refresh(){
		game_view.repaint();
	}
}
