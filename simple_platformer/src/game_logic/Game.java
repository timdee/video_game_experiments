package game_logic;
import java.awt.Color;

//this class will provide many functions that will be useful for all games
public abstract class Game {
	//updates the pixels on the screen
	public abstract void update_pixels(Color[] pixels,int width,int height);
}
