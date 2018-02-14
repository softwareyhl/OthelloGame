package com.ubs.hometest.othello.model;

import java.io.Serializable;

public class Board implements Serializable{
	private int blackCount = 0;
	private int whiteCount = 0;
	private int emptyCount = 0;
	private Point[][] board;
	private static final int DEFAULT_ROWS = 8;
	private static final int DEFAULT_COLS = 8;

	public Board(int rows, int cols) {
		if (rows < 1 || cols < 1 || rows > 30 || cols > 30) {
			throw new IllegalArgumentException("Please check on input parameter: rows: " + rows + " cols: " + cols  );
		}
		board = new Point[rows][cols];
		initialize();
	}
	
	public Board() {
		board = new Point[DEFAULT_ROWS][DEFAULT_COLS];
		initialize();
	}

	public void initialize() {
		blackCount = 0;
		whiteCount = 0;
		emptyCount = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Point(i, j, Color.NONE);
				emptyCount++;
			}
		}
	}
	
	public void reset() {
		initialize();
	}
	
	public boolean isFull() {
		return emptyCount == 0;
	}

	public boolean placeColor(int row, int col, Color color){
		if (board[row][col] != null)
			return false;
		
		switch (color) {
		case BLACK:
			board[row][col].setColor(color);
			blackCount++;
			break;
		case WHITE:
			board[row][col].setColor(color);
			whiteCount++;
			break;
		default:
			board[row][col].setColor(color);
			emptyCount++;
			break;
		}
		return true;
	}

	public int getScoreForColor(Color c){
		if (c == Color.BLACK)
			return blackCount;
		else
			return whiteCount;
	}
	
	public Point[][] getDeepCopyOfBoard() {
		int rows = this.board.length;
		int cols = this.board[0].length;
		Point[][] boardCopy = new Point[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boardCopy[i][j] = this.board[i][j];
			}
		}
		return boardCopy;
	}
	
	public String snapshot() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j].getColor().getFacade());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public int getWidth() {
		return this.board.length;
	}
	
	public int getHeight() {
		return this.board[0].length;
	}
}