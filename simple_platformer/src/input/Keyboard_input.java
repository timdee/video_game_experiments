package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

//this class maintains an array list of the currently held down keys
//if there are multiple keys, the array list will only contain the most rescent one
public class Keyboard_input implements KeyListener{
	private ArrayList<KeyEvent> keys;
	
	public Keyboard_input(){
		super();
		
		keys = new ArrayList<KeyEvent>();
	}
	
	//returns the currently held down keys
	public ArrayList<KeyEvent> get_keys(){
		return keys;
	}
		
	@Override
	public void keyPressed(KeyEvent e) {
		//add key event to array
		int key_code = e.getKeyCode();
		
		for(int i=0;i<keys.size();i++){
			if(keys.get(i).getKeyCode()==key_code){
				keys.remove(i);
				
				break;
			}
		}
		
		keys.add(e);

		return;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//remove the key event from the array
		int key_code = e.getKeyCode();
		
		for(int i=0;i<keys.size();i++){
			if(keys.get(i).getKeyCode()==key_code){
				keys.remove(i);
				break;
			}
		}
	
		return;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		return;
	}

}
