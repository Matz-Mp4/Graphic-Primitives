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

/**
   * Class that handles the rectangle Graphical
   */
public class RectangleGr extends SuperRectangleGr implements PrimitiveGr2D {

  public RectangleGr(Point p1, Point p2) {
    super(p1, p2);
  }

  /**
   * draw a rectangle 
   * @param Graphics g
   */
 
  public void draw(Graphics g) {
    for (int i = 0; i < MAX; i++) {
      lines[i].setThickness(getThickness());
      lines[i].draw(g);
    }
  }

  /**
   * erase a rectangle from the screen
   * @param Graphics g
   */
 
  public void erase(Graphics g) {
    for (int i = 0; i < MAX; i++) {
      Color recColor =  getRectangelColor() ;
      lines[i].setLineColor(GuiUtils.getBackground());
      lines[i].draw(g);
      lines[i].setLineColor(recColor);
    }
  }

  /**
   * change the thickness of  rectangle 
   * @param int value
   */
 
  public void changeThickness(int value) {
    setThickness(value);
  }

  /**
   * change the color of  rectangle 
   * @param Color color
   */
 
  public void changeColor(Color newColor) {
    setRectangelColor(newColor);
  }
  /**
   * move the rectangle to a point  
   * @param Point p
   */
 
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
    updateLines(this);
  }

  /**
   * change the size of the rectangle  
   * @param double k, Point p, 
   */
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
    updateLines(this);
  }



  /**
   * rotate the rectangle from reference point  
   * @param double k, Point p, 
   */
  public void rotation(Point p, double angule) {

    double radian = angule * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.cos(radian);


    getDiagonal().rotationLine(p, angule);

    for (int i = 0; i < MAX; i++) {
      lines[i].rotationLine(p, angule);
    }
    updateLines(this);
  }
}
