package com.bolton.game;

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
		// TODO Auto-generated method stub
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
			// TODO: handle exception
			main.gameover();
		}
		
	}
	

}
