package game_loop;

import game_window.Window;
import java.util.Timer;

public class Loop {
	Window window;
	
	public Loop(Window w){
		window=w;
	}
	
	//starts preforming game actions
	public void begin(){
		Timer timer = new Timer();
		
		//begins the loop that refreshes the screen
		//right now this is being done every 60 seconds (60 fps)
		timer.scheduleAtFixedRate(new Refresh_screen(window),0,1000/60);
	}
}
