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

public class ButtonMax extends Buttons implements ButtonsInterface{
    
	public ButtonMax(int x, int y, int width, int height){
        super("Max");
        setBounds(x, y, width, height);
    }
    
	public void execute(){
    	MainUI.result.setText("Max = ");
    }
}