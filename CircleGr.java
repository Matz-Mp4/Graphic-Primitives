import java.awt.Color;
import java.awt.Graphics;

public class CircleGr extends Circle {

  private Color circleColor = Color.BLACK; // cor do ponto
  private String circleName = "Generic Name"; // nome do ponto
  private Color circleNameColor = Color.BLACK; // cor do nome (string) do ponto

  public CircleGr(int x, int y, int radius) {
    super((double) x, (double) y, (double) radius);

  }

  public CircleGr(int x, int y, int radius, Color circleColor) {
    super((double) x, (double) y, (double) radius);
    this.circleColor = circleColor;
  }

  public CircleGr(int x, int y, int radius, String name) {
    super((double) x, (double) y, (double) radius);
    this.circleName = name;
  }

  public CircleGr(int x, int y, int radius, Color circleColor, String name) {
    super((double) x, (double) y, (double) radius);
    this.circleColor = circleColor;
    this.circleName = name;
  }

  public double convertToRadian(double radius) {
    return radius * (Math.PI / 180);
  }

  public Color getCircleColor() {
    return circleColor;
  }

  public void setCircleColor(Color circleColor) {
    this.circleColor = circleColor;
  }

  public String getCircleName() {
    return circleName;
  }

  public void setCircleName(String circleName) {
    this.circleName = circleName;
  }

  public Color getCircleNameColor() {
    return circleNameColor;
  }

  public void setCircleNameColor(Color circleNameColor) {
    this.circleNameColor = circleNameColor;
  }

  public void drawCircle(Graphics g) {
    double cordX, cordY;
    double row, rowEnd;
    double rowRadian;
    rowEnd = Math.round(2 * Math.PI * getRadius());

    for (row = 1; row <= rowEnd ; row++) {
      rowRadian = convertToRadian(row);
      cordX = Math.cos(rowRadian) * getRadius() + getX();
      cordY = Math.sin(rowRadian) * getRadius() + getY();
      cordX = Math.round(cordX);
      cordY = Math.round(cordY);

      DotGr ponto = new DotGr((int) cordX, (int) cordY, circleColor);
      ponto.drawDot(g);

    }
  }

}
