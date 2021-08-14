package com.bolton.view;

import java.awt.geom.Ellipse2D;

public class Eat {
	
	public static final int XSNAKE = 20;
	public static final int YSNAKE =20;
	
	private double x;
	private double y;
	
	public Eat(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Ellipse2D.Double getShape(){
		return new Ellipse2D.Double(x, y, XSNAKE, YSNAKE);
		
	}
	
	//generate the random numbers
	private double getNewSnakePart() {
		double dou = 1111;
		while(dou >= 400 || dou % 20 !=0) {
			dou = Math.random() * 1000;
			dou =(int) dou;
		}
		return dou;
		
	}
	
	// generate new coordinates
	public void next(Snake snake) {
		for(Ellipse2D.Double sn : snake.getSnakeParts()) {
			while(x == sn.getMinX() && y == sn.getMinY() ) {
				x = getNewSnakePart();
				y = getNewSnakePart();
			}
		}
		
	}

}
