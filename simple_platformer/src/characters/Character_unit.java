package characters;

import java.awt.Color;

public abstract class Character_unit {
	protected int x_pos;
	protected int y_pos;
	
	public abstract void move(int delta_x,int delta_y);
	
	//draws a representation of the character to the pixel array passed in
	public abstract void draw(Color[] pixels,int screen_width,int screen_height);
}
