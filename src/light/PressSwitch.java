package light;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


import java.awt.event.*;

public class PressSwitch extends JFrame{

	public PressSwitch() {	
	super("light");	
	WindowListener l = new WindowAdapter() {	
	public void windowClosing(WindowEvent e){	
	System.exit(0);	
	}	
	};
	
	addWindowListener(l);	
	JButton boutonOn = new JButton("On");	
	JButton boutonOff = new JButton("Off");
	JButton boutonDown = new JButton("Down");
	JButton boutonUp = new JButton("Up");
	JPanel panneau = new JPanel();	
	panneau.add(boutonOn);	
	panneau.add(boutonOff);
	panneau.add(boutonDown);
	panneau.add(boutonUp);
	
	JLabel labelLight = new JLabel("Light:");
	JLabel labelRetour = new JLabel("Retour:");
	
	setContentPane(panneau);	
	setSize(200,100);	
	setVisible(true);	
	}
	
	
	
	   public static void main(String[] args){
	      Light lamp = new Light();
	      Command switchUp = new FlipUpCommand(lamp);
	      Command switchDown = new FlipDownCommand(lamp);

	      Switch s = new Switch();

	  	JFrame frame = new PressSwitch();	

	      try {
	         if (args[0].equalsIgnoreCase("ON")) {
	            s.storeAndExecute(switchUp);
	            System.exit(0);
	         }
	         if (args[0].equalsIgnoreCase("OFF")) {
	            s.storeAndExecute(switchDown);
	            System.exit(0);
	         }
	         System.out.println("Argument \"ON\" or \"OFF\" is required.");
	      } catch (Exception e) {
	         System.out.println("Argument's required.");
	      }
	   }
	}