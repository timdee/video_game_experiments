package game_logic;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import characters.Character_unit;
import characters.Square;

// the idea is this class will handle the game logic behind a platformer
// given
public class Platformer extends Game{
	private ArrayList<Character_unit> characters;
		
	public Platformer(){
		Square main_character = new Square();
		
		characters=new ArrayList<Character_unit>();
		
		characters.add(main_character);
	}
	
	@Override
	public void update_pixels(Color[] pixels,int screen_width, int screen_height) {
		//this is where we draw to what will eventually become the screen
		fill_screen(pixels, Color.gray);
		
		draw_floor(pixels,screen_width,screen_height);
		draw_characters(pixels,screen_width,screen_height);
	}
	
	private void draw_characters(Color[] pixels,int screen_width,int screen_height){
		//draws our characters on the screen calls methods to draw each character
		for(int i=0;i<characters.size();i++){
			characters.get(i).draw(pixels,screen_width,screen_height);
		}
	}

	private void fill_screen(Color[] pixels, Color c){
		//fills the entire screen with a given color
		for(int i=0;i<pixels.length;i++){
			pixels[i]=c;
		}
	}
	
	private void draw_floor(Color[] pixels,int screen_width,int screen_height){
		//draws a 100 pixel bar at the bottom of the screen
		for(int i=0;i<pixels.length;i++){
			//figure out where we are on the screen
			int x =i%(screen_width);
			int y =i/(screen_width);
			
			if(y>(screen_height-100)){
				pixels[i]=Color.orange;
			}
		}
	}
	
	public void update_characters(ArrayList<KeyEvent> pressed_keys){
		//call methods to update the positions of the characters ( call move() on them)
		//this is based on the set of characters populated by the keylistener
		for(int i=0;i<pressed_keys.size();i++){
			switch(pressed_keys.get(i).getKeyCode()){
				case KeyEvent.VK_W:
					characters.get(0).move(0, -1);
					break;
				case KeyEvent.VK_A:
					characters.get(0).move(-1, 0);
					break;
				case KeyEvent.VK_S:
					characters.get(0).move(0, 1);
					break;
				case KeyEvent.VK_D:
					characters.get(0).move(1, 0);
					break;
			}
		}
		
		return;
	}
	
	private void detect_collisions(){
		//TODO loops though the character array to see if any of the characters collide
	}
}
