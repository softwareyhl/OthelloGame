package com.ubs.hometest.othello.model;

public enum Color {
  WHITE('o'), BLACK('x'), NONE('-');
  private char facade;

  private Color(char facade) {
    this.facade = facade;
  }

  public char getFacade() {
    return facade;
  }

  public void setFacade(char facade) {
    this.facade = facade;
  }

  @Override
  public String toString() {
    return String.valueOf(this.facade);
  }
}
