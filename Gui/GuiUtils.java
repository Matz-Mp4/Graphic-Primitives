package Gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import Primitives2D.Point2D.Point;

/**
 * Class that handles data that is useful during the program and that is
 * frequently requested
 */
public class GuiUtils {

  // Gets the screen size
  private static Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
  

  private static Color background = Color.white;
  private static Color foreground = Color.black;

  public static Color getBackground() {
    return background;
  }

  public void setBackground(Color background) {
    this.background = background;
  }

  public static Dimension getDimScreen() {
    return dimScreen;
  }

  public static void setDimScreen(Dimension dimScreen) {
    GuiUtils.dimScreen = dimScreen;
  }

  public static Color getForeground() {
    return foreground;
  }

  public void setForeground(Color foreground) {
    this.foreground = foreground;
  }

  /**
   * 
   * @return a radom color
   */
  public static Color generateRandomColor() {
    int R = (int) (Math.random() * 256);
    int G = (int) (Math.random() * 256);
    int B = (int) (Math.random() * 256);

    return new Color(R, G, B);
  }

  /**
   * 
   * @return return the User's width screen
   */
  public static int getWidthScreen() {
    return (int) dimScreen.getWidth();
  }

  /**
   * 
   * @return return the User's height screen
   */
  public static int getHeightScreen() {
    return (int) dimScreen.getHeight();
  }

  public static void setShapeButton(Color colorB, Color colorF, JButton jbtn) {
    Border buttonStyle;
    Border levelAbove = BorderFactory.createRaisedBevelBorder();
    Border levelBelow = BorderFactory.createLoweredBevelBorder();

    jbtn.setBackground(colorB);
    jbtn.setForeground(colorF);

    buttonStyle = BorderFactory.createCompoundBorder(levelAbove, levelBelow);
    jbtn.setBorder(buttonStyle);
  }

  /**
   * Sets the color, numbers/tracks, titles and border of a JSlider
   * 
   * @param jslider JSlider
   * @param name    String
   */
  public static void setSliderHorizontal(JSlider jslider, String name) {
    jslider.setMajorTickSpacing(5);
    jslider.setMinorTickSpacing(1);
    jslider.setBackground(background);
    jslider.setForeground(foreground);
    jslider.setPaintTicks(true);
    jslider.setPaintLabels(true);
    Border Colorline = BorderFactory.createLineBorder(background);
    TitledBorder title = new TitledBorder(Colorline, name);
    title.setTitleColor(foreground);
    title.setTitleFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
    jslider.setBorder(title);
  }

  public static double calculateDistance(Point p1, Point p2) {
    double dY = p2.getY() - p1.getY();
    double dX = p2.getX() - p1.getX();
    double d = Math.sqrt(Math.pow(dY, 2) + Math.pow(dX, 2));

    return d;

  }

}
