import java.awt.Color;

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
    this.nameCircle = name;
  }

  public CircleGr(int x, int y, int radius, Color circleColor, String name) {
    super((double) x, (double) y, (double) radius);
    this.circleColor = circleColor;
    this.nameCircle = name;
  }

  public double convertToRadian(double radius) {
    return radius * Math.PI / 180;
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

}
