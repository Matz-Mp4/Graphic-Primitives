import java.awt.Color;
import java.awt.Graphics;

public class LineGr extends Line {

  Color lineColor = Color.BLACK; // cor do ponto
  String nameLine = ""; // nome do ponto
  Color nameLineColor = Color.BLACK; // cor do nome (string) do ponto
  // public final int DIAMETRO = 1; // diametro do ponto, default = 1

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

  private void swapCord(double cord1, double cord2) {
    double swap = cord1;
    cord1 = cord2;
    cord2 = swap;
  }

  /**
   * @param g
   */
  public void drawLine(Graphics g) {
    // y = a * x + b, a = inclinação da reta
    double b, a, x, y;
    double begin, end;

    if (getP1().getX() > getP2().getX()) {
      swapCord(getP1().getX(), getP2().getX());

    } else if (getP1().getY() > getP2().getY()) {
      swapCord(getP1().getY(), getP2().getY());
    }

    begin = getP1().getX();
    end = getP2().getX();

    // Reta na vertical
    if (getP1().getX() == getP2().getX()) {
      a = 0;

      for (x = begin; x <= end; x++) {
        y = x;
        DotGr ponto = new DotGr((int) begin, (int) y, lineColor);
        ponto.drawDot(g);
      }

      // Reta na Horizontal
    } else if (getP1().getY() == getP2().getY()) {

      for (x = begin; x <= end; x++) {
        y = getP1().getY();
        DotGr ponto = new DotGr((int) x, (int) y, lineColor);
        ponto.drawDot(g);
      }

    } else {
      a = calculateInclination();
      b = calculateB();
      for (x = begin; x <= end; x++) {
        y = a * x + b;
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
