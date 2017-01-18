package interfaceModule.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author jakal
 */

public class Buttons extends JButton implements ButtonsInterface {

	public Buttons(String string) {
		super(string);
            
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				ButtonsInterface cmd=(ButtonsInterface) ev.getSource();
				cmd.execute();
                }
            });		
    }     
        
        public void execute() {
	}
}
