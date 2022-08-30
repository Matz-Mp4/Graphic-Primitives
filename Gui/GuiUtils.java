package Gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

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

}
