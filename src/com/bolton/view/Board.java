package com.bolton.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Board extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int BOARD_WIDTH = 800;
	public static final int BOARD_HEIGHT = 50;
	private Font FONT = null;
	private final String gameScore = "-      Your Score";
	private String score;
	
	public Board() {
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		setBackground(Color.black);
		
		score = "0";
		FONT = new Font("Arial", Font.BOLD, 22);
	}
	
	public void clear() {
		score = "0";
	}
	
	public void ScoreAdding(int points) {
		int oldValue = Integer.parseInt(score);
		oldValue += points;
		score = new String(oldValue + "");
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gra = (Graphics2D) g;
		gra.setFont(FONT);
		gra.setPaint(new Color(255, 255, 215));
		gra.drawString(score, 250, 32);
		gra.setPaint(new Color(255, 255, 215));
		gra.drawString(gameScore, 300, 32);
		
	}
	
	
	

	

}
