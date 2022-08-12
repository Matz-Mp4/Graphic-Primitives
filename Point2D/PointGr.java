
package Point2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Class that handles the graphic drawing of a point/pixel. To get started, it requires at least an x ​​and a y
 */
public class PointGr extends Point {
  Color PointColor = Color.BLACK; //Default color 
  String PointName = ""; 
  Color PointNameColor = Color.BLACK; 
  public int diameter = 2; //Default diameter

  //Constructors
  PointGr(int x, int y) {
    super((double) x, (double) y);
    setPointColor(Color.black);
    setPointNameColor(Color.black);
    setPointName("");
  }

  PointGr(double x, double y, Color cor) {
    super(x, y);
    setPointColor(cor);
    setPointNameColor(Color.black);
    setPointName("");
  }

  public PointGr(int x, int y, Color PointColor, int diameter) {
    this(x, y, PointColor);
    setDiameter(diameter);
  }

  public PointGr(int x, int y, Color PointColor, String PointName, int diameter) {
    this(x, y, PointColor, diameter);
    setPointName(PointName);
  }

  PointGr(int x, int y, Color cor, String str) {
    super((double) x, (double) y);
    setPointColor(cor);
    setPointNameColor(Color.black);
    setPointName(str);
  }

  PointGr(PointGr p2d, Color cor) {
    super(p2d);
    setPointColor(cor);
    setPointNameColor(Color.black);
    setPointName("");
  }

  public PointGr() {
    super();
    setPointColor(Color.black);
    setPointNameColor(Color.black);
    setPointName("");
  }

  /**
   * desenha um ponto utilizando o oval
   * 
   * @param g contexto grafico
   */
  public void drawPoint(Graphics g) {
    // desenha ponto como um oval
    g.setColor(getPointColor());

    // Coordinates of the rectangle where the circle is inside it
    g.fillOval((int) (getX() - (getDiameter() / 2)), (int) (getY() - (getDiameter() / 2)), getDiameter(), getDiameter());

    // draw the spot name
    // g.setColor(getPointNameColor());
    // g.drawString(getPointName(), (int) getX() + getDiameter(), (int) getY());
  }

  /**
   * Gets the color of the Point/pixel
   * @return Color
   */
  public Color getPointColor() {
    return PointColor;
  }

  /**
   * Sets the color of the Point/pixel
   * @param PointColor
   */
  public void setPointColor(Color PointColor) {
    this.PointColor = PointColor;
  }

  /**
   * Gets the name of the Point/pixel
   * @return String
   */
  public String getPointName() {
    return PointName;
  }

  /**
   * Sets the name of the Point/pixel
   * @param PointName
   */
  public void setPointName(String PointName) {
    this.PointName = PointName;
  }

  /**
   * Gets the name color of the Point/pixel
   * @return Color
   */
  public Color getPointNameColor() {
    return PointNameColor;
  }

  /**
   * Sets the name color of the Point/pixel
   * @param PointNameColor
   */
  public void setPointNameColor(Color PointNameColor) {
    this.PointNameColor = PointNameColor;
  }

  /**
   * Gets the diameter of the Point/pixel
   * @return
   */
  public int getDiameter() {
    return diameter;
  }

  /**
   * Sets the diameter of the Point/pixel
   * @param diameter
  */
  public void setDiameter(int diameter) {
    this.diameter = diameter;
  }
}
