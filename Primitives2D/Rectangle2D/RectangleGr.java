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

    int dx = (int)Math.abs(getDiagonal().getP1().getX() - getDiagonal().getP2().getX());
    int dy = (int)Math.abs(getDiagonal().getP1().getY() - getDiagonal().getP2().getY());

    getDiagonal().getP1().setX(p.getX() - dx / 2);
    getDiagonal().getP1().setY(p.getY() - dy / 2);

    getDiagonal().getP2().setX(p.getX() + dx / 2);
    getDiagonal().getP2().setY(p.getY() + dy / 2);

    convertToRectangle(getDiagonal().getP1().getX(),
        getDiagonal().getP1().getY(),
        getDiagonal().getP2().getX(),
        getDiagonal().getP2().getY());
  }
}
