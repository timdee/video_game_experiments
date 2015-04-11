package game_loop;

import game_window.Window;
import java.util.TimerTask;

class Refresh_screen extends TimerTask{
	Window window;
	int count;
	
	public Refresh_screen(Window w){
		super();
		
		count=0;
		window = w;
	}
	
	//refresh the panel here
	public void run(){
		window.refresh();
	}
}