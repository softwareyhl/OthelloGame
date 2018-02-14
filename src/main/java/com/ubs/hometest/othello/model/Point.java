package com.ubs.hometest.othello.model;

public class Point{
	private Color color;
	private final int x;
	private final int y;

	public Point(int x, int y, Color c){
		this.x = x;
		this.y = y;
		color = c;
	}

	public void flip(){
		if (color == Color.BLACK){
			color = Color.WHITE;
		}
		else
			color = Color.BLACK;
	}

	public Color getColor(){
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}