package com.bolton.panel;

import com.bolton.main.Main;
import com.bolton.view.Eat;
import com.bolton.view.GaminArea;
import com.bolton.view.Snake;

//running game and making snake movings
public class Panel implements Runnable {
	
	public static final int DELAY = 400;
	private Main main;
	private GaminArea gameArea;
	private Eat food;
	private Snake snake;
	
	public Panel(GaminArea gameField, Snake snake, Main main) {
		food = new Eat(100,100);
		this.main = main;
		this.snake = snake;
		this.gameArea = gameField;
		
		this.gameArea.setSnakeParts(snake.getSnakeParts());
		this.gameArea.setApple(food);
	}

	@Override
	public void run() {
	
		try {
			while(true) {
				snake.move();
				snake.check();
				if(snake.isGameOver()) {
					Thread.currentThread().interrupt();
				}
				if(!Thread.currentThread().isInterrupted()) {
					gameArea.repaint();
				}
				Thread.sleep(DELAY);
			}
		}catch (InterruptedException e) {
		    main.gameover();
		}
		
	}
	

}
