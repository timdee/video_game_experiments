package characters;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class Square extends Character_unit{
	private Color character_color;
	private int x_size;
	private int y_size;
	private int speed;
	
	public Square(){
		super();
		
		x_pos=0;
		y_pos=0;
		
		x_size=50;
		y_size=50;
		
		character_color= Color.pink;
		speed=2;
	}
	
	public Square(int x, int y){
		super();
		
		x_pos=x;
		y_pos=y;
		
		character_color= Color.pink;
		speed=2;
	}
	
	@Override
	public void move(int delta_x, int delta_y) {
		//cause the square to move 1px for the next "delta_x/y*speed" iterations
		//mods positive negative or zero
		// if delta_? is 0 than zero, otherwise positive => 1, negative => -1
		int x_mod=0;
		int y_mod=0;

		if(delta_x==0){
			x_mod=0;
		}else if(delta_x<0){
			x_mod=-1;
		}else{
			x_mod=1;
		}
		
		if(delta_y==0){
			y_mod=0;
		}else if(delta_y<0){
			y_mod=-1;
		}else{
			y_mod=1;
		}
		
		Timer timer=new Timer();
		Fluid_movement_task task_x=new Fluid_movement_task(Math.abs(delta_x*speed),x_mod,y_mod);
		
		timer.schedule(task_x, 1000/60);
		
		return;
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
	
	class Fluid_movement_task extends TimerTask{
		int exec_remaining;
		int x_mult;
		int y_mult;
		
		public Fluid_movement_task(int num_execs,int x_modifier,int y_modifier){
			super();
			
			exec_remaining=num_execs;
			x_mult=1;
			y_mult=1;
		}
		
		//this will be run a number of times and cause the character to move once each time
		public void run(){
			//update state of timer
			x_pos+=x_mult;
			y_pos+=y_mult;
			exec_remaining--;		
			
			//if we still have more executions run again
			if(exec_remaining>0){
				Timer timer=new Timer();
				
				Fluid_movement_task task_x=new Fluid_movement_task(exec_remaining,x_mult,y_mult);
				
				timer.schedule(task_x, 1000/60);
			}
		}
	}

}
