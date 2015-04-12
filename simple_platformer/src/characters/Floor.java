package characters;

import java.awt.Color;

public class Floor extends Character_unit {
	private Color character_color;
	
	public Floor(){
		x_pos=0;
		y_pos=0;
		x_size=100;
		y_size=100;
		
		last_x=x_pos;
		last_y=y_pos;
		
		speed=0;
		character_color=Color.blue;
	}
	
	public Floor(int x,int y){
		x_pos=x;
		y_pos=y;
		x_size=100;
		y_size=100;
		
		last_x=x_pos;
		last_y=y_pos;
		
		speed=0;
		character_color=Color.blue;
	}
	
	public Floor(int x_pos,int y_pos,int x_size,int y_size){
		this.x_pos=x_pos;
		this.y_pos=y_pos;
		this.x_size=x_size;
		this.y_size=y_size;
		
		last_x=x_pos;
		last_y=y_pos;
		
		speed=0;
		character_color=Color.blue;
	}
	
	@Override
	public void draw(Color[] pixels, int screen_width, int screen_height) {
		//draws character to the pixel array passed in
		for(int i=0;i<pixels.length;i++){
			//figure out where we are on the screen
			int x =i%(screen_width);
			int y =i/(screen_width);
			
			if((x>=x_pos) && (x<(x_pos+x_size))){
				if((y>=y_pos) && (y<(y_pos+y_size))){
					pixels[i]=character_color;
				}
			}
		}
		
		return;
	}

}
