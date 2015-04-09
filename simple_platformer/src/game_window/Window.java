package game_window;

import java.awt.Dimension;

import javax.swing.*;

//This class will create a window for the game to run in
//the window class handles all the drawing
public class Window extends JFrame{
	Game_panel game_view;
	
	public Window(){
		super();
		
		//set up the window attributes
		setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
		
		setPreferredSize(new Dimension(600,600));
		pack();
		
		setVisible(true);
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
}
