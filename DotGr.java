import java.awt.Color;
import java.awt.Graphics;

public class DotGr extends Dot {
  Color dotColor = Color.BLACK; // cor do ponto
  String dotName = ""; // nome do ponto
  Color dotNameColor = Color.BLACK; // cor do nome (string) do ponto
  public int diameter = 2; // diametro do ponto, default = 1

  DotGr(int x, int y) {
    super((double) x, (double) y);
    setDotColor(Color.black);
    setDotNameColor(Color.black);
    setDotName("");
  }

  DotGr(int x, int y, Color cor) {
    super((double) x, (double) y);
    setDotColor(cor);
    setDotNameColor(Color.black);
    setDotName("");
  }

  public DotGr(int x, int y, Color dotColor, int diameter) {
    this(x, y, dotColor);
    setDiameter(diameter);
  }

  public DotGr(int x, int y, Color dotColor, String dotName, int diameter) {
    this(x, y, dotColor, diameter);
    setDotName(dotName);
  }

  DotGr(int x, int y, Color cor, String str) {
    super((double) x, (double) y);
    setDotColor(cor);
    setDotNameColor(Color.black);
    setDotName(str);
  }

  DotGr(DotGr p2d, Color cor) {
    super(p2d);
    setDotColor(cor);
    setDotNameColor(Color.black);
    setDotName("");
  }

  DotGr() {
    super();
    setDotColor(Color.black);
    setDotNameColor(Color.black);
    setDotName("");
  }

  /**
   * desenha um ponto utilizando o oval
   * 
   * @param g contexto grafico
   */
  public void drawDot(Graphics g) {
    // desenha ponto como um oval
    g.setColor(getDotColor());

    // Precisa passar coordenadas do retangulo onde o circulo esta dentro dele
    g.fillOval((int) getX() - (getDiameter() / 2), (int) getY() - (getDiameter() / 2), getDiameter(), getDiameter());

    // desenha nome do ponto
    // g.setColor(getDotNameColor());
    // g.drawString(getDotName(), (int) getX() + getDiameter(), (int) getY());
  }

  public Color getDotColor() {
    return dotColor;
  }

  public void setDotColor(Color dotColor) {
    this.dotColor = dotColor;
  }

  public String getDotName() {
    return dotName;
  }

  public void setDotName(String dotName) {
    this.dotName = dotName;
  }

  public Color getDotNameColor() {
    return dotNameColor;
  }

  public void setDotNameColor(Color dotNameColor) {
    this.dotNameColor = dotNameColor;
  }

  public int getDiameter() {
    return diameter;
  }

  public void setDiameter(int diameter) {
    this.diameter = diameter;
  }
}
