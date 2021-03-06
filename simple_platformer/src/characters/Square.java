package characters;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class Square extends Character_unit{
	
	private Color character_color;
	
	public Square(){
		super();
		
		x_pos=0;
		y_pos=0;
		
		x_size=50;
		y_size=50;
		
		character_color= Color.pink;
		speed=20;
	}
	
	public Square(int x, int y){
		super();
		
		x_pos=x;
		y_pos=y;
		
		x_size=50;
		y_size=50;
		
		character_color= Color.pink;
		speed=20;
	}
	
	public Square(int x_pos,int y_pos,int x_size,int y_size){
		this.x_pos=x_pos;
		this.y_pos=y_pos;
		this.x_size=x_size;
		this.y_size=y_size;
		speed=20;
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
	
	public void set_color(Color c){
		character_color=c;
	}
}
