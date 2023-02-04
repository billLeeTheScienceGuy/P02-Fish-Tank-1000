//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish Tank
// Course:   CS 300 Fall 2021
//
// Author:   Bill Lee
// Email:    blee266@wisc.edu
// Lecturer: Mouna Kacem
//
//
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;
public class FishTank {
	private static PApplet processing; // PApplet object that represents the graphic
	// interface of the JunglePark application
	private static PImage backgroundImage; // PImage object that represents the
	// background image
	private static Fish[] fishes; // perfect size array storing the different fish present
	// in the fish tank. These fish can be of different species.
	private static Random randGen; // Generator of random numbers
	/**
	* Defines the initial environment properties of this application
	* @param processingObj a reference to the graphic display window of this application
	*/
	public static void setup(PApplet processingObj) {
		FishTank.processing = processingObj;
		// load the image of the background
		backgroundImage = processing.loadImage("images/background.png");
		// Draw the background image at the center of the screen
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		// width [resp. height]: System variable of the processing library that stores
		// the width [resp. height] of the display window.
		fishes = new Fish[8];
		randGen = new Random();
	}
	/**
	* Draws and updates the application display window.
	* This callback method called in an infinite loop.
	*/
	public static void draw() {
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		for (int i = 0; i < fishes.length; ++i) {
			if (fishes[i] != null) {
				fishes[i].draw();
			}
		}
	}
	/**
	* Checks if the mouse is over a specific Fish whose reference is provided
	* as input parameter
	*
	* @param Fish reference to a specific fish
	* @return true if the mouse is over the specific Fish object (i.e. over
	* the image of the Fish), false otherwise
	*/
	public static boolean isMouseOver(Fish Fish) {
		for(int i = 0; i < fishes.length; ++i) {
		if (Fish != null) {
		float x = Fish.getPositionX();
		float y = Fish.getPositionY();
		float w = (Fish.getImage().width)/2;
		float h = (Fish.getImage().height)/2;
		if((x - w) <= processing.mouseX && (x + w) >= processing.mouseX && (y - h)
				<= processing.mouseY && (y + h) >= processing.mouseY) {
			return true;
		}
		}
		}
		return false;
	}
		/**
		* Callback method called each time the user presses the mouse
		*/
		public static void mousePressed() {
			for(int i = 0; i < fishes.length; ++i) {
				if (fishes[i] != null){
					if(isMouseOver(fishes[i])) {
						fishes[i].setDragging(true);
						break;
					}
					
				}
			}
		}
		/**
		* Callback method called each time the mouse is released
		*/
		public static void mouseReleased() {
			for(int i = 0; i < fishes.length; ++i) {
				if (fishes[i] != null){
					fishes[i].setDragging(false);
				}
		}
			return;
		}
		/**
		* Callback method called each time the user presses a key
		*/
		public static void keyPressed() {
			for(int i = 0; i < fishes.length; ++i) {
			if(processing.key == 'f' || processing.key == 'F') {
				if(fishes[i] == null) {
					fishes[i] = new Fish(processing, (float)randGen.nextInt(processing.width), (float)randGen.nextInt(processing.height));
					break;
				}
				}	
				if(processing.key == 'r' || processing.key == 'R') {
						if(fishes[i] != null) {
								if(isMouseOver(fishes[i])) {
										fishes[i] = null;
										return;
			}
			}
			}
			}
			}			
public static void main(String[] args) {
		Utility.startApplication();
	}
}