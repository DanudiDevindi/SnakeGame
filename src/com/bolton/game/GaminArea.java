package com.bolton.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GaminArea extends JPanel {
	
	private static final int AREA_WIDTH = 800;
	private static final int AREA_HEIGHT = 400;
	private BufferedImage image;
	
	private List<Ellipse2D.Double> snakeParts;
	private Eat apples;
	
	public GaminArea() {
		setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		java.net.URL resource = getClass().getResource("th.jpg");
		
		try {
			image = ImageIO.read(resource);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		initDefaults();
	}

	public void initDefaults() {
		// TODO Auto-generated method stub
		apples = new Eat(200, 200);
		snakeParts = Collections.synchronizedList(new ArrayList<Ellipse2D.Double>());
		snakeParts.add(new Ellipse2D.Double(260,260,20,20));
		snakeParts.add(new Ellipse2D.Double(260,280,20,20));
		snakeParts.add(new Ellipse2D.Double(260,300,20,20));
		snakeParts.add(new Ellipse2D.Double(260,320,20,20));
	}
	
	public void setSnakeParts(List<Ellipse2D.Double> snakeParts) {
		this.snakeParts = snakeParts;
	}
	
	public void setApple(Eat food) {
		this.apples = food;
	}
	public Eat getFood() {
		return apples;
	}
	
	@Override
	public void paintComponent(Graphics grp) {
		super.paintComponent(grp);
		Graphics2D grps = (Graphics2D) grp ;
		super.paintComponent(grp);
		grp.drawImage(image, 0, 0, 800, 800, this);
		grps.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		grps.setPaint(Color.RED);
		grps.fillOval((int) apples.getShape().getMinX() + 7, (int) apples.getShape().getMinY() + 7, 20, 20);
		grps.setPaint(new Color(0,0,139));
		for(Ellipse2D e : snakeParts) {
			grps.fill(e);
		}
		grps.setPaint(new Color(0,0,139));
		grps.fill(snakeParts.get(0));
	}
	

}
