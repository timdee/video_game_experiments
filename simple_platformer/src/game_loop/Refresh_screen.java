package game_loop;

import game_window.Window;
import java.util.TimerTask;

class Refresh_screen extends TimerTask{
	Window window;
	
	public Refresh_screen(Window w){
		super();
		
		window = w;
	}
	
	//refresh the panel here
	public void run(){
		System.out.print("o");
	}
}