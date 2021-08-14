package com.bolton.test;

import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import com.bolton.util.Grid;
import com.bolton.view.Board;
import com.bolton.view.GaminArea;
import com.bolton.view.Snake;
import com.bolton.view.SnakePath;



class MainTest extends JFrame {

	private Board board;
	private Thread thread;
	private Snake snake;
	private GaminArea gameArea;
	
	private SnakePath direction = SnakePath.UP;
	private boolean started = false;
	
	@Test
	public void Main() {
		SnakeComponent();
		Game();
		Frame();
		
	}
	
	@Test
	private void SnakeComponent() {
		setLayout(new GridBagLayout());
		addKeyListener(new KeyboardHandler());
		gameArea  = new GaminArea();
		add(gameArea , new Grid(0,0,8,8));
		
		  board  = new Board();
		add(board , new Grid(0,8,8,1));
	}
	
	@Test
	private void Frame() {
		pack();
		setTitle("Snakeio");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
 }
	@Test
	private void Game() {
		
		snake = new Snake(gameArea, board);
}
	
	@Test
	public void newGame() {
		 started = true;
		thread.start();
	}

	
@Test
	public void gameover() {
	
	int returnValue = JOptionPane.showConfirmDialog(this, "Do you want to start a new game?", "GAME OVER!",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		
				switch (returnValue) {
				case JOptionPane.OK_OPTION:
					direction = SnakePath.UP;
					started = false;
					snake = new Snake(gameArea, board);
					board.clear();
					gameArea.initDefaults();
					board.repaint();
					gameArea.repaint();
					thread = null;
					break;
					}
	}


 private class KeyboardHandler extends KeyAdapter {
	
	 @Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (direction == SnakePath.DOWN)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(SnakePath.UP);
					direction = SnakePath.UP;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (direction == SnakePath.UP)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(SnakePath.DOWN);
					direction = SnakePath.DOWN;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (direction == SnakePath.RIGHT)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(SnakePath.LEFT);
					direction = SnakePath.LEFT;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (direction == SnakePath.LEFT)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(SnakePath.RIGHT);
					direction = SnakePath.RIGHT;
				}
			}
		}
 }

}
