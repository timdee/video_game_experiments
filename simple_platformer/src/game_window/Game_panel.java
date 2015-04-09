package game_window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

//this class is the main game display
//home to the code for all relevent drawing operations
public class Game_panel extends Canvas{
	public static int width = 300;
	public static int height = width/16*9;
	public static int scale = 3;
	
	
	public Game_panel(){
		super();
		
		setBackground(Color.RED);
	}
	
	@Override
	public void paint(Graphics g){
		
	}
}
