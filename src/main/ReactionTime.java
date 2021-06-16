package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Color;
import java.awt.event.InputEvent;


public class ReactionTime {
	
	
	public static int getx = 450;
	public static int gety = 350;
	
	public static int mousex = 700;
	public static int mousey = 350;
	public static int mouseButton = InputEvent.BUTTON1_MASK;
	
	public static boolean waiting = true;
	
	//public static Color get = new Color();
	
	

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		Robot robot = new Robot(); // create robot instance
		
		Color get = new Color(0, 0, 0); // make new color to store detected info 
		
		robot.mouseMove(mousex, mousey); // move mouse to where it should click
		
		
		for (int i = 0; i < 5; i++) { // for each reaction test
			
			Thread.sleep(100); // wait for a little while so the same frame is not detected and clicked more than once
			waiting = true;
			robot.mouseMove(mousex, mousey); // move mouse to correct location to click
			click(robot); // begin the test
			
			while (waiting) {

				get = robot.getPixelColor(getx, gety); // get the color as often as possible
				
				if (get.getGreen() > get.getRed() && get.getGreen() > 175) { // if screen if green
					click(robot);
					waiting = false;
				}
				
			}
			
		}
		
	}
	
	public static void click(Robot robot) {
		robot.mousePress(mouseButton);
		robot.mouseRelease(mouseButton);
	}

}
