package com.bolton.game;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main extends JFrame {
	
	private Board board;
	private Thread thread;
	private Snake snake;
	private GaminArea gameArea;
	private SnakePath direction = SnakePath.UP;
	private boolean started = false;
	
	public Main() {
		SnakeComponent();
		Game();
		Frame();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Main();
				
			}
		});
	}

	private void SnakeComponent() {
		// TODO Auto-generated method stub
		setLayout(new GridBagLayout());
		addKeyListener(new KeyboardHandler());
		gameArea = new GaminArea();
		add(gameArea, new Grid(0,0,8,8));
		board = new Board();
		add(board , new Grid(0,8,8,1));
	}
		
	
	private void Game() {
		
		snake = new Snake(gameArea, board);
		Runnable r = new Panel(gameArea, snake, this);
		thread = new Thread(r);
		
	}
		
		private void Frame() {
			pack();
			setTitle("Snakeio");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setVisible(true);
			
	 }
		
		
		public void newGame() {
			 started = true;
			thread.start();
		}

		
		
//		public static void main (String [] args) {
//		System.out.println("sanke game");
//		}

		public void gameover() {
			// TODO Auto-generated method stub
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
						Runnable r = new Panel(gameArea, snake, this);
						thread = null;
						thread = new Thread(r);
						break;
			
					case JOptionPane.CANCEL_OPTION:
						System.exit(0);
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
		