package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	 public static final double FOOD_SIZE = 0.02;
	    private double x, y;

	    /**
	     * Creates a new Food at a random location
	     */
	    public Food() {
	        x = Math.random();         // random double between 0 and 1
	        y = Math.random();
	    }

	    /**
	     * Draws the Food
	     */
	    public void draw() {
	        StdDraw.setPenColor(Color.RED);
	        StdDraw.filledCircle(x, y, FOOD_SIZE);
	    }

	    // Getters for x and y (helpful for collision detection)
	    public double getX() {
	        return x;
	    }

	    public double getY() {
	        return y;
	    }
	
}
