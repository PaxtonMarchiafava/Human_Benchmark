 /*
  * I am not too sure how often the phrases cange or if they loop and these ones are valid, but these are the ones that worked 
  * when I was testing on 20/06/2021. If the one you encounter is not here, either edit one that exists or add one and change 
  * the one place it is referenced.
  * 
  * Capital letters not supported
  */
package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Typing {
	
	final static int savex = 535;
	final static int savey = 575;
	
	final static int startx = 570;
	final static int starty = 500;
	final static int mouseButton = InputEvent.BUTTON1_MASK;
	
	 // 1 Landlady
	final static String phrase1 = "The landlady informed me that he had left the house shortly after eight o'clock in the morning. "
			+ "I sat down beside the fire, however, with the intention of awaiting him, however long he might be. I was already deeply "
			+ "interested in his inquiry, for, though it was surrounded by none of the grim and strange features which were associated "
			+ "with the two crimes which I have already recorded, still, the nature of the case and the exalted station of his client "
			+ "gave it a character of its own.";
	
	 // 2 Australia
	final static String phrase2 = "When someone thinks of Australia, they tend to picture hot deserts and dangerous animals. But the country"
			+ " is also home to some of the cutest creatures on the planet. The koala is one of them, a tiny, fluffy bear that looks like it "
			+ "wouldn't hurt a fly. It feeds entirely on leaves, and even though it chooses plants with a lot of proteins, it's still not "
			+ "enough for an active lifestyle. This is why koalas sleep up to twenty hours a day. They just don't have the energy to do anything else!";
	
	 // 3 investigation
	final static String phrase3 = "Indeed, apart from the nature of the investigation which my friend had on hand, there was something in his masterly "
			+ "grasp of a situation, and his keen, incisive reasoning, which made it a pleasure to me to study his system of work, and to follow the quick, "
			+ "subtle methods by which he disentangled the most inextricable mysteries. So accustomed was I to his invariable success that the very "
			+ "possibility of his failing had ceased to enter into my head.";
	
	 // 4 Moose
	final static String phrase4 = "If you've never met a moose, it’s hard to picture the sheer size of these animals. They’re taller than a horse, "
			+ "even without their giant antlers. They can weigh over 1000 lbs, and can run as fast as 35 miles per hour. Fortunately, they’re not "
			+ "interested in humans! Leave them alone and they’ll leave you alone, munching on weeds, branches, and any plant they can find in ponds "
			+ "and rivers. They’re excellent swimmers, and can even eat underwater without any difficulty.";
	
	 // 5 airbender
	final static String phrase5 = "Water. Earth. Fire. Air. Long ago, the four nations lived together in harmony. Then everything changed when the "
			+ "Fire Nation attacked. Only the Avatar, master of all four elements, could stop them, but when the world needed him most, he vanished. "
			+ "A hundred years passed and my brother and I discovered the new Avatar, an airbender named Aang. And although his airbending skills "
			+ "are great, he still has a lot to learn before he's ready to save anyone. But I believe Aang can save the world.";
	
	 // 6 giraffes
	final static String phrase6 = "Giraffes are the tallest animals on Earth, and their neck is the reason why. This beautiful part of their body "
			+ "has many different purposes, from spotting predators to reaching the sweetest leaves, even being used to duel with other giraffes. "
			+ "Neck fighting can be intense, going from gently rubbing against another male to establish who's in charge, to swinging heads like "
			+ "a mace and hitting hard. But it's all in good sport! Giraffes will make up after most fights, rarely getting hurt in a serious way.";
	
	 // 7 whales
	final static String phrase7 = "Whales are not fish, and they must regularly get back to the surface to breathe. There are many types of whales, "
			+ "each with their own characteristics and vastly different sizes. The most famous by far is the blue whale, the largest animal to have "
			+ "ever lived on this planet. Longer than a tennis court, it also holds the record for the most powerful call in the animal kingdom. "
			+ "Which is louder than a jet engine.";
	
	 // 8 wolf
	final static String phrase8 = "But this was too much. The wolf danced about with rage and swore he would come down the chimney and eat up the "
			+ "little pig for his supper. But while he was climbing on to the roof the little pig made up a blazing fire and put on a big pot full "
			+ "of water to boil. Then, just as the wolf was coming down the chimney, the little piggy pulled off the lid, and plop! In fell the wolf "
			+ "into the scalding water.";
		
	 // 9 third pig
	final static String phrase9 = "The third little pig worked hard all day and built his house with bricks. It was a sturdy house complete with a "
			+ "fine fireplace and chimney. It looked like it could withstand the strongest winds. The next day, a wolf happened to pass by the "
			+ "lane where the three little pigs lived; and he saw the straw house, and he smelled the pig inside. He thought the pig would make a "
			+ "mighty fine meal and his mouth began to water.";
	
	 // 10 flamingo
	final static String phrase10 = "It's impossible to think of flamingos without picturing a bright splash of pink. But where do they get their "
			+ "signature color? The answer lies in their diet. The flamingo feeds mainly on shrimps and insects, scraping them from the mud with "
			+ "its hook-shaped beak. These can contain a pigment that gives its feathers that particular shade of pink. Their shade changes depending "
			+ "on what they feed on, with the american flamingo being one of the brightest and flashiest. ";
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		Robot robot = new Robot(); // create robot instance
		
		robot.mouseMove(startx, starty); // move mouse to where it should click
		robot.mousePress(mouseButton);
		robot.mouseRelease(mouseButton);
		
		type(phrase5, robot, 0);

		
	}
	
	public static void type(String string, Robot robot, int delay) throws InterruptedException {

		string = string.toLowerCase();

		for (int i = 0; i < string.length(); i++) {
			Thread.sleep(delay);

			switch (string.charAt(i)) {
			case ' ': // special characters
				robot.keyPress(32);
				robot.keyRelease(32);
				break;
			case ',':
				robot.keyPress(44);
				robot.keyRelease(44);
				break;
			case '-':
				robot.keyPress(45);
				robot.keyRelease(45);
				break;
			case '.':
				robot.keyPress(46);
				robot.keyRelease(46);
				break;
			case ':':
				robot.keyPress(16);
				robot.keyPress(59);
				robot.keyRelease(59);
				robot.keyRelease(16);
				break;
			case '\'':
				robot.keyPress(222);
				robot.keyRelease(222);
				System.out.println("Yes");
				break;

			case '0': // numbers
				robot.keyPress(48);
				robot.keyRelease(48);
				break;
			case '1':
				robot.keyPress(49);
				robot.keyRelease(49);
				break;
			case '2':
				robot.keyPress(50);
				robot.keyRelease(50);
				break;
			case '3':
				robot.keyPress(51);
				robot.keyRelease(51);
				break;
			case '4':
				robot.keyPress(52);
				robot.keyRelease(52);
				break;
			case '5':
				robot.keyPress(53);
				robot.keyRelease(53);
				break;
			case '6':
				robot.keyPress(54);
				robot.keyRelease(54);
				break;
			case '7':
				robot.keyPress(55);
				robot.keyRelease(55);
				break;
			case '8':
				robot.keyPress(56);
				robot.keyRelease(56);
				break;
			case '9':
				robot.keyPress(57);
				robot.keyRelease(57);
				break;

			case 'a': // letters
				robot.keyPress(65);
				robot.keyRelease(65);
				break;
			case 'b':
				robot.keyPress(66);
				robot.keyRelease(66);
				break;
			case 'c':
				robot.keyPress(67);
				robot.keyRelease(67);
				break;
			case 'd':
				robot.keyPress(68);
				robot.keyRelease(68);
				break;
			case 'e':
				robot.keyPress(69);
				robot.keyRelease(69);
				break;
			case 'f':
				robot.keyPress(70);
				robot.keyRelease(70);
				break;
			case 'g':
				robot.keyPress(71);
				robot.keyRelease(71);
				break;
			case 'h':
				robot.keyPress(72);
				robot.keyRelease(72);
				break;
			case 'i':
				robot.keyPress(73);
				robot.keyRelease(73);
				break;
			case 'j':
				robot.keyPress(74);
				robot.keyRelease(74);
				break;
			case 'k':
				robot.keyPress(75);
				robot.keyRelease(75);
				break;
			case 'l':
				robot.keyPress(76);
				robot.keyRelease(76);
				break;
			case 'm':
				robot.keyPress(77);
				robot.keyRelease(77);
				break;
			case 'n':
				robot.keyPress(78);
				robot.keyRelease(78);
				break;
			case 'o':
				robot.keyPress(79);
				robot.keyRelease(79);
				break;
			case 'p':
				robot.keyPress(80);
				robot.keyRelease(80);
				break;
			case 'q':
				robot.keyPress(81);
				robot.keyRelease(81);
				break;
			case 'r':
				robot.keyPress(82);
				robot.keyRelease(82);
				break;
			case 's':
				robot.keyPress(83);
				robot.keyRelease(83);
				break;
			case 't':
				robot.keyPress(84);
				robot.keyRelease(84);
				break;
			case 'u':
				robot.keyPress(85);
				robot.keyRelease(85);
				break;
			case 'v':
				robot.keyPress(86);
				robot.keyRelease(86);
				break;
			case 'w':
				robot.keyPress(87);
				robot.keyRelease(87);
				break;
			case 'x':
				robot.keyPress(88);
				robot.keyRelease(88);
				break;
			case 'y':
				robot.keyPress(89);
				robot.keyRelease(89);
				break;
			case 'z':
				robot.keyPress(90);
				robot.keyRelease(90);
				break;
			default: // prints a space as default
				robot.keyPress(32);
				robot.keyRelease(32);
			}

		}
	}

}
