/*
 * Scores are super hit and miss. Highest I have gotten is 92, but sometimes stops at 30.
 */

package main;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;


public class SequenceMemory {
	
	final static int score = 60;
	
	final static int startx = 675;
	final static int starty = 565;
	
	final static int mouseButton = InputEvent.BUTTON1_MASK;
	
	final static Rectangle captureArea = new Rectangle (550, 330, 250, 250);

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		byte pattern [] = new byte[0];
		
		Robot robot = new Robot(); // create robot instance
		BufferedImage temp;
		
		robot.mouseMove(startx, starty); // move mouse to where it should click
		robot.mousePress(mouseButton);
		robot.mouseRelease(mouseButton);
		
		robot.mouseMove(startx, starty + 100);
		Thread.sleep(1000);
		
		for (int i = 0; i < score; i++) {
			
			byte tempArray [] = new byte[pattern.length + 1]; // lengthen array
			for (int k = 0; k < pattern.length; k++) {
				 tempArray[k] = pattern[k];
			 }
			 pattern = tempArray;
			 
			for (int j = 0; j < pattern.length; j++) { // for every number of the pattern length
				
				Thread.sleep(480); // This delay makes sure that it always captures the right lit up square at the right time. If it captures the same square twice in a row, make this delay longer
				
				temp = robot.createScreenCapture(captureArea);
				
				if ((temp.getRGB(5, 5) & 0x00ff0000 >> 16) > 200) { // record what square lit up
					pattern[j] = 1;
				}else if((temp.getRGB(100, 5) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 2;
				}else if((temp.getRGB(220, 5) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 3;
				}else if ((temp.getRGB(5, 150) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 4;
				}else if((temp.getRGB(100, 150) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 5;
				}else if((temp.getRGB(220, 150) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 6;
				}else if ((temp.getRGB(5, 240) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 7;
				}else if((temp.getRGB(100, 240) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 8;
				}else if((temp.getRGB(220, 240) & 0x00ff0000 >> 16) > 200) {
					pattern[j] = 9;
				}
				
				//System.out.print(pattern[j] + ", "); // just to monitor data, not essential
			}
			System.out.println();
			
			Thread.sleep(500);
			for (int j = 0; j < pattern.length; j++) {
				
				Thread.sleep(100);

				switch (pattern[j]) { // move to tile location
				case 1:
					robot.mouseMove(550, 330);
					break;

				case 2:
					robot.mouseMove(650, 330);
					break;

				case 3:
					robot.mouseMove(775, 330);
					break;

				case 4:
					robot.mouseMove(550, 450);
					break;

				case 5:
					robot.mouseMove(650, 450);
					break;

				case 6:
					robot.mouseMove(775, 450);
					break;

				case 7:
					robot.mouseMove(550, 575);
					break;

				case 8:
					robot.mouseMove(650, 575);
					break;

				case 9:
					robot.mouseMove(775, 575);
					break;

				default:
					robot.mouseMove(100, 100);

				}

				robot.mousePress(mouseButton); // click mouse
				robot.mouseRelease(mouseButton);
			}
			
			Thread.sleep(950);
			
		}
	}
}
