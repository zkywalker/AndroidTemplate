package me.arulnadhan.fabloading.model;

public class Circle {

  public float x;
  public float y;
  public float radius;

  public Circle() {
  }

  /**
   * Restores to default values
   */
  public void restore() {
    x = 0;
    y = 0;
    radius = 0;
  }
}
