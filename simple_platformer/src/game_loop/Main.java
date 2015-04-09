package game_loop;

import java.awt.*;
import game_window.Window;

public class Main {

	public static void main(String[] args) {
		Window w = new Window();
		
		init();
		
		//start_game_menu(w);
		
		start_game_loop(w);
	}
	
	//preforms all startup operations
	private static void init(){
		
		return;
	}
	
	//starts the game
	private static void start_game_menu(Window w){
		w.start_menu();
	}
	
	//start the game loop
	private static void start_game_loop(Window w){
		Loop loop = new Loop(w);
		
		w.start_game();
		loop.begin();
	}
}
