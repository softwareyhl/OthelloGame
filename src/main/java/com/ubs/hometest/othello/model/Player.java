package com.ubs.hometest.othello.model;

public class Player {
  private final String name;
  private Color color;

  public Player(String name, Color color) {
    super();
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }
}
