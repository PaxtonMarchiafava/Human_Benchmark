package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class AimTrainer {
	
	final static int numTargets = 30;
	
	final static Rectangle gameArea = new Rectangle (235, 220, 880, 460); // create capture of game area
	final static int checkSize = 50;
	
	final static int startx = 675;
	final static int starty = 420;
	
	public static int mouseButton = InputEvent.BUTTON1_MASK;
	
	

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		Robot robot = new Robot(); // create robot instance
		
		BufferedImage gameCapture = new BufferedImage(gameArea.width, gameArea.height, 1);
		
		int c = 0; // make new int to store detected pixel color
		
		boolean exit = false;

		
		robot.mouseMove(gameArea.x + (gameArea.width / 2), gameArea.y + (gameArea.height / 2));
		
		click(robot);
		
		for (int i = 0; i < numTargets; i++) { // for each target
			exit = false;
			
			Thread.sleep(50);
			gameCapture = robot.createScreenCapture(gameArea);
			
			for (int x = 0; x < gameArea.width; x += checkSize) { // cycle through points
				for (int y = 0; y <= gameArea.height; y += checkSize) {
					
					c = gameCapture.getRGB(x, y);

					if ((c & 0x00ff0000) >> 16 > 125) {
						
						robot.mouseMove(x + gameArea.x, y + gameArea.y);
						click(robot);
						exit = true;
						break;
					}
					
				}
				
				if (exit == true) 
					break;
			}
			
		}

	}
	public static void click(Robot robot) {
		robot.mousePress(mouseButton);
		robot.mouseRelease(mouseButton);
	}

}
