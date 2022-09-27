package Primitives2D.Rectangle2D;

import java.awt.Graphics;
import java.awt.Color;

import Primitives2D.Rectangle2D.Rectangle;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;

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

  public SuperRectangleGr(Point p1, Point p2) {
    super((double) p1.getX(), (double) p1.getY(), (double) p2.getX(), (double) p2.getY());
    initialize();
  }

  public Color getRectangelColor() {
    return rectangelColor;
  }

  public void setRectangelColor(Color rectangelColor) {
    this.rectangelColor = rectangelColor;

    for (int i = 0; i < MAX; i++) {
      lines[i].setLineColor(rectangelColor);
    }
  }

}
