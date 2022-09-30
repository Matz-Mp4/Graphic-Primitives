package Primitives2D.Rectangle2D;

import Primitives2D.Rectangle2D.Rectangle;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;

import java.awt.Graphics;
import java.awt.Color;

import Gui.GuiUtils;

/**
 * Retângulo gráfico.
 *
 * @author Gabriel Cavalcanti
 * @version 15/08/2021
 */

public class RectangleGr extends SuperRectangleGr implements PrimitiveGr2D {

  public RectangleGr(Point p1, Point p2) {
    super(p1, p2);
  }

  public void draw(Graphics g) {
    for (int i = 0; i < MAX; i++) {
      lines[i].setThickness(getThickness());
      lines[i].draw(g);
    }
  }

  public void erase(Graphics g) {
    for (int i = 0; i < MAX; i++) {
      lines[i].setLineColor(GuiUtils.getBackground());
      lines[i].draw(g);
      lines[i].setLineColor(GuiUtils.getForeground());
    }
  }

  public void changeThickness(int value) {
    setThickness(value);
  }

  public void changeColor(Color newColor) {
    setRectangelColor(newColor);
  }

  public void translation(Point p) {
    int dx = (int) (p.getX() - getDiagonal().getP1().getX());
    int dy = (int) (p.getY() - getDiagonal().getP1().getY());

    getDiagonal().getP1().setX(getDiagonal().getP1().getX() + dx);
    getDiagonal().getP1().setY(getDiagonal().getP1().getY() + dy);

    getDiagonal().getP2().setX(getDiagonal().getP2().getX() + dx);
    getDiagonal().getP2().setY(getDiagonal().getP2().getY() + dy);

    convertToRectangle(getDiagonal().getP1().getX(),
        getDiagonal().getP1().getY(),
        getDiagonal().getP2().getX(),
        getDiagonal().getP2().getY());

    for (int i = 0; i < MAX; i++) {
      lines[i] = new LineGr(getLine(i));
      lines[i].setLineColor(rectangelColor);
    }
  }

  public void scale(double k, Point p) {
    getDiagonal().getP1().setX(getDiagonal().getP1().getX() * k + p.getX() * (1 - k));
    getDiagonal().getP1().setY(getDiagonal().getP1().getY() * k + p.getY() * (1 - k));

    getDiagonal().getP2().setX(getDiagonal().getP2().getX() * k + p.getX() * (1 - k));
    getDiagonal().getP2().setY(getDiagonal().getP2().getY() * k + p.getY() * (1 - k));

    convertToRectangle(getDiagonal().getP1().getX(),
        getDiagonal().getP1().getY(),
        getDiagonal().getP2().getX(),
        getDiagonal().getP2().getY());

    for (int i = 0; i < MAX; i++) {
      lines[i] = new LineGr(getLine(i));
      lines[i].setLineColor(rectangelColor);
    }
  }

  public void rotation(Point p, double angule) {

    double radian = angule * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.cos(radian);

    getDiagonal().setP1(new Point(getDiagonal().getP1().getX() * cos - getDiagonal().getP1().getY() * sin,
        getDiagonal().getP1().getX() * sin + getDiagonal().getP1().getY() * cos));

    getDiagonal().setP2(new Point(getDiagonal().getP2().getX() * cos - getDiagonal().getP2().getY() * sin,
        getDiagonal().getP2().getX() * sin + getDiagonal().getP2().getY() * cos));

    convertToRectangle(getDiagonal().getP1().getX(),
        getDiagonal().getP1().getY(),
        getDiagonal().getP2().getX(),
        getDiagonal().getP2().getY());

    for (int i = 0; i < MAX; i++) {
      lines[i] = new LineGr(getLine(i));
      lines[i].setLineColor(rectangelColor);
    }

  }
}
