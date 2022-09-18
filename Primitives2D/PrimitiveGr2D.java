package Primitives2D;

import java.awt.Graphics;

public interface PrimitiveGr2D {
  public void draw(Graphics g);

  public void erase(Graphics g);

  public void changeThickness(int value);
}
