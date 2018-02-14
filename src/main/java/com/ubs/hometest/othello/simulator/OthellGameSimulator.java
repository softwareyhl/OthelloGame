package com.ubs.hometest.othello.simulator;

import com.ubs.hometest.othello.controller.OthellGame;

public class OthellGameSimulator {

	public static void main(String[] args) {
		OthellGame othello = new OthellGame("Sam", "Rock");
		othello.playGame();
		
		othello.resetGame();
	}
}
