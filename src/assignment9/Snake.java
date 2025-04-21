package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
	    segments = new LinkedList<>();
	    // Start in the center of the screen
	    BodySegment head = new BodySegment(0.5, 0.5, SEGMENT_SIZE);
	    segments.add(head);
	
	    deltaX = 0;
	    deltaY = 0;
	}
	
	public void changeDirection(int direction) {
	    if (direction == 1) { // up
	        deltaY = MOVEMENT_SIZE;
	        deltaX = 0;
	    } else if (direction == 2) { // down
	        deltaY = -MOVEMENT_SIZE;
	        deltaX = 0;
	    } else if (direction == 3) { // left
	        deltaX = -MOVEMENT_SIZE;
	        deltaY = 0;
	    } else if (direction == 4) { // right
	        deltaX = MOVEMENT_SIZE;
	        deltaY = 0;
	    }
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 */
	public void move() {
	    // Move all segments to the position of the one before it
	    for (int i = segments.size() - 1; i > 0; i--) {
	        BodySegment current = segments.get(i);
	        BodySegment previous = segments.get(i - 1);
	        current.setX(previous.getX());
	        current.setY(previous.getY());
	    }
	
	    // Move the head
	    BodySegment head = segments.getFirst();
	    head.setX(head.getX() + deltaX);
	    head.setY(head.getY() + deltaY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
	    for (BodySegment segment : segments) {
	        segment.draw();
	    }
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 */
	public boolean eatFood(Food f) {
	    BodySegment head = segments.getFirst();
	    double dx = head.getX() - f.getX();
	    double dy = head.getY() - f.getY();
	    double distance = Math.sqrt(dx * dx + dy * dy);
	
	    if (distance < SEGMENT_SIZE + Food.FOOD_SIZE) {
	        // Add new segment at the same position as the last segment
	        BodySegment last = segments.getLast();
	        BodySegment newSegment = new BodySegment(last.getX(), last.getY(), SEGMENT_SIZE);
	        segments.addLast(newSegment);
	        return true;
	    }
	
	    return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 */
		    public boolean isInbounds() {
		        BodySegment head = segments.getFirst();
		        double x = head.getX();
		        double y = head.getY();
		        return (x >= 0 && x <= 1 && y >= 0 && y <= 1);
		}
	}
