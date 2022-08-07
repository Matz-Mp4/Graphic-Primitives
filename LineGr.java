import java.awt.Color;
import java.awt.Graphics;

public class LineGr extends Line {

  Color lineColor = Color.BLACK; // cor do ponto
  String nameLine = ""; // nome do ponto
  Color nameLineColor = Color.BLACK; // cor do nome (string) do ponto

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

  public LineGr(DotGr x, DotGr y) {
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

  // private void swapCord() {
  // double swap;
  // swap = getP1().getX();
  // getP1().setX(getP2().getX());
  // getP2().setX(swap);
  // swap = getP1().getY();
  // getP1().setY(getP2().getY());
  // getP2().setY(swap);
  //
  // }

  /**
   * @param g
   */
  public void drawLine(Graphics g) {
    // y = a * x + b, a = inclinação da reta
    double b, a, x, y;
    double beginX, endX, beginY, endY;

    beginX = getP1().getX();
    endX = getP2().getX();
    beginY = getP1().getY();
    endY = getP2().getY();

    if (getP1().getX() > getP2().getX()) {
      beginX = getP2().getX();
      endX = getP1().getX();

    }
    if (getP1().getY() > getP2().getY()) {

      beginY = getP2().getY();
      endY = getP1().getY();

    }

    // Vertical Line
    if (getP1().getX() == getP2().getX()) {
      a = 0;

      for (y = beginY; y <= endY; y++) {
        DotGr ponto = new DotGr((int) beginX, (int) y, lineColor);
        ponto.drawDot(g);
      }

      // Horizontal Line
    } else if (getP1().getY() == getP2().getY()) {

      y = beginY;
      for (x = beginX; x <= endY; x++) {
        DotGr ponto = new DotGr((int) x, (int) y, lineColor);
        ponto.drawDot(g);
      }

    } else {
      a = calculateInclination();
      b = calculateB();
      for (y = beginY; y <= endY; y++) {
        // y = a * x + b
        x = (y - b) / a;
        x = Math.round(x);
        DotGr ponto = new DotGr((int) x, (int) y, lineColor);
        ponto.drawDot(g);
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
