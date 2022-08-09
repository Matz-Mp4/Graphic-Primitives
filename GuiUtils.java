import java.awt.*;

/**
 * Class that handles data that is useful during the program and that is frequently requested
 */
public class GuiUtils {

  //Gets the screen size 
  private static Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();

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
    return (int)dimScreen.getWidth();
  }

/**
   * 
   * @return return the User's height screen
   */
  public static int getHeightScreen() {
    return (int)dimScreen.getHeight();
  }

}
