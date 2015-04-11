package game_window;

import game_logic.Game;
import game_logic.Platformer;
import input.Keyboard_input;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

//this class is the main game display
//home to the code for all relevent drawing operations
public class Game_panel extends Canvas{
	public static int width = 300;
	public static int height = width/16*9;
	public static int scale = 3;
	
	private Game game;
	private Color[] pixels;
	private Keyboard_input keyboard_input;
	
	public Game_panel(){
		super();
		
		setFocusable(true);
		keyboard_input=new Keyboard_input();
		addKeyListener(keyboard_input);	
		
		game=new Platformer(width*scale,height*scale);
		pixels= new Color[width*height*scale*scale];
		
		for(int i=0;i<pixels.length;i++){
			pixels[i]=Color.gray;
		}
	}
	
	@Override
	public void update(Graphics g){
		paint(g);
	}
	
	@Override
	public void paint(Graphics g){
		BufferStrategy buffer;
		
		buffer=getBufferStrategy();
		
		update_game_state();
		
		if(buffer!=null){
			//draw to buffer
			update_buffer(buffer);
			
			//draw current buffer to the screen
			g=buffer.getDrawGraphics();
			
			g.dispose();
			
			buffer.show();
		}else{
			//create the buffer strategy here (this is just a failsafe)
			createBufferStrategy(3);
			return;
		}
	}
	
	//updates the buffer
	private Graphics update_buffer(BufferStrategy buffer){
		Graphics g =buffer.getDrawGraphics();
		
		//TODO include a game overlay here
		
		// draw based on the pixels array
		for(int i=0;i<pixels.length;i++){
			//figure out where we are on the screen
			int x =i%(width*scale);
			int y =i/(width*scale);
			
			//update one pixel
			g.setColor(pixels[i]);
			g.drawLine(x, y, x, y);
		}
		
		return g;
	}
	
	//updates all variables having to do with the game state
	//update_buffer will interpret and draw the game state
	private void update_game_state(){
		game.update_characters(keyboard_input.get_keys());
		
		//calls methods in Game that update our array of pixels and other things
		game.update_pixels(pixels,width*scale,height*scale);
		
		return;
	}
}
