import java.awt.Color;
import java.awt.Graphics;

/**
 * Class that handles the graphic drawing of a point/pixel. To get started, it requires at least an x ​​and a y
 */
public class DotGr extends Dot {
  Color dotColor = Color.BLACK; //Default color 
  String dotName = ""; 
  Color dotNameColor = Color.BLACK; 
  public int diameter = 2; //Default diameter

  //Constructors
  DotGr(int x, int y) {
    super((double) x, (double) y);
    setDotColor(Color.black);
    setDotNameColor(Color.black);
    setDotName("");
  }

  DotGr(double x, double y, Color cor) {
    super(x, y);
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

    // Coordinates of the rectangle where the circle is inside it
    g.fillOval((int) (getX() - (getDiameter() / 2)), (int) (getY() - (getDiameter() / 2)), getDiameter(), getDiameter());

    // draw the spot name
    // g.setColor(getDotNameColor());
    // g.drawString(getDotName(), (int) getX() + getDiameter(), (int) getY());
  }

  /**
   * Gets the color of the dot/pixel
   * @return Color
   */
  public Color getDotColor() {
    return dotColor;
  }

  /**
   * Sets the color of the dot/pixel
   * @param dotColor
   */
  public void setDotColor(Color dotColor) {
    this.dotColor = dotColor;
  }

  /**
   * Gets the name of the dot/pixel
   * @return String
   */
  public String getDotName() {
    return dotName;
  }

  /**
   * Sets the name of the dot/pixel
   * @param dotName
   */
  public void setDotName(String dotName) {
    this.dotName = dotName;
  }

  /**
   * Gets the name color of the dot/pixel
   * @return Color
   */
  public Color getDotNameColor() {
    return dotNameColor;
  }

  /**
   * Sets the name color of the dot/pixel
   * @param dotNameColor
   */
  public void setDotNameColor(Color dotNameColor) {
    this.dotNameColor = dotNameColor;
  }

  /**
   * Gets the diameter of the dot/pixel
   * @return
   */
  public int getDiameter() {
    return diameter;
  }

  /**
   * Sets the diameter of the dot/pixel
   * @param diameter
  */
  public void setDiameter(int diameter) {
    this.diameter = diameter;
  }
}
