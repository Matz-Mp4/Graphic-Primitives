package Primitives2D.Circle2D;

import java.awt.Graphics;
import java.awt.Color;

import Gui.GuiUtils;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Point2D.*;

public class CircleGr extends SuperCircleGr implements PrimitiveGr2D {

  public CircleGr(SuperCircleGr circle) {
    super(circle);
  }

  public CircleGr(int x, int y, int radius, String name) {
    super(x, y, radius, name);
  }

  public CircleGr(int x, int y, int radius) {
    super(x, y, radius);
  }

  public void draw(Graphics g) {
    double angule, rowEnd;

    PointGr point = new PointGr();
    point.setDiameter(getThickness());
    // A constant to find the amount needs to loop
    double inc = 0.18 / (getRadius() / 300);

    for (angule = 0; angule <= 90; angule += inc) {
      plotPoint(angule, point, g, getCircleColor());
    }
  }

  public void erase(Graphics g) {
    setCircleColor(GuiUtils.getBackground());
    draw(g);
    setCircleColor(GuiUtils.getForeground());
  }

  public void changeThickness(int value) {
    setThickness(value);
  }

  public void changeColor(Color newColor) {
    setCircleColor(newColor);
  }

  public void translation(Point p) {

    setX(p.getX());
    setY(p.getY());
  }

  public void scale(double k, Point p) {
    setX(getX() * k + p.getX() * (1 - k));
    setY(getY() * k + p.getY() * (1 - k));
    setRadius(getRadius() * k);

  }

  public void rotation(Point p, double angule) {

    double radian = angule * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.sin(radian);

    setX(getX() * cos - getY() * sin + p.getX());
    setY(getX() * sin + getY() * cos + p.getY());
  }
}
