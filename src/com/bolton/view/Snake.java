package com.bolton.view;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snake {
	
	//snake parts
		// one part is a 20 x 20 px ellipse.
		private List<Ellipse2D.Double> snakeParts;
		public static final int XSIZE = 20;
		public static final int YSIZE = 20;
		
		private GaminArea gameField;
		private Board scoreBoard;
		private SnakePath route;
		private Ellipse2D.Double temp;
		private Ellipse2D.Double ass;
		
		private boolean over = false;
		
		 public String state = "ggg";
		
		public Snake(GaminArea gameField, Board scoreBoard) {
			this.gameField = gameField;
			this.scoreBoard = scoreBoard;
			initDefaults();
		}
		
		public Snake() {
			
		}
		
		private void initDefaults() {
			// TODO Auto-generated method stub
			snakeParts = Collections.synchronizedList(new ArrayList<Ellipse2D.Double>());
			snakeParts.add(new Ellipse2D.Double(260, 260, 20, 20));
			snakeParts.add(new Ellipse2D.Double(260, 280, 20, 20));
			snakeParts.add(new Ellipse2D.Double(260, 300, 20, 20));
			snakeParts.add(new Ellipse2D.Double(260, 320, 20, 20));
			
		}

		//change snake directions
		public void changeDirection(SnakePath route) {
			this.route = route;
		}
		
		//snake moving in currunt direction
		public void move() {
			switch (route) {
			case UP:
				moveBody();
				snakeParts.set(0,
						new Ellipse2D.Double(snakeParts.get(0).getMinX(), snakeParts.get(0).getMinY() - 20, XSIZE, YSIZE));
				if (snakeParts.get(0).getMinY() < 0) {
					over = true;
				}
				break;
				
			case DOWN:
				moveBody();
				snakeParts.set(0,
						new Ellipse2D.Double(snakeParts.get(0).getMinX(), snakeParts.get(0).getMinY() + 20, XSIZE, YSIZE));
				if (snakeParts.get(0).getMaxY() > gameField.getBounds().getMaxY()) {
					over = true;
				}
				break;

			case LEFT:
				moveBody();
			snakeParts.set(0,
						new Ellipse2D.Double(snakeParts.get(0).getMinX() - 20, snakeParts.get(0).getMinY(), XSIZE, YSIZE));
				if (snakeParts.get(0).getMinX() < 0) {
					over = true;
				}
				break;

			case RIGHT:
				moveBody();
				snakeParts.set(0,
						new Ellipse2D.Double(snakeParts.get(0).getMinX() + 20, snakeParts.get(0).getMinY(), XSIZE, YSIZE));
				if (snakeParts.get(0).getMaxX() > gameField.getBounds().getMaxX()) {
					over = true;
				}
				break;

			default:
				new Exception("Unexcepted Direction value!").printStackTrace();
				break;
			}
		}
		
		


		private void moveBody() {
			// TODO Auto-generated method stub
			for(int i = snakeParts.size() - 1; i > 0; i--) {
				if(i == snakeParts.size() - 1) {
					ass = (Ellipse2D.Double) snakeParts.get(i).clone();
					}
				temp = (Ellipse2D.Double) snakeParts.get(i - 1).clone();
				snakeParts.set(i, temp);
			}
			
		}

		public List<Ellipse2D.Double> getSnakeParts() {
			// TODO Auto-generated method stub
			return snakeParts;
		}
		
		
		public void check() {
			Ellipse2D.Double head = snakeParts.get(0);
			Eat food = gameField.getFood();
			
			for(int i =1; i < snakeParts.size(); i++) {
				if(head.getMinX() == snakeParts.get(i).getMinX() && head.getMinY() == snakeParts.get(i).getMinY()) {
					over = true;
					return;
			}
		}
			if(head.getMinX() == food.getShape().getMinX() && head.getMinY() == food.getShape().getMinY()) {
				scoreBoard.ScoreAdding(1);
				food.next(this);
				snakeParts.add(ass);
			}
		}
			
			public boolean isGameOver() {
				return over;
				
			}

			 public int getSnakeSize(){
			        return this.snakeParts.size();
			    }
			    public String getCurrentDirection() {
			        return "" + this.state.charAt(0);
			    }
			    public void headUp() {
			        if (!"D".equals(this.getCurrentDirection()))
			            this.state = "U" + this.state.substring(1);;
			    }
			    public void headDown() {
			        if (!"U".equals(this.getCurrentDirection()))
			            this.state = "D" + this.state.substring(1);
			    }

			    public void headLeft() {
			        if (!"R".equals(this.getCurrentDirection()))
			            this.state = "L"  + this.state.substring(1);
			    }

			    public void headRight() {
			        if (!"L".equals(this.getCurrentDirection()))
			            this.state = "R" + this.state.substring(1);
			    }
			

		

}
