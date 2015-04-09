package game_window;

import game_logic.Game;
import game_logic.Platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

//this class is the main game display
//home to the code for all relevent drawing operations
public class Game_panel extends Canvas{
	public static int width = 300;
	public static int height = width/16*9;
	public static int scale = 3;
	
	private Game game;
	private byte[] pixels;
	
	public Game_panel(){
		super();
		
		game=new Platformer();
		
		//TODO remove
		setBackground(Color.RED);
	}
	
	@Override
	public void paint(Graphics g){
		BufferStrategy buffer;
		
		buffer=getBufferStrategy();
		
		update_game_state();
		
		if(buffer!=null){
			//draw to buffer
			update_buffer();
			
			//draw current buffer to the screen
			g=buffer.getDrawGraphics();
			
			g.dispose();
			
			buffer.show();
		}else{
			//create the buffer strategy here
			createBufferStrategy(3);
			return;
		}
	}
	
	//updates the buffer
	private void update_buffer(){
		Graphics g =getBufferStrategy().getDrawGraphics();
		//TODO draw based on the pixels array
		
		//draw to g
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 20, 20);
	}
	
	//updates all variables having to do with the game state
	//update_buffer will interpret and draw the game state
	private void update_game_state(){
		//calls methods in Game that update our array of pixels and other things
		game.update_pixels(pixels,width,height);
		
		return;
	}
}
