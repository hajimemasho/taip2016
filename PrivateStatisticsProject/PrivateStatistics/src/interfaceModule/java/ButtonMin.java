
package interfaceModule.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import interfaceModule.java.Buttons;
/**
 *
 * @author jakal
 */
public class ButtonMin extends Buttons implements ButtonsInterface{
    
	public ButtonMin(int x, int y, int width, int height){
        super("Min");
        setBounds(x, y, width, height);
    }
    
    public void execute(){
//    	MainUI.result.setText("Min = ");
    }
}