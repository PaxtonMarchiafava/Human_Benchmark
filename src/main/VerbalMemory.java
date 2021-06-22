package main;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class VerbalMemory {
	
	final static int score = 1690;
	final static int delay = 50;
	
	final static int startx = 675;
	final static int starty = 585;
	
	final static int buttony = 500;
	final static int seenx = 600;
	final static int newx = 750;
	
	final static Rectangle captureArea = new Rectangle (520, 394, 314, 83); // picture
	
	public static int mouseButton = InputEvent.BUTTON1_MASK;


	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
		BufferedImage storedData [] = new BufferedImage[1];
		
		Robot robot = new Robot(); // create robot instance
		BufferedImage temp = new BufferedImage(314, 83, 1); // Image type may be a future problem
		
		robot.mouseMove(startx, starty); // move mouse to where it should click
		click(robot);
		
		 for (int i = 0; i < score; i++) { // for each point
			 Thread.sleep(delay);
			 flag = false;
			 
			 temp = robot.createScreenCapture(captureArea); // store current word
			 
			 for (int j = 0; j < storedData.length; j++) { // for each image in array
				 
				 if (equalTo(temp, storedData[j])) { // if they are equal
					 flag = true;
					 break;
				 }
				 
			 }
			 
			 if (flag == false) {
				 robot.mouseMove(newx, buttony); // click new
				 click(robot);
				 
				 BufferedImage tempArray [] = new BufferedImage[storedData.length + 1]; // lengthen array
				 for (int k = 0; k < storedData.length; k++) {
					 tempArray[k] = storedData[k];
				 }
				 storedData = tempArray;
				 
				 storedData[storedData.length - 1] = new BufferedImage(314, 83, 1); // store word
				 storedData[storedData.length - 1] = temp;
				 
			 } else {
				  robot.mouseMove(seenx, buttony); // click seen
				  click(robot);
			 }
			 
			 
		 }
		
	}
	public static void click(Robot robot) {
		robot.mousePress(mouseButton);
		robot.mouseRelease(mouseButton);
	}
	
	public static boolean equalTo(BufferedImage image1, BufferedImage image2) {

		try {
			for (int i = 0; i < image1.getWidth(); i++) {
				for (int j = 0; j < image1.getHeight(); j++) {

					if (image1.getRGB(i, j) != image2.getRGB(i, j)) {
						return false;
					}

				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
