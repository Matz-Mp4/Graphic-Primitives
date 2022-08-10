import java.awt.Color;
import java.awt.Graphics;

public class LineGr extends Line {

  private Color lineColor = Color.BLACK;
  private String nameLine = "";
  private Color nameLineColor = Color.BLACK;

  public LineGr(int x1, int y1, int x2, int y2) {
    super((double) x1, (double) y1, (double) x2, (double) y2);
    setLineColor(this.lineColor);
    setNameLineColor(this.nameLineColor);
    setNameLine("Generic Name");
  }

  public LineGr(int x1, int y1, int x2, int y2, String nome) {
    super((double) x1, (double) y1, (double) x2, (double) y2);
    setLineColor(lineColor);
    setNameLineColor(nameLineColor);
    setNameLine(nome);
  }

  public LineGr(int x1, int y1, int x2, int y2, Color corReta, Color corNome, String nome) {
    super((double) x1, (double) y1, (double) x2, (double) y2);
    setLineColor(corReta);
    setNameLineColor(corNome);
    setNameLine(nome);
  }

  public LineGr(PointGr x, PointGr y) {
    super(x, y);
    setLineColor(this.lineColor);
    setNameLineColor(this.nameLineColor);
    setNameLine("Generic Name");

  }

  public LineGr(LineGr reta, Color corReta, Color corNome, String nome) {
    super(reta);
    setLineColor(nameLineColor);
    setNameLineColor(corNome);
    setNameLine(nome);
  }

  /**
   * @param g
   */
  public void drawLine(Graphics g) {
    // y = a * x + b, a = line inclination
    double b, a, x, y;
    double beginX, endX, beginY, endY;
    PointGr point = new PointGr();

    beginX = getP1().getX();
    endX = getP2().getX();
    beginY = getP1().getY();
    endY = getP2().getY();

    if (getP1().getX() > getP2().getX()) {
      // Swap the coordinates
      beginX = getP2().getX();
      endX = getP1().getX();

    }
    if (getP1().getY() > getP2().getY()) {
      // Swap the coordinates
      beginY = getP2().getY();
      endY = getP1().getY();

    }

    double dy = endY - beginY;
    double dx = endX - beginX;
    // Vertical Line
    if (getP1().getX() == getP2().getX()) {
      a = 0;

      for (y = beginY; y <= endY; y++) {
        point.setX((int) beginX);
        point.setY((int) y);
        point.setPointColor(lineColor);
        point.drawPoint(g);
      }

      // Horizontal Line
    } else if (getP1().getY() == getP2().getY()) {

      y = beginY;
      for (x = beginX; x <= endX; x++) {
        point.setX((int) x);
        point.setY((int) y);
        point.setPointColor(lineColor);
        point.drawPoint(g);
      }

    } else {
      a = calculateInclination();
      // Calculate the linear term of the line
      b = calculateB();

      if (dy > dx) {
        for (y = beginY; y <= endY; y++) {
          x = (y - b) / a;
          x = Math.round(x);
          point.setX((int) x);
          point.setY((int) y);
          point.setPointColor(lineColor);
          point.drawPoint(g);
        }
      } else {
        for (x = beginX; x <= endX; x++) {
          y = a * x + b;
          y = Math.round(y);
          point.setX((int) x);
          point.setY((int) y);
          point.setPointColor(lineColor);
          point.drawPoint(g);

        }

      }
    }
  }

  public Color getLineColor() {
    return lineColor;
  }

  public void setLineColor(Color lineColor) {
    this.lineColor = lineColor;
  }

  public String getNameLine() {
    return nameLine;
  }

  public void setNameLine(String nameLine) {
    this.nameLine = nameLine;
  }

  public Color getNameLineColor() {
    return nameLineColor;
  }

  public void setNameLineColor(Color nameLineColor) {
    this.nameLineColor = nameLineColor;
  }
}
