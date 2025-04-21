package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	 private Snake snake;
	    private Food food;

	    public Game() {
	        StdDraw.enableDoubleBuffering();
	        snake = new Snake();
	        food = new Food();
	    }

	    public void play() {
	        while (snake.isInbounds()) {
	            int dir = getKeypress();
	            if (dir != -1) {
	                snake.changeDirection(dir);
	            }

	            snake.move();

	            if (snake.eatFood(food)) {
	                food = new Food(); // new food if eaten
	            }

	            updateDrawing();
	        }

	        // Optional game over message
	        StdDraw.clear();
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(0.5, 0.5, "Game Over!");
	        StdDraw.show();
	    }

	    /**
	     * Gets the key currently being pressed (WASD) and maps to direction
	     */
	    private int getKeypress() {
	        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) return 1; // up
	        else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) return 2; // down
	        else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) return 3; // left
	        else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) return 4; // right
	        else return -1;
	    }

	    /**
	     * Clears the screen, draws the snake and food, pauses, and shows content
	     */
	    private void updateDrawing() {
	        StdDraw.clear();
	        food.draw();
	        snake.draw();
	        StdDraw.show();
	        StdDraw.pause(50); // adjust speed here
	    }

	    public static void main(String[] args) {
	        Game g = new Game();
	        g.play();
	    }
}