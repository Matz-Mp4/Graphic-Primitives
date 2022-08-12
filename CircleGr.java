import java.awt.Graphics;

public class CircleGr extends SuperCircleGr implements GraphicPrimitive {
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
    // A constant to find the amount needs to loop
    double inc = 0.18 / (getRadius() / 300);

    for (angule = 0; angule <= 90; angule += inc) {
      plotPoint(angule, point, g);
    }
  }

  public void erase(Graphics g) {

  }

}
