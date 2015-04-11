package game_logic;
import java.awt.Color;

// the idea is this class will handle the game logic behind a platformer
// given
public class Platformer extends Game{
	
	@Override
	public void update_pixels(Color[] pixels,int screen_width, int screen_height) {
		//this is where we draw to what will eventually become the screen
		fill_screen(pixels, Color.gray);
		
		draw_floor(pixels,screen_width,screen_height);
		draw_character(pixels,screen_width,screen_height);
	}
	
	private void draw_character(Color[] pixels,int screen_width,int screen_height){
		//TODO draws our characters on the screen
		
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
}
