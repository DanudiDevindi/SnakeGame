package com.bolton.util;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Grid extends GridBagConstraints{
	
	public Grid(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
	}
	
	public Grid(int gridx, int gridy, int gridwidth, int gridheight) {
		this(gridx, gridy);
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
		
	}
	
	public Grid setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}
	
	public Grid setFill(int fill) {
		this.fill = fill;
		return this;
	}
	
	public Grid setWeight(double weightx, double weighty) {
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}

	public Grid setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
		
	}
	
	public Grid setInsets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	
	}
	public Grid setIpad(int ipadx, int ipady) {
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}
