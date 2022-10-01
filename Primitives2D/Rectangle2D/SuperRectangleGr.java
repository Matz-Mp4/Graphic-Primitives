package Primitives2D.Rectangle2D;

import java.awt.Graphics;
import java.awt.Color;

import Primitives2D.Rectangle2D.Rectangle;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;

/**
 * Class that serves as a helper to not create too many functions in the main class.
 * It has getter and setter functions.
 * @version 1.0.0
 */
public class SuperRectangleGr extends Rectangle {

  protected LineGr[] lines;

  protected final int MAX = 4;
  protected Color rectangelColor;

  private void initialize() {
    lines = new LineGr[4];
    rectangelColor = Color.BLACK;

    for (int i = 0; i < MAX; i++) {
      lines[i] = new LineGr(getLine(i));
      lines[i].setLineColor(rectangelColor);
    }
  }
/**
 * @return LineGr
 */

  public LineGr getLineGr(int index){
    return lines[index];
  }

  public void createRectangle(PointGr A, PointGr B, PointGr C, PointGr D){
    lines[0] = new LineGr(A, B);
    lines[1] = new LineGr(A, C);
    lines[2] = new LineGr(D, B);
    lines[3] = new LineGr(D, C);
  }

  /**
   * Constructs a rectangle at position p1, p2 and with attributes
   * 
   * @param p1      point p1
   * @param p2      point p2
   */
  public SuperRectangleGr(Point p1, Point p2) {
    super((double) p1.getX(), (double) p1.getY(), (double) p2.getX(), (double) p2.getY());
    initialize();
  }

  public Color getRectangelColor() {
    return rectangelColor;
  }
 
  /**
   * Sets the color of the border of Rectangle
   * 
   * @param rectangelColor
   */
  public void setRectangelColor(Color rectangelColor) {
    this.rectangelColor = rectangelColor;

    for (int i = 0; i < MAX; i++) {
      lines[i].setLineColor(rectangelColor);
    }
  }


}
