package snake_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * File: GamePanel.java Author: Abhijeet C Course: Practice clean code
 * Assignment: java_assignment Due Date: None Version: 1.0
 * 
 * GamePanel - A class representing the main panel of the Snake Game.
 * 
 * This class extends JPanel to create the main game panel where the game logic
 * and graphics are implemented.
 */
public class GamePanel extends JPanel implements ActionListener {

	// Width of the game screen
	static final int SCREEN_WIDTH = 600;

	// Height of the game screen
	static final int SCREEN_HEIGHT = 600;

	// Size of each game unit/object
	static final int UNIT_SIZE = 25;

	// Total number of game units that can fit on the screen
	static final int GAME_UNIT = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;

	// Delay for the timer in milliseconds
	static final int DELAY = 75;

	// Array to store x-coordinates of snake body parts
	final int x[] = new int[GAME_UNIT];

	// Array to store y-coordinates of snake body parts
	final int y[] = new int[GAME_UNIT];

	// Initial number of body parts for the snake
	int bodyParts = 6;

	// Total number of apples eaten by the snake
	int applesEaten;

	// X coordinate of the apple
	int appleX;

	// Y coordinate of the apple
	int appleY;

	// Direction of the snake ('R' for right, 'L' for left, 'U' for up, 'D' for
	// down)
	char direction = 'R';

	// Flag to indicate whether the game is running or not
	Boolean running = false;

	// Timer for controlling game speed
	Timer timer;

	// Random number generator for generating apple positions
	Random random;

	/**
	 * Constructor for the GamePanel class. Initializes the game panel with default
	 * settings and starts the game.
	 */
	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	/**
	 * Starts the game by initializing necessary variables and starting the timer.
	 */
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	/**
	 * Overrides the default paintComponent method to draw game graphics.
	 * 
	 * @param g The Graphics object used to draw components on the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	/**
	 * Draws the game graphics including snake, apple, and game over screen.
	 * 
	 * @param g The graphics object used to draw components on the panel.
	 */
	public void draw(Graphics g) {
		if (running) {
			// draw apple
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			// draw snake
			for (var i = 0; i < bodyParts; i++) {
				if (i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
		} else {
			gameOver(g);
		}
	}

	/**
	 * Generates a new apple at a random location on the game panel.
	 */
	public void newApple() {
		appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE; // horizontal box
		appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE; // vertical box
	}

	/**
	 * Moves the snake based on the current direction.
	 */
	public void move() {
		for (var i = bodyParts; i > 0; i--) { // It moves each body part to the position of the one in front of it.
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}

	/**
	 * Checks if the snake has eaten an apple.
	 */
	public void checkApple() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}

	/**
	 * Checks for collisions with walls or itself, and stops the game if necessary.
	 */
	public void checkCollision() {
		// checks if head collides with body
		for (var i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}

		// check if head touches left border
		if (x[0] < 0) {
			running = false;
		}
		// check if head touches right border
		if (x[0] > SCREEN_WIDTH) {
			running = false;
		}
		// check if head touches top border
		if (y[0] < 0) {
			running = false;
		}
		// check if head touches bottom border
		if (y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		if (!running) {
			timer.stop();
		}
	}

	/**
	 * Displays the game over screen.
	 * 
	 * @param g The graphics object used to draw components on the panel.
	 */
	public void gameOver(Graphics g) {
		// Game Over text
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		var metrics = getFontMetrics(g.getFont());
		g.drawString("GAME OVER", (SCREEN_WIDTH - metrics.stringWidth("GAME OVER")) / 2, SCREEN_HEIGHT / 2);

		// Display Score
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
				SCREEN_HEIGHT / 2 + g.getFont().getSize());
	}

	/**
	 * Performs the action in response to the timer event. Moves the snake, checks
	 * for apple consumption and collisions, and repaints the panel to update the
	 * game visuals.
	 * 
	 * @param e The ActionEvent representing the timer event.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (running) {
			move();
			checkApple();
			checkCollision();
		}
		repaint();
	}

	/**
	 * Custom KeyAdapter class to handle keyboard input for controlling the snake.
	 */
	public class MyKeyAdapter extends KeyAdapter {

		/**
		 * Handles the key pressed event to change the direction of the snake based on
		 * the arrow keys.
		 * 
		 * @param e The KeyEvent representing the key pressed event.
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if (direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}

}