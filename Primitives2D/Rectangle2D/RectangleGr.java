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
    
    getDiagonal().translationLine(p);
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
    getDiagonal().scaleLine(k, p);

    convertToRectangle(getDiagonal().getP1().getX(),
        getDiagonal().getP1().getY(),
        getDiagonal().getP2().getX(),
        getDiagonal().getP2().getY());

    for (int i = 0; i < MAX; i++) {
      lines[i] = new LineGr(getLine(i));
      lines[i].setLineColor(rectangelColor);
    }
  }


  /**
   * p1 ja tenho
   * p2 ja tenho
   * p1.x p2.y
   * p1.y p2.x
   */
  public void rotation(Point p, double angule) {

    double radian = angule * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.cos(radian);


    getDiagonal().rotationLine(p, angule);

    for (int i = 0; i < MAX; i++) {
      lines[i].rotationLine(p, angule);
    }

  }
}
