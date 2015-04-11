package game_logic;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import characters.Character_unit;
import characters.Floor;
import characters.Square;

// the idea is this class will handle the game logic behind a platformer
// given
public class Platformer extends Game{
	
	//these enum values will correspond to these items in the array of characters
	private enum character_id{
		main (0),
		floor (1);
		
		private int id;
		
		private character_id(int id){
			this.id=id;
		}
	}
	
	private ArrayList<Character_unit> characters;
		
	public Platformer(int screen_width,int screen_height){
		Square main_character = new Square();
		Floor floor_character = new Floor(0,200,screen_width,100);
		
		characters=new ArrayList<Character_unit>();
		
		characters.add(main_character);
		characters.add(floor_character);
	}
	
	@Override
	public void update_pixels(Color[] pixels,int screen_width, int screen_height) {
		//this is where we draw to what will eventually become the screen
		fill_screen(pixels, Color.gray);
		
		draw_background(pixels,screen_width,screen_height);
		draw_characters(pixels,screen_width,screen_height);
		
		//collision detection and correction after everything has been drawn
		detect_collisions();
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
	
	private void draw_background(Color[] pixels,int screen_width,int screen_height){
		//draws a 100 pixel bar at the bottom of the screen
		for(int i=0;i<pixels.length;i++){
			//figure out where we are on the screen
			int x =i%(screen_width);
			int y =i/(screen_width);
			
			if(y>(screen_height/2)){
				pixels[i]=Color.gray;
			}
		}
	}
	
	public void update_characters(ArrayList<KeyEvent> pressed_keys){
		//call methods to update the positions of the characters ( call move() on them)
		//this is based on the set of characters populated by the keylistener
		for(int i=0;i<pressed_keys.size();i++){
			switch(pressed_keys.get(i).getKeyCode()){
				case KeyEvent.VK_W:
					characters.get(character_id.main.id).move(0, -1);
					break;
				case KeyEvent.VK_A:
					characters.get(character_id.main.id).move(-1, 0);
					break;
				case KeyEvent.VK_S:
					characters.get(character_id.main.id).move(0, 1);
					break;
				case KeyEvent.VK_D:
					characters.get(character_id.main.id).move(1, 0);
					break;
			}
		}
		
		return;
	}
	
	private void detect_collisions(){
		//loops though the character array to see if any of the characters collide with any other characters
		//only need to check the remaining characters
		for(int i=0;i<characters.size()-1;i++){
			for(int j=i+1;j<characters.size();j++){
				//compare this single object against all of the remaining objects
				if(share_space(characters.get(i),characters.get(j))){
					resolve_collision(characters.get(i),characters.get(j));					
				}
			}
		}
	}
	
	private boolean share_space(Character_unit a,Character_unit b){
		//returns true if character a and character b share space
		//TODO
		
		return true;
	}
	
	private void resolve_collision(Character_unit a,Character_unit b){
		//returns will resolve a shared space between a and b
		//the method used here is to keep a stationary and move b
		//TODO
		
		return;
	}
}
