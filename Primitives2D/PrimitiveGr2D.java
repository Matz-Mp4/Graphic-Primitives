package Primitives2D;

import java.awt.Graphics;
import java.awt.Color;
import Primitives2D.Point2D.*;


  /**
   * Class that help to generalize operations in all primitives2D  
   */
 
public interface PrimitiveGr2D {

  public void draw(Graphics g);

  public void erase(Graphics g);

  public void changeThickness(int value);

  public void changeColor(Color newColor);

  public void translation(Point p);

  public void scale(double k, Point p);
   
  public void rotation(Point p, double angule); 
}
