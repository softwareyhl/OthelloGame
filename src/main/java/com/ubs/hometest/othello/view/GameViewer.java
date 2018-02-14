/**
 * 
 */
package com.ubs.hometest.othello.view;

import org.apache.commons.lang.StringUtils;

import com.ubs.hometest.othello.model.Board;
import com.ubs.hometest.othello.model.Player;

/**
 * @author Haoliang Yu
 *
 * 2018Äê2ÔÂ13ÈÕ
 */
public class GameViewer {

	
	private  static GameViewer singleInstance = new GameViewer();
	
	private GameViewer() {
		
	}
	
	public static GameViewer getInstance() {
		return singleInstance;
	}
	
	
	/**
	 * print snapshot of game
	 * @param player1
	 * @param player2
	 * @param board
	 */
	public  void display(Player player1, Player player2, Board board) {
		printLine();
		String playerName1 = rightPadding(player1.getName(),20);
		String playerName2 = rightPadding(player2.getName(),20);
		System.out.println(playerName1 + "    VS    " + playerName2);
		String score1 = rightPadding(String.valueOf(board.getScoreForColor(player1.getColor())), 20);
		String score2 = rightPadding(String.valueOf(board.getScoreForColor(player2.getColor())), 20);
		System.out.println(score1 + "    VS    " + score2);
		System.out.println(board.snapshot());
		printLine();
	}
	
	
	/**
	 * used to print input from player
	 * @param player
	 * @param row
	 * @param col
	 */
	public void printPlayerAndMove(Player player, int row, int col) {
		System.out.println("It's " + player.getName() + " 's move!" + "row : " + row + " and col : " + col);
	}
	
	/**
	 * error message used to reminder player
	 */
	public void inputAgain() {
		System.out.println("Please input your move again!");
	}
	
	private  String rightPadding(String str, int size) {
		return  StringUtils.rightPad(str, size);
	}
	private  void printLine() {
		System.out.println("------------------------------------------------------------");
	}
}
