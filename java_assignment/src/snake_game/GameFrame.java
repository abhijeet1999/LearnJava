package snake_game;

import javax.swing.JFrame;

/**
 * File: GameFrame.java Author: Abhijeet C Course: Practice clean code
 * Assignment: java_assignment Due Date: None Version: 1.0
 * 
 * GameFrame - A class representing the main frame of the Snake Game.
 * 
 * This class extends JFrame to create the main window/frame of the game.
 */
public class GameFrame extends JFrame {

	/**
	 * Constructor for the GameFrame class. Initializes the game frame with default
	 * settings and adds a new instance of GamePanel to it.
	 */
	GameFrame() {

		this.add(new GamePanel()); // Initializing GamePanel without keeping an instance and adding to frame
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // to set frame in the center of the screen

	}

}
