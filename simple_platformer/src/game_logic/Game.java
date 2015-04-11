package game_logic;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

//this class will provide many functions that will be useful for all games
public abstract class Game {
	//updates the pixels on the screen
	public abstract void update_pixels(Color[] pixels,int width,int height);
	
	//performs one iteration of character updates
	public abstract void update_characters(ArrayList<KeyEvent> pressed_keys);
}
