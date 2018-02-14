package com.ubs.hometest.othello.controller;

import com.ubs.hometest.othello.model.Point;
import java.util.Scanner;
import com.ubs.hometest.othello.model.Board;
import com.ubs.hometest.othello.model.Color;
import com.ubs.hometest.othello.model.Player;
import com.ubs.hometest.othello.view.GameViewer;

public class OthellGame implements Game {
	
	private Player player1;
	private Player player2;
	private Board  board;
	private GameViewer viewer = GameViewer.getInstance();
	private int round;
	private Player nextMover; 
	private Scanner scan = null;
	private static final int[] X_COORDINATION = {-1, 0, 1};
	private static final int[] Y_COORDINATION = {-1, 0, 1};
	public OthellGame(String playerName1, String playerName2) {
		this.player1 = new Player(playerName1, Color.WHITE);
		this.player2 = new Player(playerName2, Color.BLACK);
		scan = new Scanner(System.in);
		nextMover = this.player1;
		this.board = new Board();
	}

	public OthellGame(String playerName1, String playerName2, int boardSize) {
		this.player1 = new Player(playerName1, Color.WHITE);
		this.player2 = new Player(playerName1, Color.BLACK);
		nextMover = this.player1;
		scan = new Scanner(System.in);
		this.board = new Board(boardSize,boardSize);
	}
	
	public void playGame() {
		round++;
		while (!isGameOver()) {
			boolean valid = false;
			int row = 0;
			int col = 0;
			while (!valid) {
			    int[] cmd = commandParser(scan);
				row = cmd[0];
				col = cmd[1];
				viewer.printPlayerAndMove(nextMover, row, col);
				if (isValidMove(nextMover, row, col)) {
					valid = true;
				} else {
					viewer.inputAgain();
					continue;
				}
			}
			flipPieces(nextMover.getColor(), row, col);
			viewer.display(player1, player2, board);
			swithPlayer();
		}
	}
	
	protected int[] commandParser(Scanner in){
		int[] parsed = new int[2];
		int row;
		int col;
		if((in.hasNextLine())){
			String tmp = in.nextLine();
			String[] commandSpliter = tmp.split(" ");
			if (commandSpliter.length != 2) {
				throw new IllegalArgumentException("Plese check on your input, move command format should be : row column");
			}
			row = Integer.valueOf(commandSpliter[0]) - 1;
			col = commandSpliter[1].charAt(0) - 'a';
			parsed[0] = row;
			parsed[1] = col;
		}
		return parsed;	
	}

	public void resetGame() {
		this.board.reset();
	}
	
	private void swithPlayer() {
		if (nextMover == this.player1) {
			nextMover = this.player2;
		} else {
			nextMover = this.player1;
		}
	}
	
	private void flipPieces(Color color, int row, int col) {
		
	}
	
	private boolean isValidMove(Player player, int row, int col) {
		
		 boolean result=false;
		 Color opColor = Color.BLACK;
		 if (player.getColor() == Color.BLACK) {
			 opColor = Color.WHITE;
		 }
		 Point[][] cordinates = board.getDeepCopyOfBoard();
		 int boardWidth = this.board.getWidth();
		 int boardHeight = this.board.getHeight();
		  if (cordinates[row][col].getColor() == Color.NONE) {
			  
			  for (int i = 0; i < X_COORDINATION.length; i++) {
				for (int j = 0; j < Y_COORDINATION.length; j++) {
					if (i == 0 && j == 0) { // this is input itself
						continue;
					} else if (row + i > boardWidth || row + i < 0) {
						continue;
					} else if (col + j > boardHeight || col + j < 0) {
						continue;
					} else if (cordinates[row + i][col + j].getColor() == opColor){
						result=true;
						break;
					}
				}
			}
		  }
		  return result;
	}
	
	public int getRoundCount() {
		return this.round;
	}

	public boolean isGameOver() {
		
		return this.board.isFull();
	}
}
