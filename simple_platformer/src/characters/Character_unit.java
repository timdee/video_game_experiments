package characters;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Character_unit {
	protected final int refresh_delay=1000/120;
	
	protected int x_pos;
	protected int y_pos;
	protected int x_size;
	protected int y_size;
	protected int speed;
	protected int jump_height;
	protected int gravity_strength;
	
	protected int last_x;
	protected int last_y;
	protected boolean x_moving;
	protected boolean y_moving;
	
	protected boolean stop_moving;
	protected boolean jumping;
	
	//draws a representation of the character to the pixel array passed in
	public abstract void draw(Color[] pixels,int screen_width,int screen_height);
	
	public Character_unit(){
		x_pos=0;
		y_pos=0;
		x_size=100;
		y_size=100;
		
		last_x=0;
		last_y=0;
		
		speed=10;
		jump_height=100;
		gravity_strength=5;
	}
	
	public Character_unit(int x_pos,int y_pos){
		this.x_pos=x_pos;
		this.y_pos=y_pos;
		x_size=100;
		y_size=100;
		
		last_x=x_pos;
		last_y=y_pos;
		
		speed=10;
		jump_height=100;
		gravity_strength=5;
	}
	
	public Character_unit(int x_pos,int y_pos,int x_size,int y_size){
		this.x_pos=x_pos;
		this.y_pos=y_pos;
		this.x_size=x_size;
		this.y_size=y_size;
		
		last_x=x_pos;
		last_y=y_pos;
		
		speed=10;
		jump_height=100;
		gravity_strength=5;
	}
	
	public int get_x_pos(){
		return x_pos;
	}
	
	public int get_x_size(){
		return x_size;
	}
	
	public int get_y_pos(){
		return y_pos;
	}
	
	public int get_y_size(){
		return y_size;
	}
	
	public void move(int delta_x, int delta_y) {
		//cause the square to move 1px for the next "delta_x/y*speed" iterations
		//keep track incase we need to undo this move later

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
		Fluid_movement_task_x task_x=new Fluid_movement_task_x(Math.abs(delta_x)*speed,x_mod);
		Fluid_movement_task_y task_y=new Fluid_movement_task_y(Math.abs(delta_y)*speed,y_mod);
		
		if(!(stop_moving)){
			if(!(x_moving || y_moving)){
				last_x = x_pos;
				last_y = y_pos;
			}
			
			x_moving=true;
			y_moving=true;
			
			timer.schedule(task_x, 0);
			timer.schedule(task_y, 0);
		}

		return;
	}
	
	public void undo_last_move(){
		stop_moving=true;
		
		try {
			Thread.sleep(refresh_delay*2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		x_pos=last_x;
		y_pos=last_y;
		
		stop_moving=false;
	}
	
	public void apply_gravity(){
		//applies gravity to this object
		if(!stop_moving){
			last_y=y_pos;
			last_x=x_pos;
			y_pos+=gravity_strength;
		}
	}
	
	public void jump(){
		if(!jumping){
			Timer timer=new Timer();
			jumping=true;
			
			Jump_task task=new Jump_task(jump_height);
			timer.schedule(task, 0);
		}
	}
	
	class Jump_task extends TimerTask{
		int exec_remaining;
		
		public Jump_task(int num_execs){
			super();
			
			exec_remaining=num_execs;
		}
		
		//this will be run a number of times and cause the character to move once each time
		public void run(){
			//update state of timer
			if(!stop_moving){
				y_pos--;
				exec_remaining--;
			}
			
			//if we still have more executions run again
			if(exec_remaining>0 && !stop_moving){
				Timer timer=new Timer();
				
				Jump_task task_x=new Jump_task(exec_remaining);
				
				timer.schedule(task_x, refresh_delay);
			}else{
				//we are done jumping
				jumping = false;
			}
		}
	}
	
	class Fluid_movement_task_x extends TimerTask{
		int exec_remaining;
		int x_mult;
		
		public Fluid_movement_task_x(int num_execs,int x_modifier){
			super();
			
			exec_remaining=num_execs;
			x_mult=x_modifier;
		}
		
		//this will be run a number of times and cause the character to move once each time
		public void run(){
			//update state of timer
			if(!stop_moving){
				x_pos+=x_mult;
				exec_remaining--;
			}
			
			//if we still have more executions run again
			if(exec_remaining>0 && !stop_moving){
				Timer timer=new Timer();
				
				Fluid_movement_task_x task_x=new Fluid_movement_task_x(exec_remaining,x_mult);
				
				timer.schedule(task_x, refresh_delay);
			}else{
				//we are done moving
				x_moving = false;
			}
		}
	}
	
	class Fluid_movement_task_y extends TimerTask{
		int exec_remaining;
		int y_mult;
		
		public Fluid_movement_task_y(int num_execs,int y_modifier){
			super();
			
			exec_remaining=num_execs;
			y_mult=y_modifier;
		}
		
		//this will be run a number of times and cause the character to move once each time
		public void run(){
			//update state of timer
			if(!stop_moving){
				y_pos+=y_mult;
				exec_remaining--;	
			}
			
			//if we still have more executions run again
			if(exec_remaining>0 && !stop_moving){
				Timer timer=new Timer();
				
				Fluid_movement_task_y task_y=new Fluid_movement_task_y(exec_remaining,y_mult);
				
				timer.schedule(task_y, refresh_delay);
			}else{
				//we are done moving
				y_moving = false;
			}
		}
	}
}
